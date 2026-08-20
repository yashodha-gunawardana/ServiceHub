package com.servicehub.request_service.service;

import com.servicehub.request_service.client.ProviderClient;
import com.servicehub.request_service.dto.ProviderResponse;
import com.servicehub.request_service.entity.ServiceRequest;
import com.servicehub.request_service.repository.ServiceRequestRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RequestService {

    private final ServiceRequestRepository requestRepository;
    private final ProviderClient providerClient;

    public RequestService(
            ServiceRequestRepository requestRepository,
            ProviderClient providerClient) {

        this.requestRepository = requestRepository;
        this.providerClient = providerClient;
    }

    // Get all service requests
    public List<ServiceRequest> getAllRequests() {
        return requestRepository.findAll();
    }

    // Get request by ID
    public Optional<ServiceRequest> getRequestById(String id) {
        return requestRepository.findById(id);
    }

    // Create new request
    public ServiceRequest createRequest(ServiceRequest request) {

        // Default status
        if (request.getStatus() == null ||
                request.getStatus().isBlank()) {

            request.setStatus("PENDING");
        }

        // Check provider if providerId is provided
        if (request.getProviderId() != null &&
                !request.getProviderId().isBlank()) {

            Long providerId =
                    Long.parseLong(request.getProviderId());

            ProviderResponse provider =
                    providerClient.getProviderById(providerId);

            if (provider == null) {
                throw new RuntimeException(
                        "Provider not found with ID: " + providerId
                );
            }
        }

        return requestRepository.save(request);
    }

    // Update request
    public Optional<ServiceRequest> updateRequest(
            String id,
            ServiceRequest request) {

        return requestRepository.findById(id)
                .map(existingRequest -> {

                    if (request.getCustomerId() != null &&
                            !request.getCustomerId().isBlank()) {

                        existingRequest.setCustomerId(
                                request.getCustomerId()
                        );
                    }

                    if (request.getServiceType() != null &&
                            !request.getServiceType().isBlank()) {

                        existingRequest.setServiceType(
                                request.getServiceType()
                        );
                    }

                    if (request.getDescription() != null &&
                            !request.getDescription().isBlank()) {

                        existingRequest.setDescription(
                                request.getDescription()
                        );
                    }

                    if (request.getLocation() != null &&
                            !request.getLocation().isBlank()) {

                        existingRequest.setLocation(
                                request.getLocation()
                        );
                    }

                    if (request.getStatus() != null &&
                            !request.getStatus().isBlank()) {

                        existingRequest.setStatus(
                                request.getStatus()
                        );
                    }

                    if (request.getProviderId() != null &&
                            !request.getProviderId().isBlank()) {

                        Long providerId =
                                Long.parseLong(
                                        request.getProviderId()
                                );

                        ProviderResponse provider =
                                providerClient.getProviderById(providerId);

                        if (provider == null) {
                            throw new RuntimeException(
                                    "Provider not found with ID: "
                                            + providerId
                            );
                        }

                        existingRequest.setProviderId(
                                request.getProviderId()
                        );
                    }

                    return requestRepository.save(existingRequest);
                });
    }

    // Delete request
    public boolean deleteRequest(String id) {

        if (!requestRepository.existsById(id)) {
            return false;
        }

        requestRepository.deleteById(id);

        return true;
    }

    // Get provider details through Feign Client
    public ProviderResponse getProvider(Long providerId) {
        return providerClient.getProviderById(providerId);
    }

    // Get requests by customer
    public List<ServiceRequest> getRequestsByCustomerId(
            String customerId) {

        return requestRepository.findByCustomerId(customerId);
    }

    // Get requests by provider
    public List<ServiceRequest> getRequestsByProviderId(
            String providerId) {

        return requestRepository.findByProviderId(providerId);
    }

    // Get requests by status
    public List<ServiceRequest> getRequestsByStatus(
            String status) {

        return requestRepository.findByStatus(status);
    }

    // Get requests by service type
    public List<ServiceRequest> getRequestsByServiceType(
            String serviceType) {

        return requestRepository.findByServiceType(serviceType);
    }
}