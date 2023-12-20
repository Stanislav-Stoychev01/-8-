package com.PISZaverka.demo.Payload.Request;

public class Order_AvailableShoesRequest extends AvailableShoesRequest {

    private String user_name;
    private Integer quantity;


    public String getUser_name() {
        return user_name;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
