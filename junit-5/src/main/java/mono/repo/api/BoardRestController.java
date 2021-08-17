package mono.repo.api;

import lombok.RequiredArgsConstructor;
import mono.repo.entity.Board;
import mono.repo.service.BoardServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Description : Rest Controller
 *
 * @author leejinho
 * @version 1.0
 */
@RestController
@RequestMapping("board")
@RequiredArgsConstructor
public class BoardRestController {

    private final BoardServiceImpl boardService;

    @GetMapping
    public ResponseEntity<List<Board>> loadBoard() {
        return ResponseEntity.ok(boardService.findBoard());
    }

    @GetMapping("{id}")
    public ResponseEntity<Board> loadBoardById(@PathVariable String id) {
        return ResponseEntity.ok(boardService.findBoardById(Long.valueOf(id)));
    }

    @PostMapping
    public ResponseEntity<Long> saveBoard(Board board) {
        return ResponseEntity.ok(boardService.saveBoard(board));
    }

    @PutMapping
    public ResponseEntity<Long> updateBoard(Board board) {
        return ResponseEntity.ok(boardService.saveBoard(board));
    }

    @DeleteMapping
    public ResponseEntity<Long> deleteBoard(Board board) {
        boardService.deleteBoard(board);
        return ResponseEntity.ok().build();
    }
}
