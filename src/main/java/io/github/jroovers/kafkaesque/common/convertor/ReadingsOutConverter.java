package io.github.jroovers.kafkaesque.common.convertor;

import io.github.jroovers.kafkaesque.common.model.DayReading;
import org.springframework.core.convert.converter.Converter;

public class ReadingsOutConverter implements Converter<DayReading, io.github.jroovers.kafkaesque.generated.model.DayReading> {
    @Override
    public io.github.jroovers.kafkaesque.generated.model.DayReading convert(DayReading source) {
        return null;
    }
}
