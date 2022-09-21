package Home.Aspect;

import Home.Security.AuthFilter;
import Home.Security.Authcontroller;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.ThreadContext;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.UUID;

@Aspect
@Component
public class logging {

   Logger log= LoggerFactory.getLogger(logging.class);
    AuthFilter authFilter;
   @Pointcut(value = " execution(* Home.*.*(..) )")
   public void Mypointcut()
   {

   }
   @Around("Mypointcut()")
   public Object applicationlogger(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

       Instant start=Instant.now();
       ObjectMapper mapper=new ObjectMapper();

       String MethodName=proceedingJoinPoint.getSignature().getName();
    String ClassName=proceedingJoinPoint.getClass().toString();
    Object[] array=proceedingJoinPoint.getArgs();
log.info("method"+ClassName+":"+MethodName+"()"+"arguments:"+mapper.writeValueAsString(array));
Object object=proceedingJoinPoint.proceed();
        log.info(ClassName+":"+MethodName+"()"+"Response:"+mapper.writeValueAsString(object));
Instant finish=Instant.now();
       long timeplased= Duration.between(start,finish).toMillis();
       log.info(("Time taken ="+new SimpleDateFormat("mm:ss:SSS").format(new Date(timeplased))));
       return object;}

@AfterThrowing(pointcut = "Mypointcut()",throwing = "e")
public void logAfterThrowing(JoinPoint joinPoint,Throwable e)
{
    log.error("Excepition in {}.with case {}. with message {}",joinPoint.getSignature().getDeclaringTypeName(),joinPoint.getSignature().getName(),e.getCause() !=null
    ? e.getCause() : "null",
            e.getMessage() != null ? e.getMessage() :null);

}




}
