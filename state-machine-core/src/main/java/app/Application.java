package app;

import enums.Events;
import enums.States;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.statemachine.StateMachine;

/**
 * Created by Arpit on 14/01/17.
 */

@SpringBootApplication
// This annotation is a combination of @Configuration, @EnableAutoConfiguration and @ComponentScan
public class Application implements CommandLineRunner {

    @Autowired
    private StateMachine<States, Events> stateMachine;

    public static void main(String[] args) {
        // Used to bootstrap and run Spring application from Java main method
        SpringApplication.run(Application.class, args);
    }

    @Override
    // Provided by CommandLineRunner, will be called just before SpringApplication.run() completes.
    public void run(String... strings) throws Exception {
        // In our case, this is used to indicate that the bean stateMachine, contained within the
        // spring application should be executed the following way.
        stateMachine.sendEvent(Events.E1);
        stateMachine.sendEvent(Events.E2);
    }
}
