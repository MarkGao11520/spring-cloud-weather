package com.gwf.gwf.weather.basic.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gwf.gwf.weather.basic.exception.ParamException;
import com.gwf.gwf.weather.basic.vo.WeatherResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
/**
 * @author gaowenfeng
 * @package com.gwf.gwf.weather.basic.config
 * @describe web配置
 * @date 2018/2/20
 */
@Component
public class SpringExceptionResolver implements HandlerExceptionResolver {

    private static final String PAGE = "/page";
    private static ObjectMapper objectMapper = new ObjectMapper();


    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        String url = request.getRequestURL().toString();
        ModelAndView mv = null;
        String defaultMsg = "System error";

        try {
            // 这里我们要求项目中所有请求json数据，都使用.json结尾
            if (url.endsWith(PAGE)){
                // 这里我们要求项目中所有请求page页面，都使用.page结尾
                log.error("unknown page exception, url:" + url, ex);
                WeatherResponse result = WeatherResponse.builder().status(500).desc(defaultMsg).build();
                mv = new ModelAndView("exception", result.toMap());
            } else {
                if (ex instanceof ParamException) {
                    WeatherResponse result = WeatherResponse.builder().status(400).desc(ex.getMessage()).build();
                    response.getWriter().write(objectMapper.writeValueAsString(result));
                } else{
                    log.error("unknown json exception, url:" + url, ex);
                    WeatherResponse result = WeatherResponse.builder().status(500).desc(ex.getMessage()).build();
                    response.getWriter().print(objectMapper.writeValueAsString(result));
                }
                return null;
            }
        } catch (IOException e) {
            log.error("unknown exception");
        }
        return mv;
    }
}
