package com.kimYH.springweb.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
//SpringConfig 에 Bean 으로 등록하거나 이곳에 @Component 걸거나.
@Component
public class TimeTraceAop {

    @Around("execution(* com.kimYH.springweb..*(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("START: " + joinPoint.toString());
        try {
            return joinPoint.proceed();
        } finally {
            {
                long finish = System.currentTimeMillis();
                long timeMs = finish - start;
                System.out.println("END: " + joinPoint.toString() + " " + timeMs + "ms");
            }
        }
    }
}
