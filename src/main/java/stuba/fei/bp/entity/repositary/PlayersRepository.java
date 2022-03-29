package stuba.fei.bp.entity.repositary;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import stuba.fei.bp.entity.Players;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlayersRepository extends CrudRepository<Players, Long> {
    List<Players> findAll();
    Players findById(Long id);
}
