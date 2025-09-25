package com.truper.demo.Exception;

public class OrdersException extends Exception{

    public OrdersException(int code, String mensaje){
        super(mensaje);
    }
}
