package guild.api.security.service;

import guild.api.security.entity.User;
import guild.api.security.repository.IUserRepository;
import guild.api.security.response.ResponseObject;
import guild.api.security.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository iUserRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public ResponseObject findUserById(Integer id) {
        var user = iUserRepository.findById(id);

        if (user.isPresent()) {
            return new ResponseObject(HttpStatus.OK.name(), "Found a user in list", user.get());
        }

        return new ResponseObject(HttpStatus.OK.name(), "Not found any user", user);
    }

    @Override
    public ResponseObject updateUser(Integer id,String currentPassword, User user) {
        try {
            var userFound = iUserRepository.findById(id);

            if (userFound.isPresent()) {
                // Kiểm tra mật khẩu hiện tại
                if (passwordEncoder.matches(currentPassword, userFound.get().getPassword())) {
                    // Kiểm tra nếu user.getPassword() mới không trống (empty) trước khi cập nhật
                    if (user.getPassword() != null && !user.getPassword().isEmpty()) {
                        // Mã hóa mật khẩu mới trước khi lưu vào cơ sở dữ liệu
                        String encodedPassword = passwordEncoder.encode(user.getPassword());
                        userFound.get().setPassword(encodedPassword);
                    }
                    iUserRepository.save(userFound.get());

                    return new ResponseObject(HttpStatus.OK.name(), "Update a user successfully", userFound);
                } else {
                    return new ResponseObject(HttpStatus.BAD_REQUEST.name(), "Current password is incorrect", null);
                }
            }

            return new ResponseObject(HttpStatus.INTERNAL_SERVER_ERROR.name(), "Not found a user to update", null);
        } catch (HttpClientErrorException e) {
            return new ResponseObject(HttpStatus.INTERNAL_SERVER_ERROR.name(), "Update a user failed", e.getMessage());
        }
    }



}
