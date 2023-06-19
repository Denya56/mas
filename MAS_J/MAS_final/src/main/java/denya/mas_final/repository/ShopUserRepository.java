package denya.mas_final.repository;

import denya.mas_final.model.ShopUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ShopUserRepository extends CrudRepository<ShopUser, Long> {
    @Query("SELECT su FROM ShopUser su JOIN su.userRoles ur WHERE ur = 'SELLER'")
    List<ShopUser> findSellers();

}
