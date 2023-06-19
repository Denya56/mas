package denya.mas_final.customConstraints;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.ReportAsSingleViolation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CustomerFieldsValidator.class)
@ReportAsSingleViolation
public @interface ValidCustomerFields {
    String message() default "Invalid customer fields";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

