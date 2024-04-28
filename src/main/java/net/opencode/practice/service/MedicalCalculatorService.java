package net.opencode.practice.service;

import net.opencode.practice.data.CalculatorType;
import net.opencode.practice.model.AbstractModel;
import net.opencode.practice.model.ResultInfo;

public interface MedicalCalculatorService {

    ResultInfo getResultFromCalculator(CalculatorType calculatorType, AbstractModel model);
}
