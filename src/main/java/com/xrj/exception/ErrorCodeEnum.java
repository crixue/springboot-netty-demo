package com.xrj.exception;

public enum ErrorCodeEnum {
	
	SUCCESS(200, "OK"),
	ERROR(1, "ERROR"),
	DATA_ENTRY_FAIURE(2, "数据录入失败"),
	USER_NOT_LOGIN(3, "用户未登录"),
	USER_TOKEN_GENERATE_FAILURE(4, "用户token生成失败，请刷新后重试"),
	USER_AUTH_TOKEN_FAILURE(5, "用户token认证失败，请重新登录后重试"),
	USER_DEVICE_TOKEN_FAILURE(6, "用户device_token获取失败，请重新传值"),
	USER_AUTH_TOKEN_AND_DEVICE_TOKEN_BOTH_NULL(7, "用户的device_token和_token都为空"),
	
	USER_BANED(101, "检验次数太多 IP已被封禁"),
	
	PHONE_HAVE_BEEN_REGISTERED(201, "该电话号码已经注册"),
	USER_IDENTIFY_CODE_TYPE_NOT_EXISTS(202, "验证码类型不支持"),
	
	
	ARTICLE_NOT_EXISTS(1201, "稿件不存在"),
	VIDEO_ORDERBY_NOT_EXISTS(1202, "视频排序类型不存在"),
	
	HAVE_ZANED(1401, "已经点过赞了，请勿重复点赞"),
	HAVE_CANCEL_ZANED(1402, "已经取消点赞，请勿重复取消点赞"),
	
	COMMENT_TOO_FAST(1601, "一分钟最多能为一条媒资评论不可超过3条"),
	COMMENT_TYPE_NOT_EXISTS(1602, "评论类型不存在"),
	TOP_10_TYPE_NOT_EXISTS(2101, "top10类型不存在")
	;
	
	
    private int code;
    private String errorMsg;

    ErrorCodeEnum(int code, String errorMsg) {
        this.code = code;
        this.errorMsg = errorMsg;
    }

    public int getCode() {
        return code;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
