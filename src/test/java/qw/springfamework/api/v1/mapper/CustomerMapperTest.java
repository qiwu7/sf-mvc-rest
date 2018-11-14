package qw.springfamework.api.v1.mapper;

import org.junit.Before;
import org.junit.Test;
import qw.springfamework.api.v1.model.CustomerDTO;
import qw.springfamework.domain.Customer;

import static org.junit.Assert.*;

public class CustomerMapperTest {

    private static final String FIRSTNAME = "Jimmy";
    private static final String LASTNAME = "Fallon";
    private CustomerMapper customerMapper = CustomerMapper.INSTANCE;

    @Test
    public void customerToCustomerDTO() {
        //given
        Customer customer = new Customer();
        customer.setFirstName(FIRSTNAME);
        customer.setLastName(LASTNAME);
        //when
        CustomerDTO customerDTO = customerMapper.customerToCustomerDTO(customer);
        //then
        assertEquals(FIRSTNAME, customerDTO.getFirstName());
        assertEquals(LASTNAME, customerDTO.getLastName());
    }
}