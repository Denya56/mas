package mas.denys.mas_mp5.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.ConstraintViolationException;
import mas.denys.mas_mp5.model.Fighter;
import mas.denys.mas_mp5.model.Mage;
import mas.denys.mas_mp5.model.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PlayerRepositoryTest {

    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private FighterRepository fighterRepository;
    @Autowired
    private MageRepository mageRepository;
    Fighter f1;
    Mage m1;

    @BeforeEach
    public void initData() {
        f1 = Fighter.builder()
                .name("Aaron")
                .level(5)
                .maxHitPoints(50)
                .strength(15)
                .build();
        m1 = Mage.builder()
                .name("Feanor")
                .level(10)
                .maxHitPoints(35)
                .wisdom(30)
                .build();
    }

    @Test
    public void testRequiredDependencies() {
        assertNotNull(playerRepository);
        assertNotNull(fighterRepository);
    }

    @Test
    public void testFetchPlayers() {
        Iterable<Player> all = playerRepository.findAll();
        for (Player p : all) {
            System.out.println(p);
        }
    }

    @Test
    public void testSaveAll() {
        fighterRepository.save(f1);
        mageRepository.save(m1);
        entityManager.flush();
        assertEquals(2, playerRepository.count());
    }

    @Test
    public void testSaveInvalidPlayer() {
        assertThrows(ConstraintViolationException.class, () -> {
            f1.setLevel(-1);
            playerRepository.save(f1);
            entityManager.flush();
        });
    }

    @Test
    public void testFindByName() {
        playerRepository.save(f1);
        entityManager.flush();
        assertEquals(1,  playerRepository.findByName(f1.getName()).size());
    }

    @Test
    public void testFindByNameAndLevel() {
        playerRepository.save(f1);
        entityManager.flush();
        assertEquals(1,  playerRepository.findByNameAndLevel(f1.getName(), f1.getLevel()).size());
    }

    @Test
    public void testFindByLevelGreaterThan() {
        playerRepository.save(f1);
        entityManager.flush();
        assertEquals(1,  playerRepository.findPlayersWithLevelGreaterThan(2).size());
    }

    @Test
    public void testFindByIdFetchItemBags() {

    }
}