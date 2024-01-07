package guild.api.security.controller;

import guild.api.security.controller.interfaces.IAuthController;
import guild.api.security.request.AuthenticationRequest;
import guild.api.security.request.RegisterRequest;
import guild.api.security.response.AuthenticationResponse;
import guild.api.security.response.ResponseObject;
import guild.api.security.service.interfaces.IAuthService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthenticationController implements IAuthController {
    @Autowired
    private IAuthService authService;

    @PostMapping("/register")
    public ResponseObject register(@RequestBody RegisterRequest request) {
        return authService.register(request);
    }

    @PostMapping("/login")
    public AuthenticationResponse login(@RequestBody AuthenticationRequest request) {
        return authService.login(request);
    }

    @Override
    @PostMapping("/logout")
    public ResponseObject logout(@RequestParam("token") String token) {
        token = token.replace("\"", "");
        return authService.logout(token);
    }

    @Override
    @GetMapping("/getUserID")
    public ResponseObject getUserID(HttpServletRequest request) {
        String authorizationHeader = request.getHeader("Authorization");
        System.out.println(authorizationHeader);
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            String token = authorizationHeader.substring(7);
            token = token.replace("\"", "");

            return authService.getUserID(token);
        }
        return authService.getUserID(null);
    }
}
