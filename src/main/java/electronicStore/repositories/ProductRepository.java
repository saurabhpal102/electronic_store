package electronicStore.repositories;

import electronicStore.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

    Product findByProductIdAndDeleted(String productId, boolean deleted);

    Product findByTitleAndDeleted(String title, boolean deleted);

    Product findByTitleAndDeletedAndProductIdNot(String title, boolean deleted, String productId);

    List<Product> findByDeleted(boolean deleted);
}
