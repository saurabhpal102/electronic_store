package electronicStore.repositories;

import electronicStore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    User findUserByEmailAndDeleted(String email, boolean deleted);

    User findByIdAndDeleted(String Id, boolean deleted);

    User findByNameAndDeleted(String name, boolean deleted);

    User findByNameAndDeletedAndIdNot(String name, boolean deleted, String id);

    User findByNameContainingAndDeleted(String name, boolean deleted);

    List<User> findByDeleted(boolean deleted);
}
