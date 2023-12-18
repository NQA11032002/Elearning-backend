package guild.api.security.controller;

import guild.api.security.controller.interfaces.IUserController;
import guild.api.security.entity.Customer;
import guild.api.security.entity.User;
import guild.api.security.response.ResponseObject;
import guild.api.security.service.interfaces.ICustomerService;
import guild.api.security.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*")
public class UserController implements IUserController {
    @Autowired
    private IUserService iUserService;

    @PutMapping(path = "/{id}")
    @Override
    public ResponseObject updateUser(@PathVariable("id") Integer id, @RequestParam String  currentPassword, @RequestBody User user) {
        return iUserService.updateUser(id,currentPassword, user);
    }

    @Override
    @GetMapping(path = "/{id}")
    public ResponseObject findUserById(@PathVariable("id") Integer id) {
        return iUserService.findUserById(id);
    }
}
