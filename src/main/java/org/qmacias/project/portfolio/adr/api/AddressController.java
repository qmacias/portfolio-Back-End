package org.qmacias.project.portfolio.adr.api;

import org.qmacias.project.portfolio.adr.domain.Address;
import org.qmacias.project.portfolio.adr.application.AddressService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
final class AddressController {

    private final AddressService service;

    AddressController(final AddressService service) {
        this.service = service;
    }

    @GetMapping
    public List<Address> allAddress() {
        return service.all();
    }

    @GetMapping("/{id}")
    public Address getAddress(@PathVariable final Long id) {
        return service.get(id);
    }

    @PostMapping
    public Address addAddress(@RequestBody final Address address) {
        return service.add(address);
    }

    @DeleteMapping("/{id}")
    public void removeAddress(@PathVariable final Long id) {
        service.remove(id);
    }

}
