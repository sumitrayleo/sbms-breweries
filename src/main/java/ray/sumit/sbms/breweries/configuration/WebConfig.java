package ray.sumit.sbms.breweries.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.annotation.ResponseStatusExceptionResolver;
import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver;
import ray.sumit.sbms.breweries.web.exception.ExtendedExceptionHandlerExceptionResolver;
import ray.sumit.sbms.breweries.web.exception.GlobalExceptionHandler;

import java.util.List;

@Configuration
public class WebConfig extends WebMvcConfigurationSupport {

    @Bean
    public GlobalExceptionHandler globalExceptionHandler() {
        GlobalExceptionHandler globalExceptionHandler = new GlobalExceptionHandler();
        return globalExceptionHandler;
    }

    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
        ExtendedExceptionHandlerExceptionResolver customResolver = new ExtendedExceptionHandlerExceptionResolver();
        customResolver.setExceptionHandler(globalExceptionHandler());
        customResolver.setMessageConverters(getMessageConverters());
        customResolver.afterPropertiesSet();

        exceptionResolvers.add(customResolver);
        exceptionResolvers.add(new ResponseStatusExceptionResolver());
        exceptionResolvers.add(new DefaultHandlerExceptionResolver());
    }
}
