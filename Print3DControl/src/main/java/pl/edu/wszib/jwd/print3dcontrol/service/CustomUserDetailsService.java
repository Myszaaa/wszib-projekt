package pl.edu.wszib.jwd.print3dcontrol.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.edu.wszib.jwd.print3dcontrol.model.User;
import pl.edu.wszib.jwd.print3dcontrol.repository.UserRepository;
import pl.edu.wszib.jwd.print3dcontrol.security.CustomUserDetails;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("Użytkownik nie isnieje");
        }
        return new CustomUserDetails(user);
    }


    public void registerNewUser(User user) throws Exception {

        if (userRepository.existsByEmail(user.getEmail())) {
            throw new Exception("Użytkownik o podanym adresie e-mail już istnieje!");
        }
        userRepository.save(user);
    }
}


