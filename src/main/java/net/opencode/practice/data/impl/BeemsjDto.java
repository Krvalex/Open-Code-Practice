package net.opencode.practice.data.impl;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import net.opencode.practice.data.AbstractDto;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Getter
public class BeemsjDto extends AbstractDto {

    boolean sex;
    boolean units;
    double age;
    double height;
    double weight;
    double k;

    public BeemsjDto(boolean sex, boolean units, double age, double height, double weight, double k) {
        this.sex = sex;
        this.units = units;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.k = k;
    }

}
