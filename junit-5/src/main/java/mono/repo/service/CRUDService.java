package mono.repo.service;

import java.util.List;

/**
 * Description : CRUD Interface
 *
 * @author leejinho
 * @version 1.0
 */
public interface CRUDService <Entity, Long> {
    public List<Entity> selectList();
    public Entity select(Long id);
    public Long delete(Long id);
    public Long save(Entity entity);
    public Entity update(Entity entity);
}
