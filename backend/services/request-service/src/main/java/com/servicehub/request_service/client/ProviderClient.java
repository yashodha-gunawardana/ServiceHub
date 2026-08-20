package com.servicehub.request_service.client;

import com.servicehub.request_service.dto.ProviderResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "provider-service")
public interface ProviderClient {

    @GetMapping("/api/providers/{id}")
    ProviderResponse getProviderById(@PathVariable("id") Long id);
}