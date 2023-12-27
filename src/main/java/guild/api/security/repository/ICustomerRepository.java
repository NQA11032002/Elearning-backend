package guild.api.security.repository;

import guild.api.security.entity.Authentication;
import guild.api.security.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    public Customer findByUserID(Integer userID);
}
