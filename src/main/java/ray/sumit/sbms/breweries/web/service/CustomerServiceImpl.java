package ray.sumit.sbms.breweries.web.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ray.sumit.sbms.breweries.web.model.CustomerDto;

import java.util.UUID;

@Slf4j
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

    @Override
    public void deleteByCustomerId(UUID customerId) {
        log.info("Deleting the Customer with beerId: " + customerId);
    }
}
