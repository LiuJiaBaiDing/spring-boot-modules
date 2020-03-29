package com.bai.ding.common.interceptor;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.bai.ding.common.constant.BackendEnumConstant;
import com.bai.ding.common.exception.JwtException;
import com.bai.ding.common.util.JwtUtil;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

/**
 * @author BaiDing
 * @date 2020/3/22 21:11
 */
@Component
public class JwtInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
//        对那些可能对服务器数据产生副作用的 HTTP 请求方法（特别是 GET 以外的 HTTP 请求，或者搭配某些 MIME 类型的 POST 请求），
//        浏览器必须首先使用 OPTIONS 方法发起一个预检请求（preflight request），
//        从而获知服务端是否允许该跨域请求。服务器确认允许之后，才发起实际的 HTTP 请求。
        if (HttpMethod.OPTIONS.matches(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
            return true;
        }
        String token = request.getHeader("Authorization");
        if(StrUtil.isBlank(token)){
            throw new JwtException(BackendEnumConstant.ResultCodeEnum.NULL_TOKEN);
        }
        JwtUtil.checkJwt(token);
        return true;
    }
}
