package stuba.fei.bp.entity.repositary;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import stuba.fei.bp.entity.Users;

public interface UsersRepository extends CrudRepository<Users, Long> {
    @Query("select u from Users as u "
            + " where u.Username = :username")
    Users findByUsername(@Param("username") String username);
    @Query("select u from Users as u "
            + " where u.Username = :username and u.Password = :password")
    Users getUserByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    @Query("select u from Users as u "
            + " where u.TrainerUsr = :username and u.TrainerPasswd = :password")
    Users getTrainerByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}

