package mono.repo.repository;

import mono.repo.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Description :
 *
 * @author leejinho
 * @version 1.0
 */
public interface BoardRepository extends JpaRepository<Board, Long> {
    Board findBoardById(Long id);
    List<Board> findAll(Board board);
}
