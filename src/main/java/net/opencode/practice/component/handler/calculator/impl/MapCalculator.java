package net.opencode.practice.component.handler.calculator.impl;

import lombok.extern.slf4j.Slf4j;
import net.opencode.practice.component.handler.calculator.MedicalCalculatorHandler;
import net.opencode.practice.data.CalculatorType;
import net.opencode.practice.model.AbstractModel;
import net.opencode.practice.model.ResultInfo;
import net.opencode.practice.model.impl.MapModel;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MapCalculator implements MedicalCalculatorHandler {

    @Override
    public ResultInfo calculate(AbstractModel modelData) {
        var model = (MapModel) modelData;
        var dad = (double) model.getDad();
        var sad = (double) model.getSad();
        double result = 0.333 * sad + 0.666 * dad;
        if (result > 110) {
            return new ResultInfo(Math.round(result) + " Гипертензия");
        } else if (result < 70) {
            return new ResultInfo(Math.round(result) + " Гипотензия. Возможна гипоксия и ишемия тканей");
        } else {
            return new ResultInfo(Math.round(result) + " Норма");
        }
    }

    @Override
    public CalculatorType getCalculatorType() {
        return CalculatorType.MAP;
    }

}
