package com.servicehub.provider_service.controller;

import com.servicehub.provider_service.entity.Provider;
import com.servicehub.provider_service.service.ProviderService;
import org.springframework.http.HttpStatus;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/providers")
public class ProviderController {

    private final ProviderService providerService;

    public ProviderController(ProviderService providerService) {
        this.providerService = providerService;
    }

    // GET - Get all providers
    @GetMapping
    public ResponseEntity<List<Provider>> getAllProviders() {

        List<Provider> providers = providerService.getAllProviders();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(providers);
    }

    // GET - Get provider by ID
    @GetMapping("/{id}")
    public ResponseEntity<Provider> getProviderById(
            @PathVariable Long id) {

        return providerService.getProviderById(id)
                .map(provider -> ResponseEntity
                        .status(HttpStatus.OK)
                        .body(provider))
                .orElseGet(() -> ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .build());
    }

    // POST - Create provider
    @PostMapping
    public ResponseEntity<Provider> createProvider(
            @Valid @RequestBody Provider provider) {

        Provider createdProvider =
                providerService.createProvider(provider);

        URI location = URI.create(
                "/api/providers/" + createdProvider.getId()
        );

        return ResponseEntity
                .created(location)
                .body(createdProvider);
    }

    // PUT - Update provider
    @PutMapping("/{id}")
    public ResponseEntity<Provider> updateProvider(
            @PathVariable Long id,
            @Valid @RequestBody Provider provider) {

        return providerService.updateProvider(id, provider)
                .map(updatedProvider -> ResponseEntity
                        .status(HttpStatus.OK)
                        .body(updatedProvider))
                .orElseGet(() -> ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .build());
    }

    // DELETE - Delete provider
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProvider(
            @PathVariable Long id) {

        boolean deleted = providerService.deleteProvider(id);

        if (!deleted) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }

        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }

    // GET - Get providers by service type
    @GetMapping("/type/{serviceType}")
    public ResponseEntity<List<Provider>> getByServiceType(
            @PathVariable String serviceType) {

        return ResponseEntity.ok(
                providerService.getProvidersByServiceType(serviceType)
        );
    }

    // GET - Get providers by location
    @GetMapping("/location/{location}")
    public ResponseEntity<List<Provider>> getByLocation(
            @PathVariable String location) {

        return ResponseEntity.ok(
                providerService.getProvidersByLocation(location)
        );
    }

    // GET - Get providers by status
    @GetMapping("/status/{status}")
    public ResponseEntity<List<Provider>> getByStatus(
            @PathVariable String status) {

        return ResponseEntity.ok(
                providerService.getProvidersByStatus(status)
        );
    }
}