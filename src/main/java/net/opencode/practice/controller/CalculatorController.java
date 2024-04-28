package net.opencode.practice.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import net.opencode.practice.data.CalculatorType;
import net.opencode.practice.service.MedicalCalculatorService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@RestController
@RequestMapping("/calculator")
@Validated
public class CalculatorController {

    MedicalCalculatorService medicalCalculatorService;

    @GetMapping("imt/info")
    public HttpStatus get() {
        this.medicalCalculatorService.getModelFromDataObject(CalculatorType.IMT);
        return HttpStatus.ACCEPTED;
    }
}
