package net.opencode.practice.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import net.opencode.practice.data.CalculatorType;


@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Getter
public class ImtModel extends AbstractModel<CalculatorType> {

    int weight;
    int height;

    public ImtModel(int weight, int height) {
        super(CalculatorType.IMT);
        this.weight = weight;
        this.height = height;
    }
}