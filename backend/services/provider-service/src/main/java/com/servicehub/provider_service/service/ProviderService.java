package com.servicehub.provider_service.service;

import com.servicehub.provider_service.entity.Provider;
import com.servicehub.provider_service.repository.ProviderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProviderService {

    private final ProviderRepository providerRepository;

    public ProviderService(ProviderRepository providerRepository) {
        this.providerRepository = providerRepository;
    }

    // Get all providers
    public List<Provider> getAllProviders() {
        return providerRepository.findAll();
    }

    // Get provider by ID
    public Optional<Provider> getProviderById(Long id) {
        return providerRepository.findById(id);
    }

    // Create provider
    public Provider createProvider(Provider provider) {
        if (provider.getStatus() == null || provider.getStatus().isBlank()) {
            provider.setStatus("AVAILABLE");
        }

        return providerRepository.save(provider);
    }

    // Update provider
    public Optional<Provider> updateProvider(
            Long id,
            Provider provider) {

        return providerRepository.findById(id)
                .map(existingProvider -> {

                    existingProvider.setName(provider.getName());
                    existingProvider.setEmail(provider.getEmail());
                    existingProvider.setPhone(provider.getPhone());
                    existingProvider.setServiceType(provider.getServiceType());
                    existingProvider.setLocation(provider.getLocation());
                    existingProvider.setStatus(provider.getStatus());

                    return providerRepository.save(existingProvider);
                });
    }

    // Delete provider
    public boolean deleteProvider(Long id) {

        if (!providerRepository.existsById(id)) {
            return false;
        }

        providerRepository.deleteById(id);
        return true;
    }

    // Get providers by service type
    public List<Provider> getProvidersByServiceType(String serviceType) {
        return providerRepository.findByServiceType(serviceType);
    }

    // Get providers by location
    public List<Provider> getProvidersByLocation(String location) {
        return providerRepository.findByLocation(location);
    }

    // Get providers by status
    public List<Provider> getProvidersByStatus(String status) {
        return providerRepository.findByStatus(status);
    }
}