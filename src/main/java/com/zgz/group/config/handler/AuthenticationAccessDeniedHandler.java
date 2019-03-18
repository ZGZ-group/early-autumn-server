package com.zgz.group.config.handler;

import com.google.gson.Gson;
import com.zgz.group.bean.BaseResponse;
import com.zgz.group.constant.AppConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 权限不足处理
 */
@Component
public class AuthenticationAccessDeniedHandler implements AccessDeniedHandler {

    private static Logger logger = LoggerFactory.getLogger(AuthenticationAccessDeniedHandler.class);

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse resp, AccessDeniedException e) throws IOException, ServletException {
        resp.setStatus(HttpServletResponse.SC_FORBIDDEN);
        resp.setCharacterEncoding(AppConstant.ENCODE);
        resp.setContentType(SecurityConstant.JSON_CONTENT_TYPE);

        //TODO 后续优化在JsonUtil内
        Gson gson = new Gson();
        BaseResponse errorResponse = BaseResponse.newErrorResponse("权限不足！请联系管理员");
        String error = gson.toJson(errorResponse);

        PrintWriter out = resp.getWriter();
        out.write(error);
        out.close();
        out.flush();

    }

}
