package infnet.edu.oauthms;

import infnet.edu.oauthms.client.UserClient;
import infnet.edu.oauthms.dto.UserResponseDTO;
import infnet.edu.oauthms.security.JwtTokenProvider;
import infnet.edu.oauthms.service.AuthService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

class AuthServiceTest {

    @Mock
    private UserClient userClient;

    @Mock
    private JwtTokenProvider jwtTokenProvider;

    @InjectMocks
    private AuthService authService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void authenticator_shouldReturnToken_whenCredentialsAreValid() {
        UserResponseDTO userResponse = new UserResponseDTO();
        userResponse.setId(1L);
        userResponse.setName("testName");
        userResponse.setUsername("testUser");
        String token = "testToken";

        when(userClient.validateUser("testUser", "testPass")).thenReturn(userResponse);
        when(jwtTokenProvider.createToken(userResponse)).thenReturn(token);

        String result = authService.authenticator("testUser", "testPass");

        assertEquals(token, result);
    }

    @Test
    void authenticator_shouldThrowException_whenCredentialsAreInvalid() {
        when(userClient.validateUser("invalidUser", "invalidPass")).thenReturn(null);

        assertThrows(RuntimeException.class, () -> authService.authenticator("invalidUser", "invalidPass"));
    }
}
