package com.xrj.pojo;

import org.apache.commons.lang3.StringUtils;

import com.xrj.enums.LoginTokenEnum;

import lombok.Data;
import lombok.Setter;

@Data
public class LoginToken {

    /**
     * 0-未登录用户，deviceToken应该有值
     * 1-登录用户，user应该有值
     */
    private Integer loginType;

    private String deviceToken;

    private User user;

    @Setter
    private String finalToken;

    public String getFinalToken() {
        if (loginType == LoginTokenEnum.LOGIN.getType()) {
            return user.getUserUuid();
        } else if (loginType == LoginTokenEnum.NOT_LOGIN.getType()) {
            return deviceToken;
        } else {
            return StringUtils.EMPTY;
        }
    }

    public Integer getLoginType() {
        return loginType;
    }

}
