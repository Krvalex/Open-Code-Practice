package net.opencode.practice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import net.opencode.practice.data.AbstractDto;
import net.opencode.practice.data.CalculatorInfo;
import net.opencode.practice.data.CalculatorType;
import net.opencode.practice.data.ResultInfo;
import net.opencode.practice.data.exception.ErrorMessage;
import net.opencode.practice.data.impl.BeemsjDto;
import net.opencode.practice.service.MedicalCalculatorService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@RequestMapping("/beemsj")
@RestController
public class BeemsjCalculatorController {

    Map<CalculatorType, MedicalCalculatorService<?>> medicalCalculatorServices;

    @Operation(summary = "Gets calculator information", description = "Returns Beesmj calculator information", tags = "info")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Successful operation",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = CalculatorInfo.class)))
    })

    @GetMapping("info")
    public CalculatorInfo get() {
        return new CalculatorInfo("""
                Расчет суточной нормы калорий (базальной потребности в энергии)
                по формуле Миффлина-Сан Жеора (Mifflin MD, St Jeor ST, 1990).
                """);
    }

    @Operation(summary = "Calculate result from your data",
            description = "Calculate Beemsj result from your data",
            tags = "calculate")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Successful operation",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResultInfo.class))),
            @ApiResponse(responseCode = "422",
                    description = "Validation exception",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class)))}
    )

    @SuppressWarnings("unchecked")
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("result")
    public ResultInfo result(@Valid @RequestBody BeemsjDto dto) {
        var service = (MedicalCalculatorService<AbstractDto>) this.medicalCalculatorServices.get(CalculatorType.BEEMSJ);
        return service.calculate(dto);
    }
}
