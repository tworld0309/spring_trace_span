package com.example;

import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.trace.SdkTracerProvider;
import io.opentelemetry.sdk.trace.export.SimpleSpanProcessor;
import io.opentelemetry.exporter.logging.LoggingSpanExporter;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class OpenTelemetryInitializer implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        SdkTracerProvider tracerProvider = SdkTracerProvider.builder()
                .addSpanProcessor(SimpleSpanProcessor.create(new LoggingSpanExporter()))
                .build();

        OpenTelemetrySdk.builder()
                .setTracerProvider(tracerProvider)
                .buildAndRegisterGlobal();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
