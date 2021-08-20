package mono.repo.service;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description : CRUD Interface
 *
 * @author leejinho
 * @version 1.0
 */
public interface CRUDService <Entity, Long> {
    /**
     * Entity 리스트 반환 메서드
     * @return: list<Entity>
     */
    List<Entity> findAll();

    /**
     * Entity 반환 메서드
     * @param id: pk
     * @return:
     */
    Entity find(Long id);

    /**
     * Entity 삭제 메서드
     * @param id: pk
     */
    String delete(Long id);

    /**
     * Entity 저장 메서드
     * @param entity: Entity
     */
    Long save(Entity entity);

    /**
     * Entity 수정 메서드
     */
    Entity update(Entity entity);
}
