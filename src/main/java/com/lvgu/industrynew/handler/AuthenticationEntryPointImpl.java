package com.lvgu.industrynew.handler;

import com.alibaba.fastjson.JSON;
import com.lvgu.industrynew.domain.Result;
import com.lvgu.industrynew.utils.WebUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 认证失败返回值设置
 */
@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        Result result = new Result().error(HttpStatus.UNAUTHORIZED.value(),authException.getMessage());
        String str = JSON.toJSONString(result);
        WebUtils.renderString(response,str);
    }
}
