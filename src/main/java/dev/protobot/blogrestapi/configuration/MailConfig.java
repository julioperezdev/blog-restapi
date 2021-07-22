package dev.protobot.blogrestapi.configuration;

/*

import dev.protobot.blogrestapi.mailer.EmailSenderProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;


@Configuration
public class MailConfig {

    private final EmailSenderProperties emailSenderProperties;

    @Autowired
    public MailConfig(EmailSenderProperties emailSenderProperties) {
        this.emailSenderProperties = emailSenderProperties;
    }

    @Bean
    public JavaMailSender getMailSender(){
        final JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(this.emailSenderProperties.getSmtpHost());
        mailSender.setPort(this.emailSenderProperties.getSmtpPort());

        return mailSender;
    }
}


 */