package qw.springfamework.services;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import qw.springfamework.api.v1.mapper.CustomerMapper;
import qw.springfamework.api.v1.model.CustomerDTO;
import qw.springfamework.domain.Customer;
import qw.springfamework.repositories.CustomerRepository;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

public class CustomerServiceImplTest {

    @Mock
    private CustomerRepository customerRepository;

    private CustomerMapper customerMapper = CustomerMapper.INSTANCE;

    private CustomerService customerService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        customerService = new CustomerServiceImpl(customerMapper, customerRepository);
    }

    @Test
    public void getAllCustomers() throws Exception {
        //given
        Customer customer1 = new Customer();
        customer1.setId(1l);
        customer1.setFirstName("Michale");
        customer1.setLastName("Weston");
        Customer customer2 = new Customer();
        customer2.setId(2l);
        customer2.setFirstName("Sam");
        customer2.setLastName("Axe");
        when(customerRepository.findAll()).thenReturn(Arrays.asList(customer1, customer2));
        //when
        List<CustomerDTO> customerDTOS = customerService.getAllCustomers();
        //then
        assertEquals(2, customerDTOS.size());
    }

    @Test
    public void getCustomerById() {
        //given
        Customer customer1 = new Customer();
        customer1.setId(1l);
        customer1.setFirstName("Michale");
        customer1.setLastName("Weston");
        when(customerRepository.findById(anyLong())).thenReturn(java.util.Optional.ofNullable(customer1));
        //when
        CustomerDTO customerDTO = customerService.getCustomerById(1L);
        assertEquals("Michale", customerDTO.getFirstName());
    }

    @Test
    public void createCustomer() throws Exception {
        //given
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setFirstName("Jim");
        Customer savedCustomer = new Customer();
        savedCustomer.setFirstName(customerDTO.getFirstName());
        savedCustomer.setLastName(customerDTO.getLastName());
        savedCustomer.setId(1l);
        when(customerRepository.save(any(Customer.class))).thenReturn(savedCustomer);
        //when
        CustomerDTO savedDto = customerService.createCustomer(customerDTO);
        //then
        assertEquals(customerDTO.getFirstName(), savedDto.getFirstName());
        assertEquals("/api/v1/customer/1", savedDto.getCustomerUrl());
    }

    @Test
    public void saveCustomerByDTO() throws Exception {
        //given
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setFirstName("Jim");
        Customer savedCustomer = new Customer();
        savedCustomer.setFirstName(customerDTO.getFirstName());
        savedCustomer.setLastName(customerDTO.getLastName());
        savedCustomer.setId(1l);
        when(customerRepository.save(any(Customer.class))).thenReturn(savedCustomer);
        //when
        CustomerDTO savedDto = customerService.saveCustomerByDTO(1L, customerDTO);
        //then
        assertEquals(customerDTO.getFirstName(), savedDto.getFirstName());
        assertEquals("/api/v1/customer/1", savedDto.getCustomerUrl());
    }
}