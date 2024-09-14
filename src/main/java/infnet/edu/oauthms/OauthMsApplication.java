package infnet.edu.oauthms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "infnet.edu.oauthms.client")
public class OauthMsApplication {

    public static void main(String[] args) {
        SpringApplication.run(OauthMsApplication.class, args);
    }

}
