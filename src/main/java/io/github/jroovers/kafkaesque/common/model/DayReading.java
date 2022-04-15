package io.github.jroovers.kafkaesque.common.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Readings for a meter on a single day
 * <p>
 * Our objective is to serialize and de-serialize the DayReading class using Apache Avro.
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DayReading {

    @NotNull
    Meter meter;

    @NotNull
    @Size(min = 93, max = 101)
    List<SnapshotReading> readings;
}
