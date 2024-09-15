package infnet.edu.oauthms;

import infnet.edu.oauthms.dto.LoginRequestDTO;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LoginRequestDTOTest {

    @Test
    void testGetAndSetUsername() {
        LoginRequestDTO loginRequestDTO = new LoginRequestDTO();
        loginRequestDTO.setUsername("testUser");
        assertEquals("testUser", loginRequestDTO.getUsername());
    }

    @Test
    void testGetAndSetPassword() {
        LoginRequestDTO loginRequestDTO = new LoginRequestDTO();
        loginRequestDTO.setPassword("testPassword");
        assertEquals("testPassword", loginRequestDTO.getPassword());
    }
}
