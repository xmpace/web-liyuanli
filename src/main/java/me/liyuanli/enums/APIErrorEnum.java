package me.liyuanli.enums;

/**
 * Created by
 * User: xiaomi
 * Date: 5/10/15
 * Time: 1:37 AM
 */
public enum APIErrorEnum {
    SUCCESS(0, "success"),

    PARAM_ERROR(10001, "参数错误"),

    NICK_NAME_BLANK_ERROR(10101, "昵称不能为空"),
    NICK_NAME_ALREADY_EXISTS_ERROR(10102, "昵称已存在"),

    PASSWORD_LENGTH_ERROR(10201, "密码必须大于6个字符小于16个字符"),
    PASSWORD_ERROR(10202, "密码错误"),

    LOGIN_ALREADY_EXISTS_ERROR(10301, "该登录名已存在"),
    LOGIN_NOT_EXISTS_ERROR(10302, "该登录名不存在");

    private Integer value;
    private String message;

    private APIErrorEnum(Integer value, String message) {
        this.value = value;
        this.message = message;
    }

    public Integer getValue() {
        return value;
    }

    public String getMessage() {
        return message;
    }
}
