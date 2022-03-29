package stuba.fei.bp.entity.repositary;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import stuba.fei.bp.entity.Players;

import java.util.List;

@Repository
public interface PlayersRepository extends CrudRepository<Players, Long> {
    List<Players> findAll();
    @Query("select u from Players as u "
            + " where u.ID = :id")
    Players findCustomById(@Param("id") Long id);
}
