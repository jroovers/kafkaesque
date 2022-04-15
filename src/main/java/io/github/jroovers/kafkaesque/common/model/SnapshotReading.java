package io.github.jroovers.kafkaesque.common.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

/**
 * An arbitrary reading at a point in time. Contains supplied and consumed values.
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SnapshotReading {
    Instant time;
    Long consumed;
    Long produced;

    public Long getTime() {
        return time.getEpochSecond();
    }

    public void setTime(Long epochSeconds) {
        this.time = Instant.ofEpochSecond(epochSeconds);
    }
}
