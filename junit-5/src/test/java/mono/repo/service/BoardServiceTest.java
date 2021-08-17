package mono.repo.service;

import lombok.extern.slf4j.Slf4j;
import mono.repo.entity.Board;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Description :
 *
 * @author leejinho
 * @version 1.0
 */
@Slf4j
@ExtendWith(MockitoExtension.class)
@SpringBootTest
class BoardServiceTest {

    @Autowired
    private BoardServiceImpl boardService;
    private Board board;

    @BeforeEach
    void setUp() {
        log.info("============setUp()============");
        board = Board.builder()
                .title("JUnit5 Service Test")
                .author("홍길동")
                .content("TDD")
                .build();
    }

    @AfterEach
    void tearDown() {
        log.info("============tearDown()============");
    }

    @Test
    void saveBoard() {
        // when
        Long savedBoardId = boardService.saveBoard(board);

        // then
        assert (savedBoardId == 1L);
    }

    @Test
    @Transactional
    void findBoardById() {
        // given
        Long saveBoardId = boardService.saveBoard(board);

        // when
        Board savedBoard = boardService.findBoardById(saveBoardId);

        // then
        assert (saveBoardId.equals(savedBoard.getId()));
    }

    @Test
    void findBoardByAuthor() {
        // given
        boardService.saveBoard(board);

        // when
        Board savedBoard = boardService.findBoardByAuthor("홍길동");

        // then
        assert (savedBoard.getAuthor().equals("홍길동"));
    }

    @Test
    void findBoard() {
        // given
        boardService.saveBoard(board);

        // when
        List<Board> boardList = boardService.findBoard();

        // then
        assert (boardList.size() == 1);
    }

    @Test
    void deleteBoard() {
        // given
        boardService.saveBoard(board);

        // when
        boardService.deleteBoard(board);

        // then
        List<Board> boardList = boardService.findBoard();
        Assertions.assertThat(boardList.size() == 0);
    }
}