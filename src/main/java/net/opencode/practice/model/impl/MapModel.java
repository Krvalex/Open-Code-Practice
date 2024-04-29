package net.opencode.practice.model.impl;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import net.opencode.practice.model.AbstractModel;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Getter
public class MapModel extends AbstractModel {

    int sad;
    int dad;

    public MapModel(int sad, int dad) {
        super();

        this.sad = sad;
        this.dad = dad;
    }


}
