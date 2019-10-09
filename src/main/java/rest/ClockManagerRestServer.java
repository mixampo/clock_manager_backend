package rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("Models")
public class ClockManagerRestServer {
    public static void main(String[] args) {
        SpringApplication.run(ClockManagerRestServer.class, args);
    }
}
