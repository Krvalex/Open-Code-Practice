package net.opencode.practice.component.handler.calculator;

import net.opencode.practice.data.CalculatorType;
import net.opencode.practice.model.AbstractModel;

public interface MedicalCalculatorHandler {

    AbstractModel<CalculatorType> calculate(Object model);

    CalculatorType getCalculatorType();
}
