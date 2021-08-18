package mono.repo.repository;

import lombok.extern.slf4j.Slf4j;
import mono.repo.entity.Board;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Description : Board Repository 테스트
 *
 * @author leejinho
 * @version 1.0
 */

@Slf4j
@DataJpaTest
@ExtendWith(SpringExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Transactional
class BoardRepositoryTest {

    @Autowired
    private BoardRepository boardRepository;

    private Board board;

    @BeforeEach
    void setUp() {
        // given
        board = Board.builder()
                .views("0")
                .content("tdd")
                .author("홍길동")
                .title("junit5")
                .build();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @Disabled
    @Order(3)
    void 이름으로_게시글_찾기_실패() {
        // when
        Optional<Board> findBoard = boardRepository.findByAuthor("홍길동");

        // then
        assertFalse(findBoard.isPresent());
    }

    @Test
    @Order(2)
    @DisplayName("이름으로 게시글 찾기")
    void findByAuthor() {
        // when
        Optional<Board> findBoard = boardRepository.findByAuthor("청길동");

        // then
        assertFalse(findBoard.isPresent());
    }

    @Test
    @Order(1)
    @DisplayName("게시글 생성")
    @Rollback(value = false)
    void save() {
        // when
        boardRepository.save(board);

        // then
        List<Board> all = boardRepository.findAll();
        assertEquals(1, all.size());
    }
}