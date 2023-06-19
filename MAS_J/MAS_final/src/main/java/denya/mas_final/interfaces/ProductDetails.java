package denya.mas_final.interfaces;

import denya.mas_final.model.enums.ProductPlatform;
import denya.mas_final.model.enums.Status;

import java.time.LocalDate;

public interface ProductDetails {
    Long getId();
    String getName();
    String getDescription();
    LocalDate getReleaseDate();
    String getDeveloper();
    String getPublisher();

    Double getPrice();
    Integer getQuantity();
    ProductPlatform getProductPlatform();
    String getMinRequirements();
    String getRecommendedRequirements();
    String getConsoleName();
    String getConsoleGeneration();
    Status getStatus();
}
