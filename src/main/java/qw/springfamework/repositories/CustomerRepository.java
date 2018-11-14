package qw.springfamework.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import qw.springfamework.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
