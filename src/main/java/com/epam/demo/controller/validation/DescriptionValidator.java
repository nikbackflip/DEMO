package com.epam.demo.controller.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DescriptionValidator implements ConstraintValidator<ValidDescription, String> {

    @Override
    public void initialize(ValidDescription contactNumber) {
    }

    @Override
    public boolean isValid(String bookDescription, ConstraintValidatorContext cxt) {
        return bookDescription.split(" ").length > 3;
    }

}