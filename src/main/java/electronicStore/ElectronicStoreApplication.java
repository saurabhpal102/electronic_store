package electronicStore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan
public class ElectronicStoreApplication {

    public static void main(String[] args) {

        SpringApplication.run(ElectronicStoreApplication.class, args);
    }
}
