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
@Constraint(validatedBy = ConsoleFieldsValidator.class)
@ReportAsSingleViolation
public @interface ValidConsoleFields {
    String message() default "Invalid console fields";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

