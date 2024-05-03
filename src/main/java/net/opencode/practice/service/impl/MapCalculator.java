package net.opencode.practice.service.impl;

import net.opencode.practice.data.AbstractDto;
import net.opencode.practice.data.CalculatorType;
import net.opencode.practice.data.ResultInfo;
import net.opencode.practice.data.impl.MapDto;
import net.opencode.practice.service.MedicalCalculatorService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service("mapCalculator")
public class MapCalculator implements MedicalCalculatorService {

    @Override
    public ResultInfo calculate(AbstractDto dto) {
        var mapDto = (MapDto) dto;
        var dad = (double) mapDto.getDad();
        var sad = (double) mapDto.getSad();

        var result = BigDecimal.valueOf(0.333 * sad + 0.666 * dad);
        if (result.compareTo(BigDecimal.valueOf(110)) > 0) {
            return new ResultInfo("%s Гипертензия".formatted(result.setScale(0, RoundingMode.HALF_UP)));
        }
        if (result.compareTo(BigDecimal.valueOf(70)) < 0) {
            return new ResultInfo("%s Гипотензия. Возможна гипоксия и ишемия тканей".formatted(result.setScale(0, RoundingMode.HALF_UP)));
        }

        return new ResultInfo("%s Норма".formatted(result.setScale(0, RoundingMode.HALF_UP)));

    }

    @Override
    public CalculatorType getCalculatorType() {
        return CalculatorType.MAP;
    }
}
