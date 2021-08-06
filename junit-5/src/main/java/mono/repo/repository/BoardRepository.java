package mono.repo.repository;

import mono.repo.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Description :
 *
 * @author leejinho
 * @version 1.0
 */
public interface BoardRepository extends JpaRepository<Board, Long> {
    Board findBoardById(Long id);
}
