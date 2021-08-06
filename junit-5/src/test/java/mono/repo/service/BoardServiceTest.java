package mono.repo.service;

import mono.repo.entity.Board;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Description :
 *
 * @author leejinho
 * @version 1.0
 */
@SpringBootTest
class BoardServiceTest {

    @Autowired BoardService boardService;
    Board board = new Board();

    @BeforeAll
    static void beforeAll() {
        System.out.println("===================beforeAll()===================");
    }

    @BeforeEach
    void setUp() {
        System.out.println("===================setUp()===================");
        board.setAuthor("홍길동");
        board.setTitle("JUnit4");
        board.setContent("JUnit4를 활용한 TDD");
    }

    @Test
    @Transactional
    void saveBoard() {
        System.out.println("===================게시글_등록()===================");
        Long savedId = boardService.saveBoard(board);
        Board savedBoard = boardService.findBoardById(savedId);

        Assertions.assertThat(savedBoard.getId()).isEqualTo(board.getId());
        Assertions.assertThat(savedBoard.getAuthor()).isEqualTo(board.getAuthor());
        Assertions.assertThat(savedBoard.getContent()).isEqualTo(board.getContent());
        Assertions.assertThat(savedBoard).isEqualTo(board);
    }

    @AfterEach
    void tearDown() {
        System.out.println("===================tearDown()===================");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("===================afterClass()===================");
    }
}