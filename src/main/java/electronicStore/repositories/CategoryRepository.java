package electronicStore.repositories;

import electronicStore.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {

    Category findByIdAndDeleted(String id, boolean deleted);

    Category findByTitleAndDeleted(String title, boolean deleted);

    Category findByTitleAndDeletedAndIdNot(String title, boolean deleted, String id);

    List<Category> findByDeleted(boolean deleted);
}
