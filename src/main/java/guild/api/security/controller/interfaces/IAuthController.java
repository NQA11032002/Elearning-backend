package guild.api.security.controller.interfaces;

import guild.api.security.request.AuthenticationRequest;
import guild.api.security.request.RegisterRequest;
import guild.api.security.response.AuthenticationResponse;
import guild.api.security.response.ResponseObject;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;

public interface IAuthController {
    public ResponseObject register(RegisterRequest request);
    public AuthenticationResponse login(AuthenticationRequest request);
    public ResponseObject logout(String token);
    public ResponseObject getUserID(HttpServletRequest request);

}