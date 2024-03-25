package app.message.service.controller;

import app.message.service.dto.MailMessageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/email")
@RequiredArgsConstructor
@CrossOrigin
public class MessageController {
    private final JavaMailSender javaMailSender;

    @PostMapping
    public boolean sendMessage(@RequestBody MailMessageDto mailMessageDto) {
        System.out.println("Send email");
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("eduard.mititiuc@gmail.com");
        message.setTo(mailMessageDto.getTo());
        message.setSubject(mailMessageDto.getSubject());
        message.setText(mailMessageDto.getMessage());
        try {
            javaMailSender.send(message);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
