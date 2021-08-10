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


/**
 * Description : JUnit4 Service Test
 *
 * @author leejinho
 * @version 1.0
 */
@RunWith(SpringRunner.class)
@Slf4j
@SpringBootTest
@Transactional
public class BoardServiceTest {

    @Autowired
    private BoardService boardService;

    @BeforeClass
    public static void beforeAll() {
        System.out.println("===================beforeAll()===================");
    }

    @Before
    public void setUp() {
        System.out.println("===================setUp()===================");
    }

    /**
     * @Rollback(false): 한 Transaction에서 테스트 진행
     * Transactional: rollback 여부(True/False)
     */
    @Test
    public void saveBoard() {
        System.out.println("===================saveBoard()===================");
        Board board = Board.builder()
                .author("홍길동")
                .title("JUnit4")
                .content("JUnit4를 활용한 TDD")
                .build();

        Long savedId = boardService.saveBoard(board);
        Board savedBoard = boardService.findBoardById(savedId);

        Assertions.assertThat(savedBoard.getId()).isEqualTo(board.getId());
        Assertions.assertThat(savedBoard.getAuthor()).isEqualTo(board.getAuthor());
        Assertions.assertThat(savedBoard.getContent()).isEqualTo(board.getContent());
        Assertions.assertThat(savedBoard).isEqualTo(board);
    }

    @Test
    public void findBoardById() {
        Board savedBoard = boardService.findBoardById(1L);

        assert (savedBoard.getAuthor().equals("홍길동"));
        assert (savedBoard.getTitle().equals("JUnit4"));

//        Assertions.assertThat(savedBoard.getAuthor()).isEqualTo("홍길동");
//        Assertions.assertThat(savedBoard.getTitle()).isEqualTo("JUnit4");
    }

    @Test
    public void findBoard() {
    }

    @Test
    public void deleteBoard() {
        Board savedBoard = boardService.findBoardById(1L);
        boardService.deleteBoard(savedBoard);
    }

    @After
    public void tearDown() {
        System.out.println("===================tearDown()===================");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("===================afterClass()===================");
    }
}