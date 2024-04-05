package com.ItTest.validation;

import com.ItTest.anno.State;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class StateValidation implements ConstraintValidator<State,String> {

/*

 */
    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if(value==null){
            return false;
        }
        return value.equals("已发布") || value.equals("草稿");
    }
}
