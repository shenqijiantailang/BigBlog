package com.ItTest.anno;

import com.ItTest.validation.StateValidation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotEmpty;

import java.lang.annotation.*;

@Documented
@Constraint(
        validatedBy = {StateValidation.class}
)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface State {
    String message() default "发布状态只能为已发布或者草稿";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
