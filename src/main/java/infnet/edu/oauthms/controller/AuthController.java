package infnet.edu.oauthms.controller;

import infnet.edu.oauthms.client.UserClient;
import infnet.edu.oauthms.model.LoginRequest;
import infnet.edu.oauthms.security.JwtTokenProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserClient userClient;
    private final JwtTokenProvider tokenProvider;

    public AuthController(UserClient userClient, JwtTokenProvider tokenProvider) {
        this.userClient = userClient;
        this.tokenProvider = tokenProvider;
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
        // Valida o usuário e senha no MS-User
        boolean isValid = userClient.validateUser(loginRequest);

        if (isValid) {
            // Gera o token JWT
            String token = tokenProvider.createToken(loginRequest.getUsername());
            return ResponseEntity.ok(token);
        } else {
            return ResponseEntity.status(401).body("Invalid username or password");
        }
    }
}
