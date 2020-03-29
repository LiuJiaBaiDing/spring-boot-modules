package com.bai.ding.common.aspect;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.common.collect.Lists;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.List;

/**
 * 统一处理访问日志
 * @author BaiDing
 * @date 2020/3/21 15:26
 */
@Component
@Aspect
public class ControllerAspect {

    private Logger logger= LoggerFactory.getLogger(ControllerAspect.class);
    private static final ObjectMapper MAPPER = new ObjectMapper().
            disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);

    public ControllerAspect(){}

    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping) || " +
            "@annotation(org.springframework.web.bind.annotation.GetMapping) || " +
            "@annotation(org.springframework.web.bind.annotation.PostMapping) || " +
            "@annotation(org.springframework.web.bind.annotation.PutMapping) ||" +
            "@annotation(org.springframework.web.bind.annotation.DeleteMapping) ||" +
            "@annotation(org.springframework.web.bind.annotation.PatchMapping)")
    public void pointcut(){}

    @Around("pointcut()")
    public Object logAspect(ProceedingJoinPoint point) throws Throwable{
        long start = System.currentTimeMillis();
        Object[] args = point.getArgs();
        Object result = null;
        ControllerAspect.LogContent content ;
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String uri = request.getRequestURI();
        String ip = request.getRemoteAddr();
        result = point.proceed();
        Object[] arguments = new Object[args.length];
        for (int i = 0; i < args.length; i++) {
            if (!(args[i] instanceof ServletRequest) && !(args[i] instanceof ServletResponse)) {
                if(args[i] instanceof MultipartFile ){
                    MultipartFile obj = (MultipartFile) args[i];
                    arguments[i] = obj.getOriginalFilename();
                }else{
                    arguments[i] = args[i];
                }
            }
        }
        content = new ControllerAspect.LogContent(System.currentTimeMillis() - start, arguments, result , uri, ip);
        logger.info(MAPPER.writeValueAsString(content));
        return result;
    }

    private class LogContent implements Serializable {

        private long consumed;
        private Object params;
        private Object result;
        private String url;
        private String ip;

        LogContent(long consumed, Object[] params, Object result, String url, String ip) {
            this.consumed = consumed;
            this.params = this.ignoreServletObjectInArgs(params);
            this.result = result;
            this.url = url;
            this.ip = ip;
        }

        public long getConsumed() {
            return consumed;
        }

        public Object getParams() {
            return params;
        }

        public Object getResult() {
            return result;
        }

        public String getUrl() {
            return url;
        }

        public String getIp() {
            return ip;
        }

        private Object ignoreServletObjectInArgs(Object[] params) {
            if (params == null || params.length == 0) {
                return null;
            } else {
                List<Object> args = Lists.newArrayList();
                int i = 0;

                for (int l = params.length; i < l; ++i) {
                    Object arg = params[i];
                    if (!(arg instanceof ServletRequest) && !(arg instanceof ServletResponse)) {
                        args.add(arg);
                    }
                }

                return args.size() == 1 ? args.get(0) : args;

            }
        }
    }
}
