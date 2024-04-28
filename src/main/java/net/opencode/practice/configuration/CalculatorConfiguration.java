package net.opencode.practice.configuration;

import net.opencode.practice.component.handler.calculator.MedicalCalculatorHandler;
import net.opencode.practice.data.CalculatorType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class CalculatorConfiguration {

    @Bean
    public Map<CalculatorType, MedicalCalculatorHandler> calculatorHandlers(List<MedicalCalculatorHandler> handlers) {
        var map = new HashMap<CalculatorType, MedicalCalculatorHandler>();

        for (var handler : handlers) {
            map.compute(handler.getCalculatorType(), (_, medicalCalculatorHandler) -> {
                if (medicalCalculatorHandler == null) medicalCalculatorHandler = handler;

                return medicalCalculatorHandler;
            });
        }
        return map;
    }
}
