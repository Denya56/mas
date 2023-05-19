package mas.denys.mas_mp5.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.ConstraintViolationException;
import mas.denys.mas_mp5.model.Guild;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class GuildRepositoryTest {
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private GuildRepository guildRepository;

    Guild g1;

    @BeforeEach
    public void initData() {
        g1 = Guild.builder()
                .name("Aaron")
                .level(5)
                .totalGold(500)
                .build();
    }

    @Test
    public void testRequiredDependencies() {
        assertNotNull(guildRepository);
    }

    @Test
    public void testFetchPlayers() {
        Iterable<Guild> all = guildRepository.findAll();
        for (Guild g : all) {
            System.out.println(g);
        }
    }

    @Test
    public void testSavePlayer() {
        guildRepository.save(g1);
        entityManager.flush();
        assertEquals(1, guildRepository.count());
    }

    @Test
    public void testSaveInvalidPlayer() {
        assertThrows(ConstraintViolationException.class, () -> {
            g1.setLevel(-1);
            guildRepository.save(g1);
            entityManager.flush();
        });
    }

    @Test
    public void testFindByName() {
        guildRepository.save(g1);
        entityManager.flush();
        assertEquals(1,  guildRepository.findByName(g1.getName()).size());
    }

    @Test
    public void testFindByNameAndLevel() {
        guildRepository.save(g1);
        entityManager.flush();
        assertEquals(1,  guildRepository.findByNameAndLevel(g1.getName(), g1.getLevel()).size());
    }

    @Test
    public void testFindByLevelGreaterThan() {
        guildRepository.save(g1);
        entityManager.flush();
        assertEquals(1,  guildRepository.findByLevelGreaterThan(2).size());
    }

}