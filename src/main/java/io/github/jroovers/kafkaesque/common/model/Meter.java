package io.github.jroovers.kafkaesque.common.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Some meter metadata
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Meter {

    @Size(max = 70)
    String identification;

    @NotNull
    MeterType meterType;

    @Min(1)
    @Max(9)
    Integer counters;

}
