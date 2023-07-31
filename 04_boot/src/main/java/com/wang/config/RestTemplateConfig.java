package com.wang.config;

import org.apache.http.client.HttpClient;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate(@Qualifier("clientHttpRequestFactory") ClientHttpRequestFactory factory) {
        return new RestTemplate(factory);
    }

    /**
     * 请求连接池配置
     *
     * @return
     */
    @Bean
    public ClientHttpRequestFactory clientHttpRequestFactory(HttpClient httpClient) {
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        //httpClient创建器
        factory.setHttpClient(httpClient);
        //数据读取超时时间
        factory.setReadTimeout(60000);
        //连接超时时间
        factory.setConnectTimeout(60000);
        //连接池获取请求连接的超时时间
        factory.setConnectionRequestTimeout(60000);
        return factory;
    }

    /**
     * httpClient
     *
     * @param poolingHttpClientConnectionManager
     * @return
     */
    @Bean
    public HttpClient httpClient(HttpClientConnectionManager poolingHttpClientConnectionManager) {
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();

        //设置http连接管理器
        httpClientBuilder.setConnectionManager(poolingHttpClientConnectionManager);

        //设置重试次数
//        httpClientBuilder.setRetryHandler(new DefaultHttpRequestRetryHandler(3,true));

        //设置默认请求头
//        List<Header> headers = new ArrayList<>();
//        headers.add(new BasicHeader("Connection","Keep-Alive"));
//        httpClientBuilder.setDefaultHeaders(headers);

        return httpClientBuilder.build();
    }


    /**
     * http连接管理器
     *
     * @return
     */
    @Bean
    public HttpClientConnectionManager poolingHttpClientConnectionManager() {
        //注册http和https请求
        Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create()
                .register("http", PlainConnectionSocketFactory.getSocketFactory())
                .register("https", SSLConnectionSocketFactory.getSocketFactory())
                .build();

        PoolingHttpClientConnectionManager poolingHttpClientConnectionManager = new PoolingHttpClientConnectionManager(registry);

        //最大连接数
        poolingHttpClientConnectionManager.setMaxTotal(1000);
        //同路由并发数（每个主机的并发）
        poolingHttpClientConnectionManager.setDefaultMaxPerRoute(500);
        return poolingHttpClientConnectionManager;
    }

}