package mono.repo.service;

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
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Description :
 *
 * @author leejinho
 * @version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardServiceTest {

    @Autowired BoardService boardService;
    Board board = new Board();

    @BeforeClass
    public static void beforeAll() throws Exception {
        System.out.println("===================beforeAll()===================");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("===================setUp()===================");
        board.setAuthor("홍길동");
        board.setTitle("JUnit4");
        board.setContent("JUnit4를 활용한 TDD");
    }

    /**
     *
     * @Rollback(false): 한 Transaction에서 테스트 진행
     * Transactional: rollback 여부(True/False)
     *
     */
    @Test
    @Transactional
//    @Rollback(false)
    public void 게시글_등록() {
        System.out.println("===================게시글_등록()===================");

        Long savedId = boardService.saveBoard(board);
        Board savedBoard = boardService.findBoardById(savedId);

        Assertions.assertThat(savedBoard.getId()).isEqualTo(board.getId());
        Assertions.assertThat(savedBoard.getAuthor()).isEqualTo(board.getAuthor());
        Assertions.assertThat(savedBoard.getContent()).isEqualTo(board.getContent());
        Assertions.assertThat(savedBoard).isEqualTo(board);
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("===================tearDown()===================");
    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("===================afterClass()===================");
    }
}