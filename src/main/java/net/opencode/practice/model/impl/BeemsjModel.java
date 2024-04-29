package net.opencode.practice.model.impl;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import net.opencode.practice.model.AbstractModel;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Getter
public class BeemsjModel extends AbstractModel {

    boolean sex;
    boolean units;
    double age;
    double height;
    double weight;
    double k;

    public BeemsjModel(boolean sex, boolean units, double age, double height, double weight, double k) {
        this.sex = sex;
        this.units = units;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.k = k;
    }

}
