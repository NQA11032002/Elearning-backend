package guild.api.security.controller.interfaces;

import guild.api.security.entity.User;
import guild.api.security.response.ResponseObject;

public interface IUserController {
    public ResponseObject updateUser(Integer id,String  currentPassword, User user);
    public ResponseObject findUserById(Integer id);

}
