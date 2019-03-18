package com.zgz.group.config.handler;

import com.google.gson.Gson;
import com.zgz.group.bean.BaseResponse;
import com.zgz.group.constant.AppConstant;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 用户未登录返回信息
 */
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.setCharacterEncoding(SecurityConstant.JSON_CONTENT_TYPE);
        response.setContentType(AppConstant.ENCODE);

        //TODO 后续优化在JsonUtil内
        Gson gson = new Gson();
        BaseResponse successResponse = BaseResponse.ERROR_RESPONSE;
        String error = gson.toJson(successResponse);

        PrintWriter out = response.getWriter();
        out.write(error);
        out.close();
        out.flush();
    }
}
