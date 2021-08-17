package mono.repo.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Description :
 *
 * @author leejinho
 * @version 1.0
 */
public class BoardTest {
    @Test
    public void 아이디_가져오기() {
        final Board board = Board.builder()
                .title("JUnit5 Entity Test")
                .author("홍길동")
                .content("TDD")
                .build();

        final String name = board.getAuthor();
        assertEquals("홍길동", name);
    }
}