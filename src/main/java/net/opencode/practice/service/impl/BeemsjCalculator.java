package net.opencode.practice.service.impl;

import lombok.extern.slf4j.Slf4j;
import net.opencode.practice.data.AbstractDto;
import net.opencode.practice.data.CalculatorType;
import net.opencode.practice.data.ResultInfo;
import net.opencode.practice.data.impl.BeemsjDto;
import net.opencode.practice.service.MedicalCalculatorService;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component
@Slf4j
public class BeemsjCalculator implements MedicalCalculatorService {

    @Override
    public ResultInfo calculate(AbstractDto dto) {
        var beemsjdto = (BeemsjDto) dto;
        BigDecimal result;
        if (beemsjdto.isSex()) {
            result = BigDecimal.valueOf(((10 * beemsjdto.getWeight()) + (6.25 * beemsjdto.getHeight()) - (5 * beemsjdto.getAge()) + 5) * beemsjdto.getK());
        } else {
            result = BigDecimal.valueOf(((10 * beemsjdto.getWeight()) + (6.25 * beemsjdto.getHeight()) - (5 * beemsjdto.getAge()) - 161) * beemsjdto.getK());
        }

        if (beemsjdto.isUnits()) {
            return new ResultInfo("%s Стресс, болезнь, травма, ожоги, онкологиче-ские заболевания увеличивают базальную потребность в энер-гии".formatted(result.setScale(0, RoundingMode.HALF_UP)));
        }
        BigDecimal result2 = result.multiply(BigDecimal.valueOf(4.184));
        return new ResultInfo("%s Стресс, болезнь, травма, ожоги, онкологические заболевания увеличивают базальную потребность в энергии".formatted(result2.setScale(0, RoundingMode.HALF_UP)));
    }

    @Override
    public CalculatorType getCalculatorType() {
        return CalculatorType.BEEMSJ;
    }

}
