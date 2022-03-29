package stuba.fei.bp.entity.repositary;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import stuba.fei.bp.entity.Users;

public interface UsersRepository extends CrudRepository<Users, Long> {
    @Query("select u from Users as u "
            + " where u.Username = :username")
    Users findByUsername(@Param("username") String username);
}

