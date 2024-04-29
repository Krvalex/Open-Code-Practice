package net.opencode.practice.component.handler.calculator.impl;

import lombok.extern.slf4j.Slf4j;
import net.opencode.practice.component.handler.calculator.MedicalCalculatorHandler;
import net.opencode.practice.data.CalculatorType;
import net.opencode.practice.model.AbstractModel;
import net.opencode.practice.model.ResultInfo;
import net.opencode.practice.model.impl.BeemsjModel;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class BeemsjCalculator implements MedicalCalculatorHandler {

    @Override
    public ResultInfo calculate(AbstractModel modelData) {
        var model = (BeemsjModel) modelData;
        double result;
        if (model.isSex()) {
            result = ((10 * model.getWeight()) + (6.25 * model.getHeight()) - (5 * model.getAge()) + 5) * model.getK();
        } else {
            result = ((10 * model.getWeight()) + (6.25 * model.getHeight()) - (5 * model.getAge()) - 161) * model.getK();
        }

        if (model.isUnits()) {
            return new ResultInfo(Math.round(result) + " Стресс, болезнь, " +
                    "травма, ожоги, онкологические заболевания увеличивают базальную потребность в энергии");
        } else {
            return new ResultInfo(Math.round(result * 4.184) + " Стресс, болезнь, " +
                    "травма, ожоги, онкологические заболевания увеличивают базальную потребность в энергии");
        }

    }

    @Override
    public CalculatorType getCalculatorType() {
        return CalculatorType.BEEMSJ;
    }

}
