package net.opencode.practice.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import net.opencode.practice.component.handler.calculator.MedicalCalculatorHandler;
import net.opencode.practice.data.CalculatorType;
import net.opencode.practice.model.AbstractModel;
import net.opencode.practice.model.ResultInfo;
import org.springframework.stereotype.Service;

import java.util.Map;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Service
@Slf4j
public class MedicalCalculatorServiceImpl implements MedicalCalculatorService {

    Map<CalculatorType, MedicalCalculatorHandler> calculatorHandlers;

    @Override
    public ResultInfo getResultFromCalculator(CalculatorType calculatorType, AbstractModel model) {
        var handler = this.calculatorHandlers.get(calculatorType);

        return handler.calculate(model);
    }
}
