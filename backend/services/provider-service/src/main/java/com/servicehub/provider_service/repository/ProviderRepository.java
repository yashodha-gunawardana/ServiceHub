package com.servicehub.provider_service.repository;

import com.servicehub.provider_service.entity.Provider;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProviderRepository extends JpaRepository<Provider, Long> {

    Optional<Provider> findByEmail(String email);

    List<Provider> findByServiceType(String serviceType);

    List<Provider> findByLocation(String location);

    List<Provider> findByStatus(String status);

    boolean existsByEmail(String email);
}