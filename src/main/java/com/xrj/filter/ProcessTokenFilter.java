package com.xrj.filter;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.alibaba.fastjson.JSONObject;
import com.xrj.common.Const;
import com.xrj.common.ServerResponse;
import com.xrj.enums.LoginTokenEnum;
import com.xrj.exception.ErrorCodeEnum;
import com.xrj.exception.JwtAuthException;
import com.xrj.pojo.LoginToken;
import com.xrj.pojo.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebFilter
public class ProcessTokenFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		OutputStream out = null;
		
		try {
			LoginToken loginToken = new LoginToken();
			
			User user = (User) request.getAttribute(Const.USER_HAVE_AUTH) ;
			String token = StringUtils.EMPTY;
			Integer type = LoginTokenEnum.LOGIN.getType();
			if (user == null) {
				token = (String) request.getAttribute(Const.DEVICE_TOKEN);
				type = LoginTokenEnum.NOT_LOGIN.getType();
				
				loginToken.setDeviceToken(token);
			} else {
				
				loginToken.setUser(user);
			}
			loginToken.setLoginType(type);
			request.setAttribute(Const.LOGIN_SYMBOL, loginToken);
			
//			if (StringUtils.isBlank(token) && user == null) {
//				throw new JwtAuthException();
//			}
			
			filterChain.doFilter(request, response);
		} catch (JwtAuthException e) {
			log.error("用户的_token和 device_token都不存在");
			response.setContentType("application/json; charset=utf-8");
			response.setCharacterEncoding("UTF-8");
			
			String errorMsg = JSONObject.toJSONString(ServerResponse.createByOtherErrorResReturnMsg(ErrorCodeEnum.USER_AUTH_TOKEN_AND_DEVICE_TOKEN_BOTH_NULL.getCode(),
					ErrorCodeEnum.USER_AUTH_TOKEN_AND_DEVICE_TOKEN_BOTH_NULL.getErrorMsg()));
			out = response.getOutputStream();
            out.write(errorMsg.getBytes("UTF-8"));
            out.flush();
		} finally {
			if (out != null) {
				out.close();
			}
		}
    	

	}

}
