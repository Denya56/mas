package denya.mas_final.repository;

import denya.mas_final.interfaces.ProductDetails;
import denya.mas_final.interfaces.ProductInfo;
import denya.mas_final.model.ProductCopy;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductCopyRepository extends CrudRepository<ProductCopy, Long> {
    @Query("SELECT pc.id as id, pc.price as price, bp.name as name FROM ProductCopy pc join pc.baseProduct bp WHERE pc.seller.id = :id")
    List<ProductInfo> findBySeller(@Param("id") Long id);

    @Query("SELECT pc.id as id, pc.price as price, pc.productPlatform as productPlatform, pc.status as status, pc.minRequirements as minRequirements," +
            "pc.quantity as quantity, pc.recommendedRequirements as recommendedRequirements, pc.consoleGeneration as consoleGeneration," +
            "pc.consoleName as consoleName, bp.name as name, bp.description as description, bp.releaseDate as releaseDate," +
            "bp.developer as developer, bp.publisher as publisher FROM ProductCopy pc join pc.baseProduct bp WHERE pc.id = :id")
    ProductDetails getDetailsById(@Param("id") Long id);
}
