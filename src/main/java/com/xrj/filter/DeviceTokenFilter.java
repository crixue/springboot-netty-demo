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
import com.xrj.exception.ErrorCodeEnum;
import com.xrj.exception.JwtAuthException;

import lombok.extern.slf4j.Slf4j;

/**
 * 获取deviceToken的拦截器
 *
 * @author crixus
 */
@Slf4j
@WebFilter
public class DeviceTokenFilter extends OncePerRequestFilter {
	
//	private static final ImmutableSet<String> excludePaths = ImmutableSet.of("/upload", "/index.jsp","/druid","/articleTitles/list","/pageType/list");
	
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String authHeader = request.getHeader(Const.DEVICE_TOKEN);
        OutputStream out = null;
        try {
            if (StringUtils.isNotBlank(authHeader)) {
                request.setAttribute(Const.DEVICE_TOKEN, authHeader);
                filterChain.doFilter(request, response);
            } else {
            	throw new JwtAuthException();
            }
        } catch (JwtAuthException e) {
            log.error("用户获取DEVICE_TOKEN失败");
            response.setContentType("application/json; charset=utf-8");
            response.setCharacterEncoding("UTF-8");
            String errorMsg = JSONObject.toJSONString(ServerResponse.createByOtherErrorResReturnMsg(ErrorCodeEnum.USER_DEVICE_TOKEN_FAILURE.getCode(),
                    ErrorCodeEnum.USER_DEVICE_TOKEN_FAILURE.getErrorMsg()));
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
