package infnet.edu.oauthms;

import infnet.edu.oauthms.dto.UserResponseDTO;
import infnet.edu.oauthms.security.JwtTokenProvider;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class JwtTokenProviderTest {

    private final JwtTokenProvider jwtTokenProvider = new JwtTokenProvider();

    @Test
    void createToken_shouldReturnNonNullToken() {
        UserResponseDTO user = new UserResponseDTO();
        user.setId(1L);
        user.setName("testName");
        user.setUsername("testUsername");

        String token = jwtTokenProvider.createToken(user);

        assertNotNull(token);
    }
}
