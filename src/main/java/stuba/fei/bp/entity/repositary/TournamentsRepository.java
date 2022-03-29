package stuba.fei.bp.entity.repositary;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import stuba.fei.bp.entity.Tournaments;
import stuba.fei.bp.entity.Users;

import java.util.List;

@Repository
@Transactional
public interface TournamentsRepository extends CrudRepository<Tournaments, Long> {
    List<Tournaments> findAll();
    @Modifying
    @Query("delete from Tournaments "
            + " where Name = :name")
    void customDelete(@Param("name") String name);

    @Query("select t from Tournaments as t"
            + " where t.Name = :name")
    Tournaments findByName(@Param("name") String name);
}
