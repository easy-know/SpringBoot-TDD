package mono.repo.repository;

import lombok.extern.slf4j.Slf4j;
import mono.repo.entity.Board;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


/**
 * Description : Jpa Test Class
 *  - @DataJpaTest에서 EntityManager의 대체제로 만들어진 테스트용 TestEntityManager를 사용하면 persist, flush, find 등과 같은 기본적인 JPA테스트가 가능하다.
 *
 * @author leejinho
 * @version 1.0
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@Slf4j
public class BoardRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private BoardRepository boardRepository;

    @Before
    public void setUp() {
        log.info("=========setUp()=========");
    }

    @After
    public void tearDown() {
        log.info("=========tearDown()=========");
    }

    @Test
    public void 아이디로_검색하기() {
        // given
        Board board1 = Board.builder()
                .title("(1) - JUnit4 @DataJpaTest")
                .author("홍길동")
                .content("test 입니다.")
                .build();

        testEntityManager.persist(board1);

        // when
        Board savedBoard = boardRepository.findBoardById(1L);

        // then
        assert (board1.getAuthor()).equals(savedBoard.getAuthor());
    }

    /**
     * Save()
     * - 저장 후 생성 된 ID를 반환합니다. 그것의 Serializable반환 형식.
     * - 트랜잭션 외부의 DB에 변경 사항을 저장하십시오.
     * - 생성 된 ID를 유지중인 엔티티에 할당
     * - 분리 된 객체에 대한 Session.save ()는 테이블에 새로운 행을 만듭니다.
     *
     * Persist()
     * - 저장 후 생성 된 ID를 반환하지 않습니다. void 리턴 타입입니다.
     * - 트랜잭션 외부의 DB에 대한 변경 사항을 저장하지 않습니다.
     * - generated id지속중인 엔터티 에을 할당합니다
     * - session.persist()분리 된 객체는 PersistentObjectException허용되지 않으므로 throw 됩니다.
     */
    @Test
    public void 저장하기() {
        // given
        Board board1 = Board.builder()
                .title("(1) - JUnit4 @DataJpaTest")
                .author("홍길동")
                .content("test 입니다.")
                .build();

        testEntityManager.persist(board1);

        Board board2 = Board.builder()
                .title("(2) - JUnit4 @DataJpaTest")
                .author("청길동")
                .content("test 입니다.")
                .build();

        testEntityManager.persist(board2);

        Board board3 = Board.builder()
                .title("(2) - JUnit4 @DataJpaTest")
                .author("중길동")
                .content("test 입니다.")
                .build();

        testEntityManager.persist(board3);

        // when
        List<Board> boardList = boardRepository.findAll();

        // then
        assert (boardList.size() == 3);
    }
}