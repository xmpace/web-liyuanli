package me.liyuanli.exceptions;

import me.liyuanli.enums.APIErrorEnum;

/**
 * Created by
 * User: xiaomi
 * Date: 5/10/15
 * Time: 3:25 PM
 */
public class APIErrorException extends Exception {
    private Integer value;
    private String message;

    public APIErrorException(APIErrorEnum apiErrorEnum) {
        this.value = apiErrorEnum.getValue();
        this.message = apiErrorEnum.getMessage();
    }

    public APIErrorException(Integer value, String message) {
        this.value = value;
        this.message = message;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
