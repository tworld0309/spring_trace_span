package com.example;

import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.SpanBuilder;
import io.opentelemetry.api.trace.SpanContext;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.api.GlobalOpenTelemetry;
import org.slf4j.MDC;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TracingInterceptor implements HandlerInterceptor {

    private static final Tracer tracer = GlobalOpenTelemetry.getTracer("example-tracer");

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Span span = tracer.spanBuilder(request.getRequestURI()).startSpan();
        SpanContext spanContext = span.getSpanContext();

        // traceId와 spanId를 MDC에 추가하여 로그에 사용 가능하게 함
        MDC.put("traceId", spanContext.getTraceId());
        MDC.put("spanId", spanContext.getSpanId());

        // Span을 요청 속성에 저장하여 이후에도 사용할 수 있도록 함
        request.setAttribute("currentSpan", span);

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        Span span = (Span) request.getAttribute("currentSpan");
        if (span != null) {
            span.end();
        }
        MDC.clear();
    }
}
