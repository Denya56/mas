package mas.denys.mas_mp5.repository;

import mas.denys.mas_mp5.model.Player;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PlayerRepository extends CrudRepository<Player, Long> {
    public List<Player> findByName(String name);
    public List<Player> findByNameAndLevel(String name, int level);

    @Query("from Player where level > :minLevel")
    public List<Player> findPlayersWithLevelGreaterThan(@Param("minLevel") int minLevel);

    @Query("from Player as p left join fetch p.itemBags where p.id = :id")
    public Optional<Player> findById(@Param("id") Long id);

}
