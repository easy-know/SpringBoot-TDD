package mono.repo.repository;

import mono.repo.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Description : Board Repository
 *
 * @author leejinho
 * @version 1.0
 */
@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
    Optional<Board> findByAuthor(String author);
}
