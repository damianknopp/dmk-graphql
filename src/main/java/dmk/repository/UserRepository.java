package dmk.repository;

import dmk.model.User;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, UUID> {
    List<User> findByFirst(String first);

    @Query("select count(*) from USERS u where u.first = :first")
    long countByFirst(@Param("first") String first);
}
