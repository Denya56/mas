package denya.mas_final.model;


import denya.mas_final.Exceptions.InvalidUserRoleException;
import denya.mas_final.customConstraints.ValidCustomerFields;
import denya.mas_final.model.enums.CustomerTier;
import denya.mas_final.model.enums.UserRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@ValidCustomerFields
public class ShopUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "First name is mandatory")
    @Size(min = 2, max = 100)
    private String firstName;

    @Size(min = 2, max = 100)
    private String middleName;

    @NotBlank(message = "Last name is mandatory")
    @Size(min = 2, max = 100)
    private String lastName;

    @NotBlank(message = "Phone number is mandatory")
    @Size(min = 2, max = 20)
    private String phoneNumber;

    @NotBlank(message = "Login is mandatory")
    @Size(min = 2, max = 50)
    private String login;

    @NotBlank(message = "Email is mandatory")
    @Size(min = 2, max = 50)
    private String email;

    @NotBlank(message = "Password is mandatory")
    @Size(min = 2, max = 50)
    private String password;

    @ElementCollection
    @NotNull(message = "User roles are mandatory")
    @Size(min = 1)
    @CollectionTable(name = "UserRoles", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(value = EnumType.STRING)
    private Set<UserRole> userRoles;

    @Min(0)
    private Double discountRate;

    @Setter(AccessLevel.PRIVATE)
    @Enumerated(value = EnumType.STRING)
    private CustomerTier customerTier;

    @Size(min = 2, max = 100)
    private String companyName;

    @OneToMany(mappedBy = "seller")
    @Builder.Default
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<ProductCopy> sells = new HashSet<>();

    @OneToMany(mappedBy = "shopUser", cascade = CascadeType.REMOVE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<ProductOrder> productOrders;

    // Custom constraint
    public void calculateDiscountRate() throws InvalidUserRoleException {
        if(!userRoles.contains(UserRole.CUSTOMER)){
            throw new InvalidUserRoleException("User does not have a role of a customer");
        }

        if(customerTier.equals(CustomerTier.THREE)) {
            this.discountRate = Math.min(discountRate, 0.15);
        }
        else if(customerTier.equals(CustomerTier.TWO)) {
            this.discountRate = Math.min(discountRate, 0.1);
        }
        else this.discountRate = Math.min(discountRate, 0.05);
    }

    public void calculateTier() throws InvalidUserRoleException {
        if(!userRoles.contains(UserRole.CUSTOMER)) {
            throw new InvalidUserRoleException("User does not have a role of a customer");
        }
        if(productOrders.size() >= 30) {
            this.customerTier = CustomerTier.THREE;
        }
        else if (productOrders.size() >= 20) {
            this.customerTier = CustomerTier.TWO;
        }
        else this.customerTier = CustomerTier.ONE;
    }

    public void setDiscountRate(Double discountRate) throws InvalidUserRoleException {
        if(!userRoles.contains(UserRole.CUSTOMER)){
            throw new InvalidUserRoleException("User does not have a role of a customer");
        }
        this.discountRate = discountRate;
    }

    public void setCompanyName(String companyName) throws InvalidUserRoleException {
        if(!userRoles.contains(UserRole.SELLER)){
            throw new InvalidUserRoleException("User does not have a role of a seller");
        }
        this.companyName = companyName;
    }
}
