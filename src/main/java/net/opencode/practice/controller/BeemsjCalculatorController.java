package net.opencode.practice.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import net.opencode.practice.data.CalculatorInfo;
import net.opencode.practice.data.CalculatorType;
import net.opencode.practice.data.ResultInfo;
import net.opencode.practice.data.impl.BeemsjDto;
import net.opencode.practice.service.MedicalCalculatorService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@RequestMapping("/beemsj")
@RestController
@Validated
public class BeemsjCalculatorController {

    Map<CalculatorType, MedicalCalculatorService> medicalCalculatorServices;

    @GetMapping("info")
    public CalculatorInfo get() {
        return new CalculatorInfo("""
                Расчет суточной нормы калорий (базальной потребности в энергии)
                по формуле Миффлина-Сан Жеора (Mifflin MD, St Jeor ST, 1990).
                """);
    }

    @PostMapping("result")
    public ResultInfo result(@Validated @RequestBody BeemsjDto dto) {
        var service = this.medicalCalculatorServices.get(CalculatorType.BEEMSJ);
        return service.calculate(dto);
    }
}
