package fr.iocean;


import javax.validation.*;

import org.springframework.util.StringUtils;

public class IsbnValidator implements ConstraintValidator<Isbn, String> {

	@Override
	public void initialize(Isbn arg0) {
		
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		return StringUtils.isEmpty(value) || (10 <= value.length() && value.length() < 14);
	}

}
