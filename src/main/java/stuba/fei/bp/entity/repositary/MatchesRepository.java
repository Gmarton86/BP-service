package stuba.fei.bp.entity.repositary;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import stuba.fei.bp.entity.Matches;

@Repository
@Transactional
public interface MatchesRepository extends CrudRepository<Matches, Long> {
    @Query("select u from Matches as u "
            + " where u.Player1ID = :player1ID and u.Player2ID = :player2ID")
    Matches getMatchByPlayers(@Param("player1ID") Integer player1ID, @Param("player2ID") Integer player2ID);
    @Modifying
    @Query("delete from Matches "
            + " where TournamentName = :name")
    void customDelete(@Param("name") String name);
}
