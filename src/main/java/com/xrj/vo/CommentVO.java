package com.xrj.vo;

import com.alibaba.fastjson.JSONObject;
import com.xrj.pojo.Comment;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class CommentVO extends Comment{

	/**
	 * 用户操作类型，详见msgActionTypeEnum
	 */
	private Integer actionType;
	
	/**
	 * 当前用户树木
	 */
	private Integer currentUserNums;
	
	/**
	 * auth-token
	 */
	private String authToken;
	
	//user
	/**
     * 用户登陆名称(登陆)
     */
    private String username;

    /**
     * 用户显示名称
     */
    private String nickname;

    /**
     * 头像
     */
    private String avatar;
	
	public static void main(String[] args) {
		CommentVO commentVO = new CommentVO();
		commentVO.setAuthToken("eyJhbGciOiJIUzUxMiJ9.eyJwaG9uZSI6IjE4MTQwMjEyMDM4IiwiY3JlYXRlZCI6MTU0MDE5OTgwMzgzMywiZXhwIjoxNTQyNzkxODAzLCJ1dWlkIjoiOTI5NGNmYWEtYmRhNC00NDI5LWJhMjEtZDMzOGY2MmM4NzQ4IiwidXNlcmlkIjoxLCJlbWFpbCI6IiIsInVzZXJuYW1lIjpudWxsfQ.1QDZamcuSUtWp_uEavU3hH7vY9QF6PPqNhbMehjszciPbU0rKR44DuziD4DDDxvHWFjUlScP0FIt6-qWDFgEVw");
		commentVO.setActionType(2);
		commentVO.setContent("挺好的呀!");
		commentVO.setArticleUuid("6ec7a046-b41b-404d-8184-131134778d28");
		System.out.println(JSONObject.toJSONString(commentVO));;
	}
}
