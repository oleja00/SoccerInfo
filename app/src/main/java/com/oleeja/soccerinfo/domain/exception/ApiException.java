package com.oleeja.soccerinfo.domain.exception;

/**
 * Created by Oleja on 30.01.2018.
 */

public class ApiException extends Exception {

    private int mCode;

    public ApiException(int code, String message) {
        super(message);
        mCode = code;
    }

    public int getCode() {
        return mCode;
    }
}