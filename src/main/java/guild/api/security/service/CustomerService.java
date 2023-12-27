package guild.api.security.service;

import guild.api.security.entity.Customer;
import guild.api.security.entity.User;
import guild.api.security.repository.ICustomerRepository;
import guild.api.security.repository.IUserRepository;
import guild.api.security.request.RegisterRequest;
import guild.api.security.response.ResponseObject;
import guild.api.security.service.interfaces.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public ResponseObject getAllCustomer() {
        List<Customer> customers = iCustomerRepository.findAll();

        if (customers.isEmpty()) {
            return new ResponseObject(HttpStatus.OK.name(), "List customer is empty", null);
        }

        return new ResponseObject(HttpStatus.OK.name(), "Get all list customer successfully", customers);
    }

    @Override
    public ResponseObject findCustomerById(Integer id) {
        var customer = iCustomerRepository.findById(id);

        if (customer.isPresent()) {
            return new ResponseObject(HttpStatus.OK.name(), "Found a customer in list", customer.get());
        }

        return new ResponseObject(HttpStatus.OK.name(), "Not found any customer", customer);
    }

    @Override
    public ResponseObject findCustomerByUserID(Integer userID) {
        var customer = iCustomerRepository.findByUserID(userID);

        if (customer != null) {
            return new ResponseObject(HttpStatus.OK.name(), "Found a customer in list", customer);
        }

        return new ResponseObject(HttpStatus.OK.name(), "Not found any customer", customer);
    }


    public void registerCustomer(RegisterRequest request) {
        var customer = Customer.builder().userID(request.getUserID()).fullName(request.getFullName()).phone(request.getPhone()).build();
        iCustomerRepository.save(customer);
    }

    @Override
    public ResponseObject insertCustomer(Customer customer) {
        try {
            var checkUser = checkUserID(customer.getUserID());

            if (checkUser) {
                iCustomerRepository.save(customer);

                return new ResponseObject(HttpStatus.OK.name(), "Insert new a customer successfully", customer);
            }

            return new ResponseObject(HttpStatus.INTERNAL_SERVER_ERROR.name(), "Customer is existing in list courses", null);
        }catch (HttpClientErrorException e){
            return new ResponseObject(HttpStatus.INTERNAL_SERVER_ERROR.name(), "Insert new a customer failed", e.getMessage());
        }
    }

    @Override
    public boolean checkUserID(Integer userID) {
        try {
            var response = iUserRepository.findById(userID);

            if(response.isPresent())
            {
                return true;
            }

            return  false;
        }catch (HttpClientErrorException e){
            return false;
        }
    }

    @Override
    public ResponseObject updateCustomer(Integer id, Customer customer) {
        try {
            var customerFound = iCustomerRepository.findById(id);

            if (customerFound.isPresent())
            {
                customerFound.get().setFullName(customer.getFullName());
                customerFound.get().setCity(customer.getCity());
                customerFound.get().setProfilePictureURL(customer.getProfilePictureURL());
                customerFound.get().setUserID(customer.getUserID());
                customerFound.get().setPhone(customer.getPhone());
                customerFound.get().setEmail(customer.getEmail());

                iCustomerRepository.save(customerFound.get());

                return new ResponseObject(HttpStatus.OK.name(), "Update a customer successfully", customerFound);
            }

            return new ResponseObject(HttpStatus.INTERNAL_SERVER_ERROR.name(), "Not found a course to update", null);
        }catch (HttpClientErrorException e){
            return new ResponseObject(HttpStatus.INTERNAL_SERVER_ERROR.name(), "Update a course failed", e.getMessage());
        }
    }

    @Override
    public ResponseObject deleteCustomer(Integer id) {
        try {
            var customerFound = iCustomerRepository.findById(id);

            if (customerFound.isPresent()) {
                iCustomerRepository.delete(customerFound.get());

                return new ResponseObject(HttpStatus.OK.name(), "Delete a customer successfully", null);
            }

            return new ResponseObject(HttpStatus.INTERNAL_SERVER_ERROR.name(), "Customer not found in list courses", null);
        }catch (HttpClientErrorException e){
            return new ResponseObject(HttpStatus.INTERNAL_SERVER_ERROR.name(), "Delete a customer failed", e.getMessage());
        }
    }
}
