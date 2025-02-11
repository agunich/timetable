package com.bntu.timetable.service.impl.auth;

import com.bntu.timetable.entity.user.User;
import com.bntu.timetable.service.api.auth.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailSendException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmailServiceImpl implements EmailService {

//    private static final String accountActivationMessage =
//            "<html> To complete your account set-up, click this link: \n <a href=http://localhost:8080/api/v1/users/verifyUser?id=";
//    private static final String accountActivationTitle = "Verify registration ";
//    private static final String htmlMessageEnd = "> Verify </a>  </html>\n";
//    private static final String defaultPasswordMessage = "Your password is: ";

    private static final String accountActivationMessage =
            "To complete your account set-up, click this link: \n http://localhost:8080/api/v1/users/verifyUser?id=";
    private static final String accountActivationTitle = "Verify registration ";
    private static final String defaultPasswordMessage = "Your password is: ";

    @Value("${spring.mail.username}")
    private String timetableEmailAddress;

    @Value("${default.password}")
    private String defaultPassword;

    private final JavaMailSender javaMailSender;

    public EmailServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void sendAccountActivationEmail(String tokenId, User user) {
        log.debug("Sending email to: {}", user.getEmail());
        try {
            javaMailSender.send(constructEmail(accountActivationMessage + tokenId  + "\n" + defaultPasswordMessage + defaultPassword, user));
        } catch (MailSendException exception) {
            log.debug("Couldn't send mail to: {}", user.getEmail());
//            throw exception;
        }
    }

    private SimpleMailMessage constructEmail(String body, User user) {
        SimpleMailMessage email = new SimpleMailMessage();
        email.setSubject(EmailServiceImpl.accountActivationTitle);
        email.setText(body);
        email.setTo(user.getEmail());
        email.setFrom(timetableEmailAddress);
        return email;
    }
}
