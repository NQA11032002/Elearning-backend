package guild.api.security.service;

import guild.api.security.request.Email;
import guild.api.security.response.ResponseObject;
import guild.api.security.service.interfaces.IEmailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Random;

@Service
public class EmailService implements IEmailService {
    @Autowired
    private JavaMailSender javaMailSender;

    @Value("myphamskincares@gmail.com")
    private String sender;

    @Override
    public ResponseObject sendSimpleMail(Email email) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setFrom(sender);
        simpleMailMessage.setTo(email.getRecipient());

        email.setMsgBody("Mã OTP của bạn là: " + randomOTP() + "\n Vui lòng không chia sẽ mã OTP này cho bất kỳ ai.!!!");
        simpleMailMessage.setText(email.getMsgBody());

        email.setSubject("Lấy lại mật khẩu");
        simpleMailMessage.setSubject(email.getSubject());

        javaMailSender.send(simpleMailMessage);


        return new ResponseObject(HttpStatus.OK.name(), "Mail sent successfully...", null);

    }

    public String randomOTP(){
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder randomString = new StringBuilder();

        Random random = new Random();

        for (int i = 0; i < 6; i++) {
            int index = random.nextInt(characters.length());
            char randomChar = characters.charAt(index);
            randomString.append(randomChar);
        }

        return randomString.toString();
    }
}
