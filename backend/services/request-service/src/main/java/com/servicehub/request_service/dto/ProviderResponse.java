package com.servicehub.request_service.dto;

import lombok.Data;

@Data
public class ProviderResponse {

    private Long id;
    private String name;
    private String email;
    private String phone;
    private String serviceType;
    private String location;
    private String status;
}