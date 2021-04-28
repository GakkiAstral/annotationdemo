package com.bjsxt.pojo;

public class Orders {
    private int orderid;
    private double orderprice;

    @Override
    public String toString() {
        return "Orders{" +
                "orderid=" + orderid +
                ", orderprice=" + orderprice +
                '}';
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public double getOrderprice() {
        return orderprice;
    }

    public void setOrderprice(double orderprice) {
        this.orderprice = orderprice;
    }
}
