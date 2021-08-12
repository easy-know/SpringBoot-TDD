package mono.repo.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import mono.repo.entity.Board;
import mono.repo.service.BoardService;
import org.junit.AfterClass;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

/**
 * Description :
 *
 * @author leejinho
 * @version 1.0
 */
@RunWith(SpringRunner.class)
@WebMvcTest(BoardRestController.class)
@Slf4j
class BoardRestControllerTest {

    // request와 response를 생성
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BoardService boardService;

    @Autowired
    private ObjectMapper objectMapper;

    private Board board;

    @BeforeEach
    public void setUp() {
        log.info("============@BeforeEach============");
    }

    @AfterEach
    public void tearDown() {
        log.info("============@AfterEach============");

    }

    @Test
    public void 모든_게시글_불러오기() throws Exception {
        log.info("============loadBoard()============");
        MvcResult mvcResult = mockMvc.perform(get("/board")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value()))
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        Assertions.assertEquals(MediaType.APPLICATION_JSON.toString(),
                mvcResult.getResponse().getContentType());

        Assertions.assertEquals(HttpStatus.OK.value(),
                mvcResult.getResponse().getStatus());

    }

    /**
     * <mockMvc의 메소드>
     * perform()
     *  - 요청을 전송하는 역할을 합니다.
     *  - 결과로 ResultActions 객체를 받으며, ResultActions 객체는 리턴 값을 검증하고 확인할 수 있는 andExcpect() 메소드를 제공해줍니다.
     * post
     *  - HTTP 메소드를 결정할 수 있습니다. ( get(), post(), put(), delete() )
     *  - 인자로는 경로를 보내줍니다.
     * params(info)
     *  - 키 = 값의 파라미터를 전달할 수 있습니다.
     *  - 여러 개일 때는 params()를, 하나일 때에는 param()을 사용합니다.
     * andExpect()
     *  - is(int status) [status 상태 코드]
     *  - view().name("blog") : 리턴하는 뷰 이름이 blog인가?
     *  - redirectUrl("/blog") : '/blog'로 리다이렉트 되었는가?
     *  - model() : 컨트롤러에서 저장한 모델들의 정보 검증
     * andDo(print())
     *  - 요청/응답 전체 메세지를 확인할 수 있습니다.
     */
    @Test
    public void 게시글_저장() throws Exception {
        log.info("============saveBoard()============");

        board = Board.builder()
                .author("홍길동")
                .content("JUnit4 API Test")
                .build();

        String content = objectMapper.writeValueAsString(board);
        log.info(content);

        mockMvc.perform(post("/board")
                .content(content)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(result -> {
                    MockHttpServletResponse response = result.getResponse();
                    log.info(response.getContentAsString());
                });
    }

    @Test
    public void 게시글_업데이트() throws Exception {
        // given
        board = Board.builder()
                .title("JUnit4 API Test")
                .author("홍길동")
                .content("TDD")
                .build();

        // when & then
        String content = objectMapper.writeValueAsString(board);

        mockMvc.perform(put("/board")
                .content(content)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(result -> {
                    MockHttpServletResponse response = result.getResponse();
                    log.info(response.getContentAsString());
                });
    }

    @Test
    public void 게시글_삭제() throws Exception {
        // given
        board = Board.builder()
                .title("JUnit4 API Test")
                .author("홍길동")
                .content("TDD")
                .build();

        // when & then
        String content = objectMapper.writeValueAsString(board);
        mockMvc.perform(delete("/board")
                .content(content)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(result -> {
                    MockHttpServletResponse response = result.getResponse();
                    log.info(response.getContentAsString());
                });
        log.info("============deleteBoard()============");
    }

    @AfterClass
    public static void afterAll() {
        log.info("============@AfterClass============");
    }
}