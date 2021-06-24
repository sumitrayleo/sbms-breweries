package ray.sumit.sbms.breweries.web.mapper;

import org.mapstruct.Mapper;
import ray.sumit.sbms.breweries.web.domain.Customer;
import ray.sumit.sbms.breweries.web.model.CustomerDto;

@Mapper
public interface CustomerMapper {
    CustomerDto mapCustomerToCustomerDto(Customer customer);

    Customer mapCustomerDtoToCustomer(CustomerDto customerDto);
}
