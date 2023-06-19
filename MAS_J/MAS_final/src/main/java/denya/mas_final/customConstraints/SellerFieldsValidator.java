package denya.mas_final.customConstraints;

import denya.mas_final.model.ShopUser;
import denya.mas_final.model.enums.UserRole;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class SellerFieldsValidator implements ConstraintValidator<ValidSellerFields, ShopUser> {
    public SellerFieldsValidator() {

    }
    @Override
    public void initialize(ValidSellerFields constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(ShopUser shopUser, ConstraintValidatorContext context) {
        if(shopUser.getUserRoles().contains(UserRole.CUSTOMER) && shopUser.getUserRoles().contains(UserRole.SELLER)) {
            if(shopUser.getCompanyName() == null || shopUser.getDiscountRate() == null || shopUser.getCustomerTier() == null) {
                buildErrorMessage(context, "For UserRole.SELLER and UserRole.CUSTOMER all relative attributes are mandatory");
                return false;
            }
            return true;
        }
        if(shopUser.getUserRoles().contains(UserRole.SELLER)) {
            if(shopUser.getCompanyName() == null) {
                buildErrorMessage(context, "companyName are mandatory for UserRole.SELLER");
                return false;
            }
            if(shopUser.getDiscountRate() != null || shopUser.getCustomerTier() != null) {
                buildErrorMessage(context, "discountRate and customerTier cannot be present for UserRole.SELLER");
                return false;
            }
        }
        return true;
    }
    private void buildErrorMessage(ConstraintValidatorContext context, String message) {
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(message)
                .addConstraintViolation();
    }

}
