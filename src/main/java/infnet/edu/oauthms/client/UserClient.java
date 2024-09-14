package infnet.edu.oauthms.client;

import infnet.edu.oauthms.dto.LoginRequestDTO;
import infnet.edu.oauthms.dto.UserResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "user-service")
public interface UserClient {

    @GetMapping("/api/users/validate")
    UserResponseDTO validateUser(@RequestParam("username") String username, @RequestParam("password") String password);
}
