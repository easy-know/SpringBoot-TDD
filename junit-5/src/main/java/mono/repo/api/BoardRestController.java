package mono.repo.api;

import lombok.RequiredArgsConstructor;
import mono.repo.entity.Board;
import mono.repo.repository.BoardRepository;
import mono.repo.service.BoardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
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

    private final BoardService boardService;
    private final BoardRepository boardRepository;

    @GetMapping
    public ResponseEntity<List<Board>> loadBoard() {
        return ResponseEntity.ok(boardService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Board> loadBoardById(@PathVariable String id) {
        return ResponseEntity.ok(boardService.find(Long.valueOf(id)));
    }

    @PostMapping
    public ResponseEntity<Long> saveBoard(@RequestBody Board board) {
        return ResponseEntity.created(URI.create("/main")).body(boardService.save(board));
    }

    @PutMapping
    public ResponseEntity<Board> updateBoard(@RequestBody Board board) {
        return ResponseEntity.ok(boardService.update(board));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteBoard(@PathVariable String id) {
        return ResponseEntity.ok(boardService.delete(Long.valueOf(id)));
    }
}
