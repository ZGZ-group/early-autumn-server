package com.zgz.group.config.security;

import com.google.gson.Gson;
import com.zgz.group.util.JsonUtil;
import com.zgz.group.bean.BaseResponse;
import com.zgz.group.config.jwt.JWTUtil;
import com.zgz.group.constant.AppConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 登录成功
 */
@Component
public class LoginAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    private static Logger logger = LoggerFactory.getLogger(LoginAuthenticationSuccessHandler.class);

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws ServletException, IOException {

        String username = authentication.getName();
        response.addHeader(SecurityConstant.HEADER, JWTUtil.builderToken(username));
        response.setStatus(HttpServletResponse.SC_OK);
        response.setCharacterEncoding(AppConstant.ENCODE);
        response.setContentType(SecurityConstant.JSON_CONTENT_TYPE);


        logger.info("用户[{]]登录成功!", username);
        BaseResponse successResponse = BaseResponse.SUCCESS_RESPONSE;
        String success = JsonUtil.toJson(successResponse);

        PrintWriter out = response.getWriter();
        out.write(success);
        out.close();
        out.flush();
    }

}
