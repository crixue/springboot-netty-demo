package com.xrj.enums;

import com.xrj.common.Const;

public enum LoginTokenEnum {
	NOT_LOGIN(0, Const.DEVICE_TOKEN),
	LOGIN(1, Const.USER_HAVE_AUTH);
	
	private final int type;
	private final String desc;
	
	private LoginTokenEnum(int type, String desc) {
		this.type = type;
		this.desc = desc;
	}
	public int getType() {
		return type;
	}
	public String getDesc() {
		return desc;
	}
	
	public static boolean isExistsLoginTokenEnum(Integer type) {
		for (LoginTokenEnum one : LoginTokenEnum.values()) {
			if (one.getType() == type) {
				return true;
			}
		}
		return false;
	}
	
}
