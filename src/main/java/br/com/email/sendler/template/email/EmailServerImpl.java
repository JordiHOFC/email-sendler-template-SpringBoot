package br.com.email.sendler.template.email;

import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
@Component
public class EmailServerImpl implements EmailServer{
    private final JavaMailSender emailSender;
    private final EntityManager manager;

    public EmailServerImpl(JavaMailSender emailSender, EntityManager manager) {
        this.emailSender = emailSender;
        this.manager = manager;
    }

    @Override
    @Transactional
    public void sendEmail(EmailEntity emailEntity) {
        SimpleMailMessage message= new SimpleMailMessage();
        message.setFrom(emailEntity.getEmailDe());
        message.setTo(emailEntity.getEmailPara());
        message.setSubject(emailEntity.getTitulo());
        message.setText(emailEntity.getBody());
        try {
            emailEntity.vincularEstado(StatusEnvio.SUCESSO);
            emailSender.send(message);
        } catch (MailException e) {
            emailEntity.vincularEstado(StatusEnvio.ERROR);
        }
        finally {
            manager.persist(emailEntity);
        }


    }
}
