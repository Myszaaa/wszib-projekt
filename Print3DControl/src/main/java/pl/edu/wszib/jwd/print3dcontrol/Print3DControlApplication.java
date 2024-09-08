package pl.edu.wszib.jwd.print3dcontrol;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:db.properties")
@SpringBootApplication
public class
Print3DControlApplication {

    public static void main(String[] args) {
        SpringApplication.run(Print3DControlApplication.class, args);
    }

}
