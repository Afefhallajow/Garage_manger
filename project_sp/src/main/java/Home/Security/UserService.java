package Home.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class UserService implements UserDetailsService {
    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    Userrepository userreposetory;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user =userreposetory.findByUsername(username);

        return new User(user.getUsername(),user.getPassword(),new ArrayList<>());

    }

    public AppUser save(AppUser user)
    {user.setPassword(passwordEncoder().encode(user.getPassword()));
        return userreposetory.save(user);
    }
    public List<AppUser> findall()
    {
        return userreposetory.findAll();

    }
}
