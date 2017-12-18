package fr.iocean;

import java.lang.annotation.*;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = IsbnValidator.class)
@Target(value = ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Isbn {
	String message() default"{validator.isbn}";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}


