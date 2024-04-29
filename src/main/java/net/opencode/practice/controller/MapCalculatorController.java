package net.opencode.practice.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import net.opencode.practice.data.CalculatorType;
import net.opencode.practice.model.CalculatorInfo;
import net.opencode.practice.model.ResultInfo;
import net.opencode.practice.model.impl.MapModel;
import net.opencode.practice.service.MedicalCalculatorService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@RequestMapping("/map")
@RestController
@Validated
public class MapCalculatorController {

    MedicalCalculatorService medicalCalculatorService;

    @GetMapping("info")
    public CalculatorInfo get() {
        return new CalculatorInfo("""
                Калькулятор расчета среднего артериального давления по данным систолического и диастолического АД.
                Формула: Среднее артериальное давление (САД) = 1/3 * САД + 2/3 * ДАД.
                """);
    }

    @PostMapping("result")
    public ResultInfo result(@Validated @RequestBody MapModel model) {
        return this.medicalCalculatorService.getResultFromCalculator(CalculatorType.MAP, model);
    }
}
