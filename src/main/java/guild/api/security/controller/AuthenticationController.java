package guild.api.security.controller;

import guild.api.security.controller.interfaces.IAuthController;
import guild.api.security.request.AuthenticationRequest;
import guild.api.security.request.RegisterRequest;
import guild.api.security.response.AuthenticationResponse;
import guild.api.security.response.ResponseObject;
import guild.api.security.service.interfaces.IAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")

public class AuthenticationController implements IAuthController {
    @Autowired
    private IAuthService authService;

    @PostMapping("/register")
    public ResponseObject register(@RequestBody RegisterRequest request) {
        return authService.register(request);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    @Override
    @PostMapping("/logout")
    public ResponseObject logout(@RequestParam("token") String token) {
        token = token.replace("\"", "");
        return authService.logout(token);
    }

    @Override
    @PostMapping("/getUserID")
    public ResponseObject getUserID(@RequestParam("token") String token) {
        token = token.replace("\"", "");
        return authService.getUserID(token);
    }
}
