package mas.denys.mas_mp5.repository;

import mas.denys.mas_mp5.model.Guild;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GuildRepository extends CrudRepository<Guild, Long> {
    public List<Guild> findByName(String name);
    public List<Guild> findByNameAndLevel(String name, int level);
    @Query("from Guild where level > :minLevel")
    public List<Guild> findByLevelGreaterThan(@Param("minLevel")int minLevel);
}
