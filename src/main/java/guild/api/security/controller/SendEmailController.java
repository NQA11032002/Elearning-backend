package guild.api.security.controller;

import guild.api.security.controller.interfaces.ISendEmailController;
import guild.api.security.request.Email;
import guild.api.security.response.ResponseObject;
import guild.api.security.service.interfaces.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/email")
@CrossOrigin(origins = "*")
public class SendEmailController implements ISendEmailController {
    @Autowired
    private IEmailService emailService;

    @Override
    @PostMapping("/send")
    public ResponseObject sendSimpleMail(@RequestBody Email email) {
        return emailService.sendSimpleMail(email);
    }

}
