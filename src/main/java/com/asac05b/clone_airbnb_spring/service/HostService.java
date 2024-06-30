package com.asac05b.clone_airbnb_spring.service;

import com.asac05b.clone_airbnb_spring.model.Host;
import com.asac05b.clone_airbnb_spring.repository.HostRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class HostService {

    private final HostRepository hostRepository;

    public HostService(HostRepository hostRepository) {
        this.hostRepository = hostRepository;
    }

    public List<Host> findAll() {
        return hostRepository.findAll();
    }

    public List<Host> saveHost(List<Host> hosts) {
        return hostRepository.saveAll(hosts);
    }

    public Host getById(Integer id) {
        return hostRepository.findById(id).orElse(null);
    }

    public List<Host> getHostByAccommodationId(Integer accommodationId) {
        return hostRepository.findByAccommodation_AccommodationId(accommodationId);
    }
}