package infnet.edu.oauthms;

import infnet.edu.oauthms.model.UserDTO;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class UserDTOTest {

    @Test
    void testGetAndSetId() {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1L);
        assertEquals(1L, userDTO.getId());
    }

    @Test
    void testGetAndSetUsername() {
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername("testUser");
        assertEquals("testUser", userDTO.getUsername());
    }

    @Test
    void testGetAndSetRole() {
        UserDTO userDTO = new UserDTO();
        userDTO.setRole("ROLE_USER");
        assertEquals("ROLE_USER", userDTO.getRole());
    }
}
