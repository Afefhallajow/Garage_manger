package Home;


import com.sun.org.apache.bcel.internal.generic.ARETURN;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class appService {

    private String eventTopic="person.Topic";
private String exchangName="amq.topic";
    @Autowired
listener listener;


    @Autowired
    private carsreprository carsreprository;
  public List<cars> findAll() {

return carsreprository.findAll();
}
public List<cars> FindBydate()
{
   OrderStatus orderStatus= listener.getOrderStatus();
String a= orderStatus.getDate();
//System.out.println(a);
 List<cars> carsList=carsreprository.findByName(a);


    return carsList;
}
}