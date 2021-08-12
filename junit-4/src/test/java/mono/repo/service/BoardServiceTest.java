package mono.repo.service;

import lombok.extern.slf4j.Slf4j;
import mono.repo.entity.Board;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;


/**
 * Description : JUnit4 Service Test
 *
 * @author leejinho
 * @version 1.0
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class BoardServiceTest {

    @Autowired
    private BoardService boardService;

    @BeforeClass
    public static void beforeAll() {
        log.info("===================beforeAll()===================");
    }

    @Before
    public void setUp() {
        log.info("===================setUp()===================");
    }

    /**
     * @Rollback(false): 한 트랜잭션에서 테스트 진행
     * Transactional: rollback 여부(True/False)
     */
    @Test
    public void saveBoard() {
        // given
        Board board = Board.builder()
                .author("홍길동")
                .title("JUnit4")
                .content("JUnit4를 활용한 TDD")
                .build();

        // when
        Long savedId = boardService.saveBoard(board);
        Board savedBoard = boardService.findBoardById(savedId);

        // then
        Assertions.assertThat(savedBoard.getId()).isEqualTo(board.getId());
        Assertions.assertThat(savedBoard.getAuthor()).isEqualTo(board.getAuthor());
        Assertions.assertThat(savedBoard.getContent()).isEqualTo(board.getContent());
        Assertions.assertThat(savedBoard).isEqualTo(board);
    }

    @Test
    public void findBoardById() {
        // given
        Board board = Board.builder()
                .title("JUnit4")
                .author("홍길동")
                .content("test 입니다.")
                .build();

        boardService.saveBoard(board);

        // when
        Board savedBoard = boardService.findBoardById(1L);

        // then
        assert (savedBoard.getAuthor().equals("홍길동"));
        assert (savedBoard.getTitle().equals("JUnit4"));
    }

    @Test
    public void findBoard() {
        // given
        Board board = Board.builder()
                .title("JUnit4")
                .author("홍길동")
                .content("test 입니다.")
                .build();

        // when
        boardService.saveBoard(board);

        // then
        Board savedBoard = boardService.findBoardByAuthor("홍길동");
        Assertions.assertThat(savedBoard.getTitle()).isEqualTo("JUnit4");
    }

    @Test
    public void deleteBoard() {
        // given
        Board board = Board.builder()
                .title("JUnit4")
                .author("홍길동")
                .content("test 입니다.")
                .build();

        boardService.saveBoard(board);

        // when
        Board savedBoard = boardService.findBoardByAuthor("홍길동");
        boardService.deleteBoard(savedBoard);

        // then
        List<Board> boardList = boardService.findBoard();
        Assertions.assertThat(boardList.size() == 0);
    }

    @After
    public void tearDown() {
        log.info("===================tearDown()===================");
    }

    @AfterClass
    public static void afterClass() {
        log.info("===================afterClass()===================");
    }
}