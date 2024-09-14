package infnet.edu.oauthms.client;

import infnet.edu.oauthms.model.LoginRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "user-service") // Nome do serviço de usuário registrado no Eureka
public interface UserClient {

    @PostMapping("/users/validate")
    boolean validateUser(@RequestBody LoginRequest loginRequest);
}
