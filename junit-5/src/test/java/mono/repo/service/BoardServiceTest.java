package mono.repo.service;

import lombok.extern.slf4j.Slf4j;
import mono.repo.entity.Board;
import mono.repo.repository.BoardRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Description : Board Service(Interface) Test
 *
 * @author leejinho
 * @version 1.0
 */
@Slf4j
@ExtendWith(SpringExtension.class)
class BoardServiceTest {

    private Board board;

    @Mock
    private BoardRepository boardRepository;

    @Mock
    private BoardService boardService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void increaseViews() {
        // given
        Board board = Board.builder()
                .title("JUnit5")
                .author("홍길동")
                .content("TDD")
                .views("0")
                .build();

        BDDMockito.given(boardRepository.save(board))
                .willReturn(
                        Board.builder()
                                .id(1L)
                                .title("JUnit5")
                                .author("홍길동")
                                .content("TDD")
                                .views("0")
                                .build()
                );

        Board savedBoard = boardRepository.save(board);
        log.info(savedBoard.getId().toString());

        // when
        Optional<Board> findBoard = boardRepository.findById(savedBoard.getId());
//        String findBoardViews = findBoard.get().getViews();
//        findBoardViews = findBoardViews + 1;

        // then
        assertEquals(1L, savedBoard.getId());
    }
}