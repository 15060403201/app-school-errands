package com.FJNU.seed.model;

public class OrderInfo {
    private String orderid;
    private String account;
    private String name;
    private String phone;
    private String address0;
    private String quantity;
    private String address1;
    private String detail;
    private String price;

    public String getOrderid() {
        return orderid;
    }
    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getAccount() {
        return account;
    }
    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress0() {
        return address0;
    }
    public void setAddress0(String address0) {
        this. address0= address0;
    }

    public String getQuantity() {
        return quantity;
    }
    public void setQuantity(String quantity) {
        this.quantity= quantity;
    }

    public String getAddress1() {
        return address1;
    }
    public void setAddress1(String address1) {
        this. address1= address1;
    }

    public String getDetail() {
        return detail;
    }
    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "{orderid:" + orderid + ", account:" + account + ", name:" + name + ", phone:" + phone + ", address0:" + address0 +  ", quantity:" + quantity + ", address1:" + address1 + ", detail:" + detail + ", price:" + price +"}";
    }
}
