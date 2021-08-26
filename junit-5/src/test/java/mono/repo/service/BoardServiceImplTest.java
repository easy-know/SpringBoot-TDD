package mono.repo.service;

import lombok.extern.slf4j.Slf4j;
import mono.repo.entity.Board;
import mono.repo.repository.BoardRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Description : 게시판 Service Test
 *
 * @author leejinho
 * @version 1.0
 */
@Slf4j
@ExtendWith(MockitoExtension.class)
class BoardServiceImplTest {

    @Mock
    private BoardRepository boardRepository;
    private BoardServiceImpl boardServiceImpl;
    private Board board;

    @BeforeEach
    void setUp() {
        log.info("BeforeEach()");

        boardServiceImpl = new BoardServiceImpl(boardRepository);

        board = Board.builder()
                .author("홍길동")
                .title("JUnit5 Service Test")
                .content("TDD")
                .build();
    }

    @AfterEach
    void tearDown() {
        log.info("AfterEach()");
    }

    @Test
    void increaseViews() {
        log.info("increaseViews()");

    }

    @Test
    void findAll() {
        log.info("findAll()");

    }

    @Test
    void find() {
        log.info("find()");

    }

    @Test
    void delete() {
        log.info("delete()");

    }

    @Test
    void save() {
        log.info("save()");

    }

    @Test
    void update() {
        log.info("update()");

    }
}