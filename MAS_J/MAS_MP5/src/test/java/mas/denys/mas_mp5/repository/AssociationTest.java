package mas.denys.mas_mp5.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import mas.denys.mas_mp5.model.Fighter;
import mas.denys.mas_mp5.model.ItemBag;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class AssociationTest {
    @Autowired
    private FighterRepository fighterRepository;
    @Autowired
    private ItemBagRepository itemBagRepository;

    @PersistenceContext
    private EntityManager entityManager;

    ItemBag ib1;
    Fighter f1;

    @BeforeEach
    public void initData() {
        f1 = Fighter.builder()
                .name("Aaron")
                .level(5)
                .maxHitPoints(50)
                .strength(15)
                .build();
        ib1 = ItemBag.builder()
                .name("QuickBar")
                .items(new ArrayList<>(List.of("Common Long Sword", "Health Potion")))
                .build();
    }

    @Test
    public void testRequiredDependencies() {
        assertNotNull(fighterRepository);
        assertNotNull(itemBagRepository);

    }

    @Test
    public void testSave() {
        f1.getItemBags().add(ib1);
        fighterRepository.save(f1);
        ib1.setBelongsTo(f1);
        itemBagRepository.save(ib1);

        entityManager.flush();

        Optional<Fighter> fighter = fighterRepository.findById(f1.getId());
        assertTrue(fighter.isPresent());
        System.out.println(fighter.get().getItemBags());
        assertEquals(1, fighter.get().getItemBags().size());
    }
}
