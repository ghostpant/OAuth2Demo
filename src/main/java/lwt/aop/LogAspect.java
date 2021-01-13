package lwt.aop;

import lwt.utls.RandomIdSecertUtil;
import org.apache.log4j.MDC;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.CodeSignature;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
public class LogAspect {

    @Pointcut(value = "execution(* lwt.controller.*.*(..))")
    public void logPointCut() {
    }


    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        Map<String, Object> nameAndValue = getNameAndValue(point);
        String trace = (String) nameAndValue.getOrDefault("trace", RandomIdSecertUtil.getTrace());
        MDC.put("trace", trace);
        Object proceed = point.proceed();
        MDC.remove(trace);
        return proceed;
    }

    Map<String, Object> getNameAndValue(ProceedingJoinPoint joinPoint) {
        HashMap<String, Object> params = new HashMap<>();
        //参数值
        Object[] args = joinPoint.getArgs();
        //参数名
        String[] parameterNames = ((CodeSignature) joinPoint.getSignature()).getParameterNames();

        for (int i = 0; i < parameterNames.length; i++) {
            params.put(parameterNames[i], args[i]);
        }
        return params;
    }
}
