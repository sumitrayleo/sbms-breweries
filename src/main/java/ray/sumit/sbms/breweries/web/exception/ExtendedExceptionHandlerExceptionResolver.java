package ray.sumit.sbms.breweries.web.exception;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.method.annotation.ExceptionHandlerMethodResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;
import org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

public class ExtendedExceptionHandlerExceptionResolver extends ExceptionHandlerExceptionResolver {

    private Object handler;
    private ExceptionHandlerMethodResolver methodResolver;

    public void setExceptionHandler(Object handler) {
        this.handler = handler;
        this.methodResolver = new ExceptionHandlerMethodResolver(handler.getClass());
    }

    @Override
    protected ServletInvocableHandlerMethod getExceptionHandlerMethod(HandlerMethod handlerMethod, Exception exception) {
        ServletInvocableHandlerMethod result = super.getExceptionHandlerMethod(handlerMethod, exception);
        if (result != null) {
            return result;
        }
        Method method = this.methodResolver.resolveMethod(exception);
        return (method != null) ? new ServletInvocableHandlerMethod(this.handler, method) : null;
    }

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        return super.resolveException(request, response, handler, ex);
    }
}
