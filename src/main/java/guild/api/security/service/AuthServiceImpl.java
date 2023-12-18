package guild.api.security.service;

import guild.api.security.entity.Authentication;
import guild.api.security.entity.User;
import guild.api.security.repository.IAuthenticationRepository;
import guild.api.security.repository.IUserRepository;
import guild.api.security.request.AuthenticationRequest;
import guild.api.security.request.RegisterRequest;
import guild.api.security.response.AuthenticationResponse;
import guild.api.security.response.ResponseObject;
import guild.api.security.service.interfaces.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements IAuthService {
    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IAuthenticationRepository iAuthenticationRepository;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomerService customerService;


    @Override
    public ResponseObject register(RegisterRequest request) {
        var foundUser = userRepository.findByUserName(request.getUserName());

        //check user exists in table user
        if(!foundUser.isPresent())
        {
            var user = User.builder()
                    .userName(request.getUserName())
                    .password(new BCryptPasswordEncoder().encode(request.getPassword()))
                    .role("USER")
                    .build();

            var newUser = userRepository.save(user);

            request.setUserID(newUser.getId());

            customerService.registerCustomer(request);

            return new ResponseObject(HttpStatus.OK.name(), "Register user successfully", null);
        }
        return new ResponseObject(HttpStatus.INTERNAL_SERVER_ERROR.name(), "The UserName already exists in the database", null);
    }

    //login user and generate token
    @Override
    public AuthenticationResponse login(AuthenticationRequest request)  {
        try {

            //send email and password from request to authenticationManager precess authentication
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getUserName(),
                            request.getPassword()
                    )
            );

            //get information user
            var user = userRepository.findByUserName(request.getUserName()).orElseThrow();

            //generate token
            var jwtToken = jwtService.generateToken(user);

            boolean checkToken = checkToken(user.getUsername());

            if(checkToken)
            {
                Authentication authentication = iAuthenticationRepository.findAuthenticationByUserName(user.getUsername());

                authentication.setToken(jwtToken);
                authentication.setUserID(user.getId());

                authentication.setExpirationTime(jwtService.getExpirationTimeFromToken(jwtToken, jwtService.getSECRET_KEY()));

                iAuthenticationRepository.save(authentication);
            }else
            {
                Authentication authentication = new Authentication();
                authentication.setToken(jwtToken);
                authentication.setUserID(user.getId());
                authentication.setUserName(user.getUsername());
                authentication.setExpirationTime(jwtService.getExpirationTimeFromToken(jwtToken, jwtService.getSECRET_KEY()));

                iAuthenticationRepository.save(authentication);
            }


            return AuthenticationResponse.builder().token(jwtToken).build();
        } catch (AuthenticationException e) {
            // return AuthenticationResponse.builder().error("Invalid credentials").build();
            throw new RuntimeException("Authentication failed", e);
        }
    }
    @Override
    public ResponseObject getUserID(String token){
        try {
            // Validate and parse the token
            var userID = jwtService.getUserID(token);

            if (userID != null) {
                return new ResponseObject(HttpStatus.OK.name(), "get successfully", userID);
            } else {
                return new ResponseObject(HttpStatus.OK.name(), "get fail", null);
            }
        } catch (Exception e) {
            // Handle any exceptions (e.g., token validation failure)
            return new ResponseObject(HttpStatus.UNAUTHORIZED.name(), "Unauthorized", null);
        }
    }
    @Override
    public ResponseObject logout(String token) {
        String username = jwtService.extractUsername(token);

        if(!username.isEmpty())
        {
            Authentication authentication = iAuthenticationRepository.findAuthenticationByUserName(username);
            iAuthenticationRepository.delete(authentication);

            return new ResponseObject(HttpStatus.OK.name(), "Logout successfully", null);
        }

        return new ResponseObject(HttpStatus.OK.name(), "Logout failed", null);
    }


    public boolean checkToken(String userName){
        var auth = iAuthenticationRepository.findAuthenticationByUserName(userName);

        if(auth != null)
        {
            return true;
        }

        return false;
    }

    public boolean checkTokenID(int id){
        var auth = iAuthenticationRepository.findAuthenticationByUserID(id);

        if(auth != null)
        {
            return true;
        }

        return false;
    }
}
