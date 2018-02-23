package com.gwf.weather.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
/**
 * @author gaowenfeng
 * @package com.gwf.gwf.weather.basic.config
 * @describe web配置
 * @date 2018/2/20
 */
@Component
public class SpringExceptionResolver implements HandlerExceptionResolver {

    private static ObjectMapper objectMapper = new ObjectMapper();


    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        String url = request.getRequestURL().toString();
        //TODO 根据自定义异常跳转
        log.error("unknown page exception, url:" + url, ex);
        ModelAndView mv = new ModelAndView("exception/500");
        mv.addObject("msg", ex.getMessage());
        return mv;
    }
}
