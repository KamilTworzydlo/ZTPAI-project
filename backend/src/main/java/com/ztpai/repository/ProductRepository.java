package pl.tworzydlo.ztpai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.tworzydlo.ztpai.entity.ProductEntity;

public interface ProductRepository
        extends JpaRepository<ProductEntity, Integer> {
}
