package mono.repo.service;

import lombok.RequiredArgsConstructor;
import mono.repo.entity.Board;
import mono.repo.repository.BoardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description : Board Service 구현체
 *
 * @author leejinho
 * @version 1.0
 */
@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    private final BoardRepository boardRepository;

    @Override
    public Board increaseViews(Long id) {

        Board findBoard = boardRepository.findById(id).get();
        Integer views = Integer.valueOf(findBoard.getViews());
        findBoard.setViews(String.valueOf(++views));

        return findBoard;
    }

    @Override
    public List<Board> findAll() {
        return boardRepository.findAll();
    }

    @Override
    public Board find(Long id) {
        return boardRepository.findById(id).get();
    }

    @Override
    public String delete(Long id) {
        boardRepository.deleteById(id);
        return id.toString();
    }

    @Override
    public Long save(Board board) {
        return boardRepository.save(board).getId();
    }

    @Override
    public Board update(Board board) {
        return null;
    }
}
