package denya.mas_final.customConstraints;

import denya.mas_final.model.ProductCopy;
import denya.mas_final.model.enums.ProductPlatform;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ConsoleFieldsValidator implements ConstraintValidator<ValidConsoleFields, ProductCopy> {
    public ConsoleFieldsValidator() {
    }

    @Override
    public void initialize(ValidConsoleFields constraintAnnotation) {
    }

    @Override
    public boolean isValid(ProductCopy productCopy, ConstraintValidatorContext context) {
        if (productCopy.getProductPlatform() == ProductPlatform.CONSOLE) {
            if (productCopy.getConsoleName() == null || productCopy.getConsoleGeneration() == null) {
                buildErrorMessage(context, "consoleName and consoleGeneration are mandatory for ProductPlatform.CONSOLE");
                return false;
            }
            if(productCopy.getMinRequirements() != null || productCopy.getRecommendedRequirements() != null) {
                buildErrorMessage(context, "minRequirements and recommendedRequirements cannot be present for ProductPlatform.CONSOLE");
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
