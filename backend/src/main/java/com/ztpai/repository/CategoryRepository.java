package pl.tworzydlo.ztpai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.tworzydlo.ztpai.entity.CategoryEntity;

public interface CategoryRepository
        extends JpaRepository<CategoryEntity, Integer> {
}
