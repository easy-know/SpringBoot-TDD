package mono.repo.api;

import lombok.RequiredArgsConstructor;
import mono.repo.entity.Board;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import mono.repo.service.BoardService;

/**
 * Description :
 *
 * @author leejinho
 * @version 1.0
 */
@RestController
@RequestMapping("board")
@RequiredArgsConstructor
public class BoardRestController {
    
    private final BoardService boardService;

    @GetMapping(value = {"/", "/{id}"})
    public ResponseEntity loadBoard(Board board) {
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity saveBoard(Board boardDto) {
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity updateBoard(Board boardDto) {
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity deleteBoard(Board boardDto) {
        return ResponseEntity.ok().build();
    }
}
