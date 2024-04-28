package net.opencode.practice.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import net.opencode.practice.component.handler.calculator.MedicalCalculatorHandler;
import net.opencode.practice.data.CalculatorType;
import org.springframework.stereotype.Service;

import java.util.Map;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Service
@Slf4j
public class MedicalCalculatorServiceImpl implements MedicalCalculatorService {

    Map<CalculatorType, MedicalCalculatorHandler> calculatorHandlers;

    @Override
    public void getModelFromDataObject(CalculatorType calculatorType) {
        var handler = calculatorHandlers.get(calculatorType);

        log.info("calculatorHadler - " + handler.toString());
    }
}
