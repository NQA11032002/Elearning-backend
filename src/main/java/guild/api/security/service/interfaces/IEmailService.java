package guild.api.security.service.interfaces;


import guild.api.security.request.Email;
import guild.api.security.response.ResponseObject;

public interface IEmailService {
    public ResponseObject sendSimpleMail(Email email);

}
