package mono.repo.service;

import lombok.extern.slf4j.Slf4j;
import mono.repo.entity.Board;
import mono.repo.repository.BoardRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Description :게시판 CRUD 테스트
 *
 * 테스트에 Spring 테스트 프레임워크 기능(@MockBean 등)을 포함: @ExtendWith(SpringExtension.class)
 * 테스트에 Spring 테스트 프레임워크 기능을 포함하지 않는 경우: @ExtendWith(MockitoExtension.class)
 *
 * @author leejinho
 * @version 1.0
 */
@Slf4j
@DataJpaTest
@DisplayName("게시판 CRUD 테스트")
@ExtendWith({SpringExtension.class})
class CRUDServiceTest {

    @MockBean
    BoardService boardService;

    @Mock
    BoardRepository boardRepository;

    @BeforeEach
    @DisplayName("@BeforeEach")
    void setUp() {
    }

    @AfterEach
    @DisplayName("@AfterEach")
    void tearDown() {
    }

    @Test
    void selectList() {
    }

    @Test
    void select() {
    }

    @Test
    void delete() {
    }

    @Test
    void save() {
        Board board = Board.builder()
                .title("JUnit5")
                .author("홍길동")
                .content("TDD")
                .build();

        BDDMockito.given(boardRepository.save(board))
                .willReturn(new Board(1L, "홍길동", "JUnit5", "TDD"));

        Board savedBoard = boardRepository.findBoardById(1L);

    }

    @Test
    void update() {
    }
}