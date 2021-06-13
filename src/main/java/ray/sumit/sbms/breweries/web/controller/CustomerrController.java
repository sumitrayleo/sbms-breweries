package ray.sumit.sbms.breweries.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ray.sumit.sbms.breweries.web.model.CustomerDto;
import ray.sumit.sbms.breweries.web.service.CustomerService;

import java.util.UUID;

@RequestMapping("/api/v1/customer")
@RestController
public class CustomerrController {
    private final CustomerService customerService;

    @Autowired
    public CustomerrController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping({"/{customerId}"})
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable("customerId") UUID customerId) {
        return new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity handleNewCustomer(@RequestBody CustomerDto customer) {
        CustomerDto savedCustomer = customerService.saveNewCustomer(customer);

        HttpHeaders headers = new HttpHeaders();
        headers.add("location", "http://localhost:8080/api/v1/customer/" + savedCustomer.getId());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping({"/{customerId}"})
    public ResponseEntity handleUpdateCustomer(@PathVariable("customerId") UUID customerId, @RequestBody CustomerDto customer) {
        customerService.saveExistingCustomer(customerId, customer);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
