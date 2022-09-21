package Home;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class home {
public static void main(String[] args)
{
    SpringApplication.run(home.class,args);
}}
