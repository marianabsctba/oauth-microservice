package infnet.edu.oauthms.service;

import infnet.edu.oauthms.client.UserClient;
import infnet.edu.oauthms.dto.UserResponseDTO;
import infnet.edu.oauthms.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserClient userClient;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    public String authenticator(String username, String password) {
        UserResponseDTO userResponse = userClient.validateUser(username, password);

        if(userResponse != null) {
            return jwtTokenProvider.createToken(userResponse);
        }

        throw new RuntimeException("Invalid Credentils");
    }
}
