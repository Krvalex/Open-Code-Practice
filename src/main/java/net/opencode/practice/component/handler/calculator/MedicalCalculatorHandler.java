package net.opencode.practice.component.handler.calculator;

import net.opencode.practice.data.CalculatorType;
import net.opencode.practice.model.AbstractModel;
import net.opencode.practice.model.ResultInfo;

public interface MedicalCalculatorHandler {

    ResultInfo calculate(AbstractModel model);

    CalculatorType getCalculatorType();
}

