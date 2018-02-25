package com.luv2code.validation;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class CourseCodeConstraintValidator
        implements ConstraintValidator<CourseCode, List<String>> {

    private String coursePrefix;
    private int minValue;

    @Override
    public void initialize(CourseCode theCourseCode) {
        coursePrefix = theCourseCode.value();
    }

    @Override
    public boolean isValid(List<String> theCode,
                           ConstraintValidatorContext theConstraintValidatorContext) {

        boolean result;

        if (theCode == null)
            return false;
        else {
            for(String str: theCode) {
                if(!str.matches("-?\\d+(\\.\\d+)?"))
                    return false;
                if(Integer.parseInt(str) < 0)
                    return false;

            }
        }

        return true;
    }
}








