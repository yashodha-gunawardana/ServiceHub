package com.servicehub.request_service.controller;

import com.servicehub.request_service.entity.ServiceRequest;
import com.servicehub.request_service.service.RequestService;
import com.servicehub.request_service.dto.ProviderResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/requests")
public class RequestController {

    private final RequestService requestService;

    public RequestController(RequestService requestService) {
        this.requestService = requestService;
    }

    // GET - Get all requests
    @GetMapping
    public ResponseEntity<List<ServiceRequest>> getAllRequests() {

        List<ServiceRequest> requests = requestService.getAllRequests();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(requests);
    }

    // GET - Get request by ID
    @GetMapping("/{id}")
    public ResponseEntity<ServiceRequest> getRequestById(
            @PathVariable String id) {

        return requestService.getRequestById(id)
                .map(request -> ResponseEntity
                        .status(HttpStatus.OK)
                        .body(request))
                .orElseGet(() -> ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .build());
    }

    // POST - Create new request
    @PostMapping
    public ResponseEntity<ServiceRequest> createRequest(
            @RequestBody ServiceRequest request) {

        ServiceRequest createdRequest =
                requestService.createRequest(request);

        URI location = URI.create(
                "/api/requests/" + createdRequest.getId()
        );

        return ResponseEntity
                .created(location)
                .body(createdRequest);
    }

    // PUT - Update request
    @PutMapping("/{id}")
    public ResponseEntity<ServiceRequest> updateRequest(
            @PathVariable String id,
            @RequestBody ServiceRequest request) {

        return requestService.updateRequest(id, request)
                .map(updatedRequest -> ResponseEntity
                        .status(HttpStatus.OK)
                        .body(updatedRequest))
                .orElseGet(() -> ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .build());
    }

    // DELETE - Delete request
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRequest(
            @PathVariable String id) {

        boolean deleted = requestService.deleteRequest(id);

        if (!deleted) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }

        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }

    // GET - Get requests by customer
    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<ServiceRequest>> getByCustomer(
            @PathVariable String customerId) {

        return ResponseEntity.ok(
                requestService.getRequestsByCustomerId(customerId)
        );
    }

    // GET - Get requests by provider
    @GetMapping("/provider/{providerId}")
    public ResponseEntity<List<ServiceRequest>> getByProvider(
            @PathVariable String providerId) {

        return ResponseEntity.ok(
                requestService.getRequestsByProviderId(providerId)
        );
    }

    // GET - Get provider details through Feign Client
    @GetMapping("/provider-details/{providerId}")
    public ResponseEntity<ProviderResponse> getProviderDetails(
            @PathVariable Long providerId) {

        return ResponseEntity.ok(
                requestService.getProvider(providerId)
        );  
    }

    // GET - Get requests by status
    @GetMapping("/status/{status}")
    public ResponseEntity<List<ServiceRequest>> getByStatus(
            @PathVariable String status) {

        return ResponseEntity.ok(
                requestService.getRequestsByStatus(status)
        );
    }

    // GET - Get requests by service type
    @GetMapping("/type/{serviceType}")
    public ResponseEntity<List<ServiceRequest>> getByServiceType(
            @PathVariable String serviceType) {

        return ResponseEntity.ok(
                requestService.getRequestsByServiceType(serviceType)
        );
    }
}