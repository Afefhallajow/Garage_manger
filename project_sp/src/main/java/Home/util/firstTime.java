package Home.util;

import Home.Security.AppUser;
import Home.Security.UserService;


import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class firstTime implements CommandLineRunner {

 private final Log logger = LogFactory.getLog(firstTime.class);

    @Autowired
 private UserService userService;
    @Override
    public void run(String... args) throws Exception {
        if (userService.findall().isEmpty())
        {logger.info("no user found create some users");
            AppUser appUser=new AppUser("afef","12345");
userService.save(appUser);
        }

    }
}
