package com.wang.juc.test1;

/**
 * @author wyt
 * @date 2023/9/21 21:47
 * @description
 */
public class SellTicket{

    private int tickets = 20;


    /**
    * @Author: wyt
    * @Description: 卖票
    * @DateTime: 2023/9/21 21:49
    */
    public void sell() {
        System.out.println(Thread.currentThread().getName() + "开始卖第【" + (21 - tickets) + "】张票");
        tickets -- ;
    }

    public int getTickets() {
        return tickets;
    }

    public void setTickets(int tickets) {
        this.tickets = tickets;
    }

    public SellTicket() {
    }
}
