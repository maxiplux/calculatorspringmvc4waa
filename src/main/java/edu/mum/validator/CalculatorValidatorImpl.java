package edu.mum.validator;


import edu.mum.domain.Calculator;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class CalculatorValidatorImpl implements CalculatorValidator {

	@Override
	public List<String> validate(Object object) {
		List<String> errors = new ArrayList<String>();

		Calculator calculator = (Calculator) object;

		Integer add1 = calculator.getAdd1();
		Integer add2 = calculator.getAdd2();
		Integer mult1 = calculator.getMult1();
		Integer mult2 = calculator.getMult2();

		if (add1 == null || add2 == null || mult1 == null || mult2 == null) {
			errors.add("Number is not empty");
		}

		return errors;
	}

}
