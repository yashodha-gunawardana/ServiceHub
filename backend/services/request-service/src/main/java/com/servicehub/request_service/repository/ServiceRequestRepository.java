package com.servicehub.request_service.repository;

import com.servicehub.request_service.entity.ServiceRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ServiceRequestRepository extends MongoRepository<ServiceRequest, String> {

    List<ServiceRequest> findByCustomerId(String customerId);

    List<ServiceRequest> findByProviderId(String providerId);

    List<ServiceRequest> findByStatus(String status);

    List<ServiceRequest> findByServiceType(String serviceType);
}