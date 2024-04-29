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

        if (0.333 * sad + 0.666 * dad > 110) {
            return new ResultInfo("Гипертензия");
        } else if (0.333 * sad + 0.666 * dad < 70) {
            return new ResultInfo("Гипотензия. Возможна гипоксия и ишемия тканей");
        } else {
            return new ResultInfo("Норма");
        }
    }

    @Override
    public CalculatorType getCalculatorType() {
        return CalculatorType.MAP;
    }

}
