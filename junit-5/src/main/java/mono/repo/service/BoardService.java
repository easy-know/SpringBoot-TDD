package mono.repo.service;

import mono.repo.entity.Board;

/**
 * Description : Board Service
 *
 * @author leejinho
 * @version 1.0
 */
public interface BoardService extends CRUDService<Board, Long> {
    public Integer findLikes(Long id);
    public Integer findViews(Long id);
}
