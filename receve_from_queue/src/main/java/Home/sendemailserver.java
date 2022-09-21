package Home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import sun.java2d.pipe.SpanShapeRenderer;

import javax.mail.internet.MimeMessage;
import java.io.File;
@Service
public class sendemailserver
{   @Autowired
    private JavaMailSender javaMailSender;
    public void sendmail(String to, String subject, String topic)
    {
        SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
        simpleMailMessage.setFrom("4abdeea5649460");
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(topic);

        javaMailSender.send(simpleMailMessage);
System.out.println("ok");
    }


}
