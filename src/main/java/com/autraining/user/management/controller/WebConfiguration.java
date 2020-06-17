package com.autraining.user.management.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.data.web.config.PageableHandlerMethodArgumentResolverCustomizer;

import static org.springframework.data.domain.Sort.Direction.fromString;

@Configuration
@EnableSpringDataWebSupport
public class WebConfiguration {

    @Bean
    public PageableHandlerMethodArgumentResolverCustomizer customizer(
        @Value("${app.search.pageSize}") int defaultPageSize,
        @Value("${app.search.page}") int defaultPage,
        @Value("${app.search.maxSize}") int maxSize,
        @Value("${app.search.sort.by}") String sortBy,
        @Value("${app.search.sort.direction}") String direction) {
        return pageableResolver -> {
            pageableResolver.setSizeParameterName("pageSize");
            pageableResolver.setMaxPageSize(maxSize);
            pageableResolver
                .setFallbackPageable(PageRequest.of(defaultPage, defaultPageSize, Sort.by(fromString(direction), sortBy)));
        };
    }
}
