package com.xrj.filter;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

import com.alibaba.fastjson.JSONObject;
import com.xrj.common.Const;
import com.xrj.common.ServerResponse;
import com.xrj.exception.ErrorCodeEnum;
import com.xrj.exception.JwtAuthException;
import com.xrj.pojo.User;
import com.xrj.util.JwtTokenUtil;
import com.xrj.util.JwtUser;

import lombok.extern.slf4j.Slf4j;

/**
 * 获取_token的拦截起
 *
 * @author crixus
 */
@Slf4j
@WebFilter
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String authHeader = request.getHeader(Const.TOKEN_HEADER);
        System.out.println(authHeader);
        OutputStream out = null;
        try {
            User user = null;
            if (authHeader != null) {
                JwtTokenUtil jwtTokenUtil = new JwtTokenUtil();
                JwtUser jwtUser = jwtTokenUtil.getJwtUser(authHeader);
                //只有验证失败的情况下抛出异常，不存在的时候交由业务具体判断处理
                if (jwtUser == null || !jwtTokenUtil.validateToken(authHeader, jwtUser)) {
                    throw new JwtAuthException();
                }
                user = new User();
                user.setUsername(jwtUser.getUsername());
                user.setLastUpdatePasswordTime(jwtUser.getLastPasswordResetDate());
                user.setUid(jwtUser.getId().intValue());
                user.setUserUuid(jwtUser.getUuid());
                user.setMobile(jwtUser.getPhone());
                log.debug("用户 {} 成功登录", user.getUserUuid());
            }
            request.setAttribute(Const.USER_HAVE_AUTH, user);
            filterChain.doFilter(request, response);

        } catch (JwtAuthException e) {
            log.error("用户验证失败");
            response.setContentType("application/json; charset=utf-8");
            response.setCharacterEncoding("UTF-8");
            String errorMsg = JSONObject.toJSONString(ServerResponse.createByOtherErrorResReturnMsg(ErrorCodeEnum.USER_AUTH_TOKEN_FAILURE.getCode(),
                    ErrorCodeEnum.USER_AUTH_TOKEN_FAILURE.getErrorMsg()));
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
