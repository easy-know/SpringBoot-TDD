package mono.repo.service;

import mono.repo.repository.BoardRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Description :
 *
 * @author leejinho
 * @version 1.0
 */
@DataJpaTest
class BoardInterfaceTest {

    @MockBean
    BoardRepository boardRepository;

    @Test
    void findLikes() {
    }

    @Test
    void findViews() {
    }
}