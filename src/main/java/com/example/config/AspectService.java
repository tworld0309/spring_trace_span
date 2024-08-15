package com.example.config;

import io.opentelemetry.api.GlobalOpenTelemetry;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.Tracer;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectService {

    private static final Tracer tracer = GlobalOpenTelemetry.getTracer("service-tracer");

    @Around("execution(* com.example.*.service.*.*(..))")
    public Object traceServiceMethods(ProceedingJoinPoint joinPoint) throws Throwable {
        Span span = tracer.spanBuilder(joinPoint.getSignature().getName()).startSpan();
        try {
            MDC.put("spanId", span.getSpanContext().getSpanId());
            return joinPoint.proceed();
        } finally {
            span.end();
            MDC.remove("spanId");
        }
    }
}