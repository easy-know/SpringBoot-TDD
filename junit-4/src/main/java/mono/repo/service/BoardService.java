package mono.repo.service;

import mono.repo.entity.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import mono.repo.repository.BoardRepository;

import java.util.List;

/**
 * Description :
 *
 * @author leejinho
 * @version 1.0
 */
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public Long saveBoard(Board board) {
        return boardRepository.save(board).getId();
    }

    // Optional 객체를 사용하면 예상치 못한 NullPointerException 예외를 제공되는 메소드로 간단히 회피할 수 있습니다.
    // 즉, 복잡한 조건문 없이도 널(null) 값으로 인해 발생하는 예외를 처리할 수 있게 됩니다.
    public Board findBoardById(Long id) {
        return boardRepository.findBoardById(id);
    }

    public List<Board> findBoard(Board board) {
        return boardRepository.findAll(board);
    }
}
