package Home.Mq;

import ch.qos.logback.core.pattern.Converter;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
// you should move it to base broject
// the settings of queue message
public class Messagingconfig {

    public static final String queue = "project";
    public static final String Exchange = "spring_exchange";
    public static final String Routing = "afef_Routing";

    @Bean
    public Queue queue() {
        return new Queue(queue);
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(Exchange);
    }

    @Bean
    public Binding binding() {
        return BindingBuilder.bind(queue()).to(exchange()).with(Routing);
    }

    @Bean
    public MessageConverter converter() {
        return new Jackson2JsonMessageConverter();

    }
    @Bean
    public AmqpTemplate template(ConnectionFactory connectionFactory)
    {
        final RabbitTemplate rabbitTemplate=new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter());
        return rabbitTemplate;
    }

}



