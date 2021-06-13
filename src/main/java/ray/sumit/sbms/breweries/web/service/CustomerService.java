package ray.sumit.sbms.breweries.web.service;

import ray.sumit.sbms.breweries.web.model.CustomerDto;

import java.util.UUID;

public interface CustomerService {
    CustomerDto getCustomerById(UUID customerId);

    CustomerDto saveNewCustomer(CustomerDto customer);

    void saveExistingCustomer(UUID customerId, CustomerDto customer);
}
