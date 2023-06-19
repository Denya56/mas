package denya.mas_final.customConstraints;

import denya.mas_final.model.ProductCopy;
import denya.mas_final.model.enums.ProductPlatform;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PCFieldsValidator implements ConstraintValidator<ValidPCFields, ProductCopy> {
    public PCFieldsValidator() {
    }
    @Override
    public void initialize(ValidPCFields constraintAnnotation) {
    }

    @Override
    public boolean isValid(ProductCopy productCopy, ConstraintValidatorContext context) {
        if (productCopy.getProductPlatform() == ProductPlatform.PC) {
            if (productCopy.getMinRequirements() == null || productCopy.getRecommendedRequirements() == null) {
                buildErrorMessage(context, "minRequirements and recommendedRequirements are mandatory for ProductPlatform.PC");
                return false;
            }
            if(productCopy.getConsoleName() != null || productCopy.getConsoleGeneration() != null) {
                buildErrorMessage(context, "consoleName and consoleGeneration cannot be present for ProductPlatform.PC");
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
