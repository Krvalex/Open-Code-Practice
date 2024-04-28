package net.opencode.practice.component.handler.calculator.impl;

import lombok.extern.slf4j.Slf4j;
import net.opencode.practice.component.handler.calculator.MedicalCalculatorHandler;
import net.opencode.practice.data.CalculatorType;
import net.opencode.practice.model.AbstractModel;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class IMTCalculator implements MedicalCalculatorHandler {

    @Override
    public AbstractModel<CalculatorType> calculate(Object model) {
        log.info("IMTCalculator calculate");
        return null;
    }

    @Override
    public CalculatorType getCalculatorType() {
        return CalculatorType.IMT;
    }
}
