package guild.api.security.controller.interfaces;

import guild.api.security.entity.Customer;
import guild.api.security.response.ResponseObject;

public interface ICustomerController {
    public ResponseObject getAllCustomer();
    public ResponseObject findCustomerById(Integer id);
    public ResponseObject findCustomerByUserID(Integer userID);
    public ResponseObject insertCustomer(Customer customer);
    public ResponseObject updateCustomer(Integer id, Customer customer);
    public ResponseObject deleteCustomer(Integer id);
}
