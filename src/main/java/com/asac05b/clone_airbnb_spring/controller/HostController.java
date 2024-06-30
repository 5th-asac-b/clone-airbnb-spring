package com.asac05b.clone_airbnb_spring.controller;

import com.asac05b.clone_airbnb_spring.model.Host;
import com.asac05b.clone_airbnb_spring.service.HostService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/hosts")
public class HostController {

    private final HostService hostService;

    @GetMapping
    public ResponseEntity<List<Host>> getAllHost() {
        List<Host> hosts = hostService.findAll();
        return ResponseEntity.ok(hosts);
    }

    @PostMapping
    public ResponseEntity<List<Host>> saveAllHost(@RequestBody List<Host> hosts) {
        List<Host> savedHost = hostService.saveHost(hosts);
        return ResponseEntity.ok(savedHost);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Host> getHostById(@PathVariable Integer id) {
        try {
            Host host = hostService.getById(id);
            if (host != null) {
                return new ResponseEntity<>(host, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/accommodation/{accommodationId}")
    public ResponseEntity<List<Host>> getHostByAccommodationId(@PathVariable Integer accommodationId) {
        try {
            List<Host> hosts = hostService.getHostByAccommodationId(accommodationId);
            return new ResponseEntity<>(hosts, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}