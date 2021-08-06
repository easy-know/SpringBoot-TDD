package mono.repo.api;

import mono.repo.entity.Board;
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

/**
 * Description :
 *
 * @author leejinho
 * @version 1.0
 */
@RestController
@RequestMapping("board")
public class BoardRestController {
    
    private BoardService boardService;

    @GetMapping
    public ResponseEntity loadBoard() {
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity saveBoard(@RequestBody Board boardDto) {
        return ResponseEntity.ok().build();
    }

    @PutMapping("{id}")
    public ResponseEntity updateBoard(@RequestBody Board boardDto, @PathVariable("id") Long id) {
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteBoard(@PathVariable("id") Long id) {
        return ResponseEntity.ok().build();
    }
}
