package com.wang.controller;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.context.request.async.WebAsyncTask;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author wyt
 * @date 2023/1/9$
 * @description
 */

@RestController
@RequestMapping("/sync")
public class TestSyncResponse {


    private static Map<String, DeferredResult<String>> deferreds=new ConcurrentHashMap<>();


    @GetMapping("testDeferred")
    public DeferredResult<String> testDeferred(@RequestParam("msgId") String msgId) {
        DeferredResult<String> deferredResult = new DeferredResult<>();
        deferreds.put(msgId, deferredResult);
        return deferredResult;
    }
    /**
     * 定时任务
     */
    @Scheduled(fixedDelay = 5000)
    public void taskResp() {
        if(deferreds!=null && deferreds.size()>0) {
            deferreds.forEach((k,deferredResult)->{
                try {
                    deferredResult.setResult(k+"1234");
                    deferreds.remove(k);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            });
        }
    }




    @GetMapping("/greeting")
        public WebAsyncTask<byte[]> greeting(@RequestParam(value="name", defaultValue="World") String name) {

            Callable<byte[]> callable = new Callable<byte[]>() {

                @Override
                public byte[] call() throws Exception {
                    // TODO Auto-generated method stub
                    try {
                        //等待三秒，模拟耗时或阻塞操作
                        Thread.sleep(3000);
                        System.out.println("业务处理线程方法执行完毕时间 : "+System.currentTimeMillis()+"秒");
                        byte[] bs = "123456".getBytes();
                        return bs;
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    return null;
                }
            };


            System.out.println("请求处理线程方法执行完毕时间  : "+System.currentTimeMillis()+"秒");

            return new WebAsyncTask<byte[]>(callable);
        }

}
