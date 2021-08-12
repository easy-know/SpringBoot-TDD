package mono.repo.repository;

import lombok.extern.slf4j.Slf4j;
import mono.repo.entity.Board;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


/**
 * Description : JUnit5 Board RepositoryTest
 *
 * @author leejinho
 * @version 1.0
 */
@Slf4j
@DataJpaTest
@ExtendWith(SpringExtension.class)
class BoardRepositoryTest {

    @Autowired
    private BoardRepository boardRepository;

    @BeforeEach
    void setUp() {
        log.info("======BeforeEach()======");
    }

    @AfterEach
    void tearDown() {
        log.info("======tearDown()======");
    }

    @Test
    void findBoardById() {
        // given
        Board board = Board.builder()
                .title("JUnit5 @DataJpaTest")
                .author("홍길동")
                .content("TDD")
                .build();

        Board savedBoard = boardRepository.save(board);

        // when
        Board findBoard = boardRepository.findBoardById(savedBoard.getId());

        // then
        assert (savedBoard.getTitle()).equals(findBoard.getTitle());
    }

    @Test
    void findByAuthor() {
        // given
        Board board = Board.builder()
                .title("JUnit5 @DataJpaTest")
                .author("홍길동")
                .content("TDD")
                .build();

        // when
        Board savedBoard = boardRepository.save(board);

        // then
        assert (board).equals(savedBoard);
    }

    @Test
    void save() {
        // given
        Board board = Board.builder()
                .title("")
                .author("")
                .content("")
                .build();

        // when
        Board savedBoard = boardRepository.save(board);

        // then
        assert (board).equals(savedBoard);
    }
}