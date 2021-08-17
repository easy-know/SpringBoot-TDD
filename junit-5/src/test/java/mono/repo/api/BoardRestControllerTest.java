package mono.repo.api;

import lombok.extern.slf4j.Slf4j;
import mono.repo.service.BoardServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * Description :
 *
 * @author leejinho
 * @version 1.0
 */
@Slf4j
@WebMvcTest(BoardRestController.class)
@DisplayName("API Test")
class BoardRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BoardServiceImpl boardService;

    @BeforeEach
    void setUp() {
        log.info("==========@BeforeEach==========");
    }

    @AfterEach
    void tearDown() {
        log.info("==========@AfterEach==========");
    }

//    @Test
//    void loadBoard() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.get("/board"))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//    }

    @Test
    void loadBoardById() {
    }

    @Test
    void saveBoard() {
    }

    @Test
    void updateBoard() {
    }

    @Test
    void deleteBoard() {
    }
}