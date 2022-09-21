package Home;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class home {
private CsvController csvController;
private listener listener;
    @Autowired
    private sendemailserver sendemail;


    public static void main(String[] args)
{
    SpringApplication.run(home.class,args);
}
/**
@EventListener(ApplicationReadyEvent.class)
    public void trigger()
{
    sendemail.sendmail(listener.getOrderStatus().getEmail(),"hi there","test");
}**/
}
