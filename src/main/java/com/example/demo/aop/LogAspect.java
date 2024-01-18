package com.example.demo.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author meow
 */
@Slf4j
@Aspect
@Component
public class LogAspect {

    @Pointcut("execution(* com.example.demo.controller..*.*(..))")
    public void controllerPointcut() {
    }

    @Before("controllerPointcut()")
    public void loggingController(final JoinPoint joinPoint) {
        Optional.ofNullable(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()))
                .map(ServletRequestAttributes::getRequest).ifPresent(
                        request -> {
                            String[] paramNames = ((MethodSignature) joinPoint.getSignature()).getParameterNames();
                            Object[] paramValues = joinPoint.getArgs();
                            int length = paramNames.length;
                            String paramStr = IntStream.range(0, length)
                                    .mapToObj(i -> new StringBuilder()
                                            .append(paramNames[i])
                                            .append(": ")
                                            .append(paramValues[i]))
                                    .collect(Collectors.joining(", "));
                            log.info("API: {}, method: {},params: [{}]", request.getRequestURI(), request.getMethod(), paramStr);
                        }
                );
    }
}
