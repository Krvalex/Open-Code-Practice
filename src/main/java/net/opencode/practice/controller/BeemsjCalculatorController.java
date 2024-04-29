package net.opencode.practice.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import net.opencode.practice.data.CalculatorType;
import net.opencode.practice.model.CalculatorInfo;
import net.opencode.practice.model.ResultInfo;
import net.opencode.practice.model.impl.BeemsjModel;
import net.opencode.practice.service.MedicalCalculatorService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@RequestMapping("/beemsj")
@RestController
@Validated
public class BeemsjCalculatorController {

    MedicalCalculatorService medicalCalculatorService;

    @GetMapping("info")
    public CalculatorInfo get() {
        return new CalculatorInfo("""
                Расчет суточной нормы калорий (базальной потребности в энергии)
                по формуле Миффлина-Сан Жеора (Mifflin MD, St Jeor ST, 1990).
                """);
    }

    @PostMapping("result")
    public ResultInfo result(@Validated @RequestBody BeemsjModel model) {
        return this.medicalCalculatorService.getResultFromCalculator(CalculatorType.BEEMSJ, model);
    }
}
