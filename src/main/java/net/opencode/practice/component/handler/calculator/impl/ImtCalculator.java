package net.opencode.practice.component.handler.calculator.impl;

import lombok.extern.slf4j.Slf4j;
import net.opencode.practice.component.handler.calculator.MedicalCalculatorHandler;
import net.opencode.practice.data.CalculatorType;
import net.opencode.practice.model.AbstractModel;
import net.opencode.practice.model.ResultInfo;
import net.opencode.practice.model.impl.ImtModel;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class ImtCalculator implements MedicalCalculatorHandler {

    @Override
    public ResultInfo calculate(AbstractModel modelData) {
        var model = (ImtModel) modelData;
        var height = (double) model.getH() / 100;
        double result = (double) Math.round((double) model.getM() * 10 / (height * height)) / 10;
        if (result < 16) return new ResultInfo(result + " Выраженный дефицит массы тела");
        else if ((result > 16) && (result < 18.5))
            return new ResultInfo(result + " Недостаточная (дефицит) масса тела");
        else if ((result > 18.5) && (result < 25)) return new ResultInfo(result + " Норма");
        else if ((result > 25) && (result < 30))
            return new ResultInfo(result + " Избыточная масса тела (предожирение)");
        else if ((result > 30) && (result < 35)) return new ResultInfo(result + " Ожирение первой степени");
        else if ((result > 35) && (result < 40)) return new ResultInfo(result + " Ожирение второй степени");
        else return new ResultInfo(result + " Ожирение третьей степени (морбидное)");
    }

    @Override
    public CalculatorType getCalculatorType() {
        return CalculatorType.IMT;
    }
}
