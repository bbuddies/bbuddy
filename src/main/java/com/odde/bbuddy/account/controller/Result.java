package com.odde.bbuddy.account.controller;

/**
 * Created by zbcjackson on 9/26/16.
 */
public class Result<T> {
    private T message;

    public void set(T message) {

        this.message = message;
    }

    public T get() {
        return this.message;
    }
}
