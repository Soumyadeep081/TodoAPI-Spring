package com.example.todoapispring;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeMonitorAspect {

    @Around("@annotation(TimeMonitor)")
    public Object logtime(ProceedingJoinPoint joinPoint) {
        long start = System.currentTimeMillis(); // start time of the code

        Object result = null;
        try {
            result = joinPoint.proceed();
        } catch (Throwable e) {
            System.out.println("Something went wrong during the execution.");
        } finally {
            long end = System.currentTimeMillis(); // end time of the code

            System.out.println("Execution Time: " + (end - start) + " ms");

            return result;
        }
    }

}
