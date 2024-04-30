package tn.esprit.rh.achat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import io.prometheus.client.spring.boot.EnablePrometheusEndpoint;

@EnableScheduling
@SpringBootApplication
@EnablePrometheusEndpoint
public class AchatApplication {

    public static void main(String[] args) {
        SpringApplication.run(AchatApplication.class, args);
    }

}
