package guild.api.security.controller;

import guild.api.security.controller.interfaces.ICustomerController;
import guild.api.security.entity.Customer;
import guild.api.security.response.ResponseObject;
import guild.api.security.service.interfaces.ICustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/customer")
@CrossOrigin(origins = "*")
public class CustomerController implements ICustomerController {
    @Autowired
    private ICustomerService iCustomerService;

    @Override
    @GetMapping(path = "")
    public ResponseObject getAllCustomer() {
        return iCustomerService.getAllCustomer();
    }

    @Override
    @GetMapping(path = "/{id}")
    public ResponseObject findCustomerById(@PathVariable("id") Integer id) {
        return iCustomerService.findCustomerById(id);
    }

    @PostMapping(path = "")
    @Override
    public ResponseObject insertCustomer(@RequestBody Customer customer) {
        return iCustomerService.insertCustomer(customer);
    }

    @PutMapping(path = "/{id}")
    @Override
    public ResponseObject updateCustomer(@PathVariable("id") Integer id, @RequestBody Customer customer) {
        return iCustomerService.updateCustomer(id, customer);
    }

    @DeleteMapping(path = "/{id}")
    @Override
    public ResponseObject deleteCustomer(@PathVariable("id") Integer id) {
        return iCustomerService.deleteCustomer(id);
    }
}
