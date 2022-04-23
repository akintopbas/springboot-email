package com.skillsoft.springbootmail.controller;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.net.URI;

@Configuration
public class MailController implements CommandLineRunner {

    @Autowired
    private JavaMailSender javaMailSender;

    private static final String ACCOUNT_SID = "ACdf8e550b7dad6db96ad8bc18afe154a9";
    private static final String AUTH_SID = "784cee7e17f2eb190ba3e9484dd169cb";
    public static final String TWILIO_NUMBER = "+16165233575";

    static {
        Twilio.init(ACCOUNT_SID, AUTH_SID);
    }

    @Override
    public void run(String... args) throws Exception {
        /*
        System.out.println("Sendind mail...");

        sendMail();
        sendWithAtchMail();

        System.out.println("Done...");

        Message.creator(new PhoneNumber("+905318965420"),
                        new PhoneNumber(TWILIO_NUMBER),
                  "Naber Laynnnn").create();

        //Call.creator(new PhoneNumber("+905318965420"),
        Call.creator(new PhoneNumber("+905372206955"),
                new PhoneNumber(TWILIO_NUMBER),
                new URI("https://demo.twilio.com/welcome/voice/voice.xml")).create();
        System.out.println("Calling...");
        */
    }

    private void sendMail() {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("akintopbas11@gmail.com");

        msg.setSubject("Email sent using SpringBoot");
        msg.setText("Hello! \n\n Welcome to Spring Boot, easy to send email wasn't it?");

        javaMailSender.send(msg);
    }

    private void sendWithAtchMail() throws MessagingException, IOException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);

        mimeMessageHelper.setTo("akintopbas11@gmail.com");

        mimeMessageHelper.setSubject("Here is a cute photo of a dog!");
        mimeMessageHelper.setText("<h3><i><b>Take a look at the attachment :-)</b></i></h3>", true);

        mimeMessageHelper.addAttachment("cute_dog.png",new ClassPathResource("dog.png"));

        javaMailSender.send(mimeMessage);

    }
}
