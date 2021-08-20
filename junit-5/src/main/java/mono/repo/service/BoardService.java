package mono.repo.service;

import mono.repo.entity.Board;
import org.springframework.stereotype.Service;

/**
 * Description : Board Service
 *
 * @author leejinho
 * @version 1.0
 */
public interface BoardService extends CRUDService<Board, Long> {
    /**
     * 조회수 조회 메서드
     * @param id: pk
     */
    Board increaseViews(Long id);
}
