package guild.api.security.controller.interfaces;


import guild.api.security.request.Email;
import guild.api.security.response.ResponseObject;

public interface ISendEmailController {
    public ResponseObject sendSimpleMail(Email email);

}
