package Home.Aspect;

import Home.Security.AuthFilter;
import Home.Security.Authcontroller;
import org.apache.logging.log4j.ThreadContext;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

public class loggingInterceptor implements HandlerInterceptor {

   @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        ThreadContext.put("request id", UUID.randomUUID().toString());

System.out.println(     Thread.currentThread().getName());
        System.out.println(ThreadContext.getContext());
        return true;}

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        ThreadContext.clearAll();
    }
}
