package infnet.edu.oauthms.service;

import infnet.edu.oauthms.client.UserClient;
import infnet.edu.oauthms.dto.UserResponseDTO;
import infnet.edu.oauthms.security.JwtTokenProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserClient userClient;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    Logger logger= LogManager.getLogger(AuthService.class);

    public String authenticator(String username, String password) {
        try{
            logger.info("Authenticating user {}", username);
            UserResponseDTO userResponse = userClient.validateUser(username, password);

            if(userResponse != null) {
                return jwtTokenProvider.createToken(userResponse);
            }

            throw new RuntimeException("Invalid Credentils");
        }
        catch(Exception e){
            logger.error(e.getMessage());
            throw new RuntimeException("Error authenticating user", e);
        }
    }
}
