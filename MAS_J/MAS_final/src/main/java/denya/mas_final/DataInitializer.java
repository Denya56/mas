package denya.mas_final;

import denya.mas_final.model.*;
import denya.mas_final.model.enums.*;
import denya.mas_final.repository.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class DataInitializer {
    private final GameRepository gameRepository;
    private final DigitalCopyRepository digitalCopyRepository;
    private final PhysicalCopyRepository physicalCopyRepository;
    private final ShopUserRepository shopUserRepository;
    private final DLCRepository dlcRepository;

    @EventListener
    public void atStart(ContextRefreshedEvent ev) {
        resetDatabase();

        System.out.println("Context refreshed");
        Game g1 = Game.builder()
                .name("Project Chronos")
                .description("Project Chronos - 2d puzzle platformer with time manipulation")
                .releaseDate(LocalDate.of(2022, 6, 15))
                .developer("Gruppe Nein")
                .publisher("Gruppe Nein")
                .genres(Set.of(Genres.PUZZLE, Genres.ACTION))
                .build();

        Game g2 = Game.builder()
                .name("Half Life")
                .description("We all know it")
                .releaseDate(LocalDate.of(1999, 6, 15))
                .developer("Valve")
                .publisher("Valve")
                .genres(Set.of(Genres.SHOOTER, Genres.ACTION, Genres.HORROR))
                .build();

        DLC dlc2 = DLC.builder()
                .name("Half Life 3")
                .description("Ain't no way")
                .releaseDate(LocalDate.of(2024, 6, 15))
                .developer("Valve")
                .publisher("Valve")
                .requiredGameName(g2.getName())
                .build();

        Game g3 = Game.builder()
                .name("CS GO 2")
                .description("yeah it's here")
                .releaseDate(LocalDate.of(2023, 6, 15))
                .developer("Valve")
                .publisher("Valve")
                .genres(Set.of(Genres.SHOOTER, Genres.ACTION))
                .build();
        gameRepository.saveAll(List.of(g1, g2, g3));
        dlcRepository.save(dlc2);

        ShopUser s1 = ShopUser.builder()
                .firstName("Lee")
                .lastName("Yamada")
                .phoneNumber("1234567890")
                .login("leeyama")
                .email("leeyama@gmail.com")
                .password("leexdd")
                .userRoles(Set.of(UserRole.CUSTOMER, UserRole.SELLER))
                .discountRate(0.05)
                .customerTier(CustomerTier.ONE)
                .companyName("Gruppe Nein")
                .build();

        ShopUser s2 = ShopUser.builder()
                .firstName("Who")
                .middleName("Is")
                .lastName("This")
                .phoneNumber("878787878")
                .login("dare")
                .email("dare@gmail.com")
                .password("darekore")
                .userRoles(Set.of(UserRole.CUSTOMER, UserRole.SELLER))
                .discountRate(0.05)
                .customerTier(CustomerTier.ONE)
                .companyName("Valve")
                .build();

        ShopUser s3 = ShopUser.builder()
                .firstName("John")
                .lastName("LeBlank")
                .phoneNumber("9087665388")
                .login("blank")
                .email("blank@gmail.com")
                .password("blankxdd")
                .userRoles(Set.of(UserRole.CUSTOMER, UserRole.SELLER))
                .discountRate(0.05)
                .customerTier(CustomerTier.ONE)
                .companyName("Valve")
                .build();

        shopUserRepository.saveAll(List.of(s1, s2, s3));


        DigitalCopy dc1 = DigitalCopy.builder()
                .price(50.0)
                .status(Status.AVAILABLE)
                .quantity(10)
                .productPlatform(ProductPlatform.PC)
                .minRequirements("None")
                .recommendedRequirements("same")
                .baseProduct(g1)
                .seller(s1)
                .activationCode("qwer")
                .build();

        PhysicalCopy pc2 = PhysicalCopy.builder()
                .price(100.0)
                .status(Status.AVAILABLE)
                .quantity(5)
                .productPlatform(ProductPlatform.CONSOLE)
                .baseProduct(g2)
                .seller(s3)
                .consoleName("XBOX")
                .consoleGeneration("5")
                .physicalSize("20x30x10")
                .contents(List.of("Game disc", "ArtBook"))
                .weight("300g")
                .build();

        DigitalCopy dc2 = DigitalCopy.builder()
                .price(100.0)
                .status(Status.AVAILABLE)
                .quantity(10)
                .productPlatform(ProductPlatform.CONSOLE)
                .consoleName("XBOX")
                .consoleGeneration("5")
                .baseProduct(dlc2)
                .seller(s3)
                .activationCode("half")
                .build();

        DigitalCopy dc3 = DigitalCopy.builder()
                .price(200.0)
                .status(Status.AVAILABLE)
                .quantity(10)
                .productPlatform(ProductPlatform.PC)
                .minRequirements("Too high")
                .recommendedRequirements("Quantum PC")
                .baseProduct(g3)
                .seller(s3)
                .activationCode("csgooooo")
                .build();

        physicalCopyRepository.save(pc2);
        digitalCopyRepository.saveAll(List.of(dc1, dc2, dc3));
    }

    @Transactional
    public void resetDatabase() {
        digitalCopyRepository.deleteAll();
        physicalCopyRepository.deleteAll();
        gameRepository.deleteAll();
        dlcRepository.deleteAll();
        shopUserRepository.deleteAll();
    }
}
