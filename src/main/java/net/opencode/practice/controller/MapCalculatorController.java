package net.opencode.practice.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import net.opencode.practice.data.CalculatorInfo;
import net.opencode.practice.data.CalculatorType;
import net.opencode.practice.data.ResultInfo;
import net.opencode.practice.data.impl.MapDto;
import net.opencode.practice.service.MedicalCalculatorService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@RequestMapping("/map")
@RestController
@Validated
public class MapCalculatorController {

    Map<CalculatorType, MedicalCalculatorService> medicalCalculatorServices;

    @GetMapping("info")
    public CalculatorInfo get() {
        return new CalculatorInfo("""
                Калькулятор расчета среднего артериального давления по данным систолического и диастолического АД.
                Формула: Среднее артериальное давление (САД) = 1/3 САД + 2/3 * ДАД.
                """);
    }

    @PostMapping("result")
    public ResultInfo result(@Validated @RequestBody MapDto dto) {
        var service = this.medicalCalculatorServices.get(CalculatorType.MAP);
        return service.calculate(dto);
    }
}
