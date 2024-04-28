package net.opencode.practice.component.handler.calculator.impl;

import lombok.extern.slf4j.Slf4j;
import net.opencode.practice.component.handler.calculator.MedicalCalculatorHandler;
import net.opencode.practice.data.CalculatorType;
import net.opencode.practice.model.AbstractModel;
import net.opencode.practice.model.ResultInfo;
import net.opencode.practice.model.impl.ImtModel;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class ImtCalculator implements MedicalCalculatorHandler {

    @Override
    public ResultInfo calculate(AbstractModel modelData) {
        var model = (ImtModel) modelData;
        var height = (double) model.getH() / 100;

        return new ResultInfo((double) model.getM() / (height * height));
    }

    @Override
    public CalculatorType getCalculatorType() {
        return CalculatorType.IMT;
    }
}
