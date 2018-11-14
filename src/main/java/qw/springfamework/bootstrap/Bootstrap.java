package qw.springfamework.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import qw.springfamework.domain.Category;
import qw.springfamework.domain.Customer;
import qw.springfamework.repositories.CategoryRepository;
import qw.springfamework.repositories.CustomerRepository;

@Component
public class Bootstrap implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    
    private final CustomerRepository customerRepository;
    
    @Autowired
    public Bootstrap(CategoryRepository categoryRepository, CustomerRepository customerRepository) {
        this.categoryRepository = categoryRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadCategories();
        loadCustomers();
    }

    private void loadCustomers() {
        //given
        Customer customer1 = new Customer();
        customer1.setId(1l);
        customer1.setFirstName("Michale");
        customer1.setLastName("Weston");
        customerRepository.save(customer1);

        Customer customer2 = new Customer();
        customer2.setId(2l);
        customer2.setFirstName("Sam");
        customer2.setLastName("Axe");
        customerRepository.save(customer2);

        System.out.println("Customers Loaded: " + customerRepository.count());
    }

    private void loadCategories() {
        Category fruits = new Category();
        fruits.setName("Fruits");
        Category dried = new Category();
        dried.setName("Dried");
        Category fresh = new Category();
        fresh.setName("Fresh");
        Category exotic = new Category();
        exotic.setName("Exotic");
        Category nuts = new Category();
        nuts.setName("Nuts");

        categoryRepository.save(fruits);
        categoryRepository.save(dried);
        categoryRepository.save(fresh);
        categoryRepository.save(exotic);
        categoryRepository.save(nuts);

        System.out.println("Data Loaded = " + categoryRepository.count() );
    }
}
