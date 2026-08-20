package com.servicehub.provider_service.exception;

public class DuplicateEmailException extends RuntimeException {

    public DuplicateEmailException(String email) {
        super("Provider already exists with email: " + email);
    }
}