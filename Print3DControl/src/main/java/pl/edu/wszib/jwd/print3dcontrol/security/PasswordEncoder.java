package pl.edu.wszib.jwd.print3dcontrol.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = encoder.encode("123456");
        String encodedPassword = encoder.encode(rawPassword);

        System.out.println(encodedPassword);
    }
}
