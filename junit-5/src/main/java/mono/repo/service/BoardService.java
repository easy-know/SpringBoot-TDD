package mono.repo.service;

import lombok.RequiredArgsConstructor;
import mono.repo.entity.Board;
import mono.repo.repository.BoardRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public Board findBoardById(Long id) {
        return boardRepository.findBoardById(id);
    }
}
