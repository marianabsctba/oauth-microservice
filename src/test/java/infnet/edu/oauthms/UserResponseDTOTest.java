package infnet.edu.oauthms;


import infnet.edu.oauthms.dto.UserResponseDTO;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class UserResponseDTOTest {

    @Test
    void testGetAndSetId() {
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setId(1L);
        assertEquals(1L, userResponseDTO.getId());
    }

    @Test
    void testGetAndSetUsername() {
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setUsername("testUser");
        assertEquals("testUser", userResponseDTO.getUsername());
    }

    @Test
    void testGetAndSetName() {
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setName("testName");
        assertEquals("testName", userResponseDTO.getName());
    }
}
