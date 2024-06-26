package net.opencode.practice.data.impl;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;
import net.opencode.practice.data.AbstractDto;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@EqualsAndHashCode(callSuper = true)
@Data
public class BeemsjDto extends AbstractDto {

    boolean sex;
    boolean units;

    @Min(0)
    @Max(200)
    @Schema(example = "52", description = "Возраст")
    int age;

    @Min(0)
    @Max(500)
    @Schema(example = "180", description = "Рост")
    int height;

    @Min(0)
    @Max(1000)
    @Schema(example = "70", description = "Вес")
    int weight;

    @Min(1)
    @Max(5)
    @Schema(example = "1", description = "Физическая активность")
    int k;


}
