package mono.repo.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import mono.repo.entity.Board;
import mono.repo.repository.BoardRepository;
import mono.repo.service.BoardService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Description : Web Mvc Test
 *
 * @author leejinho
 * @version 1.0
 */
@Slf4j
@WebMvcTest(BoardRestController.class)
class BoardRestControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    private BoardService boardService;

    @MockBean
    private BoardRepository boardRepository;

    @BeforeEach
    void setUp() {
        log.info("beforeEach");
    }

    @AfterEach
    void tearDown() {
        log.info("afterEach");
    }

    @Test
    void loadBoard() {
    }

//    @Test
    @Disabled
    @ParameterizedTest
    @ValueSource(strings = {
            "a", "b", "c", "d"
    })
    void loadBoardById_파라미터_테스트(final String s) {
        log.info("argsTest: {}", s);
    }

    @Test
    void loadBoardById() {
    }

    @Test
    @DisplayName("게시글 저장")
    void saveBoard() throws Exception {
        Board board = Board.builder()
                .author("홍길동")
                .views("0")
                .title("JUnit5")
                .content("TDD")
                .build();
        ObjectMapper objectMapper = new ObjectMapper();

        String content = objectMapper.writeValueAsString(board);

        mvc.perform(MockMvcRequestBuilders.post("/board")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content))
                .andExpect(MockMvcResultMatchers.status().isCreated());

        // 테스트 안에서 특정 메소드를 호출했는지에 대해서 검증
        Mockito.verify(mvc, Mockito.never()).save(board);
    }

    @Test
    void updateBoard() {
    }

    @Test
    void deleteBoard() {
    }
}