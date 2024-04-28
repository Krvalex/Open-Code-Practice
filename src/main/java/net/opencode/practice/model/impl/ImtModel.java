package net.opencode.practice.model.impl;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import net.opencode.practice.model.AbstractModel;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Getter
public class ImtModel extends AbstractModel {

    int m;
    int h;

    public ImtModel(int weight, int height) {
        super();

        this.m = weight;
        this.h = height;
    }
}