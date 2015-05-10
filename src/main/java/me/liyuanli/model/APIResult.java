package me.liyuanli.model;

import me.liyuanli.enums.APIErrorEnum;
import me.liyuanli.exceptions.APIErrorException;

/**
 * Created by
 * User: xiaomi
 * Date: 5/10/15
 * Time: 1:35 AM
 */
public class APIResult <T> {
    private Integer status;
    private String message;
    private T data;

    public APIResult(Integer status, String message) {
        this.status = status;
        this.message = message;
        this.data = null;
    }

    public APIResult(APIErrorException e) {
        this.status = e.getValue();
        this.message = e.getMessage();
        this.data = null;
    }

    public APIResult(T data) {
        this.data = data;
        this.status = APIErrorEnum.SUCCESS.getValue();
        this.message = APIErrorEnum.SUCCESS.getMessage();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
