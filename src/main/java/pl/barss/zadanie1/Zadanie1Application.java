package pl.barss.zadanie1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class Zadanie1Application {

    public static void main(String[] args) {
        SpringApplication.run(Zadanie1Application.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void info(){

    }
}
