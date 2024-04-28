package net.opencode.practice.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import net.opencode.practice.data.CalculatorType;
import net.opencode.practice.model.CalculatorInfo;
import net.opencode.practice.model.ResultInfo;
import net.opencode.practice.model.impl.ImtModel;
import net.opencode.practice.service.MedicalCalculatorService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@RequestMapping("/imt")
@RestController
@Validated
public class CalculatorController {

    MedicalCalculatorService medicalCalculatorService;

    @GetMapping("info")
    public CalculatorInfo get() {
        return new CalculatorInfo("""
                Этот калькулятор позволяет быстро и просто рассчитать индекс массы тела(ИМТ).
                Формула I=m/h*h, где: m — масса тела в килограммах; h — рост в метрах; измеряется в кг/м².
                Калькулятор рачитывает показатели в следующих интервалах: рост не более 300 см; вес не менее 10 кг.
                """);
    }

    @PostMapping("result")
    public ResultInfo result(@Validated @RequestBody ImtModel model) {
        return this.medicalCalculatorService.getResultFromCalculator(CalculatorType.IMT, model);
    }
}
