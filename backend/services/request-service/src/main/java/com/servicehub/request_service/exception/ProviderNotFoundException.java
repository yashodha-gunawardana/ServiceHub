package com.servicehub.request_service.exception;

public class ProviderNotFoundException extends RuntimeException {

    public ProviderNotFoundException(Long providerId) {
        super("Provider not found with ID: " + providerId);
    }
}