package ray.sumit.sbms.breweries.web.service;

import org.springframework.stereotype.Service;
import ray.sumit.sbms.breweries.web.model.CustomerDto;

import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDto getCustomerById(UUID customerId) {
        return CustomerDto.builder()
                .id(UUID.randomUUID())
                .name("John Doe")
                .build();
    }

    @Override
    public CustomerDto saveNewCustomer(CustomerDto customer) {
        return CustomerDto.builder()
                .id(UUID.randomUUID())
                .name(customer.getName() + " Saved")
                .build();
    }

    @Override
    public void saveExistingCustomer(UUID customerId, CustomerDto customer) {
        //TODO: Implement this method
    }
}
