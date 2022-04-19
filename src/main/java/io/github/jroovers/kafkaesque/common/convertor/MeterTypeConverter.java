package io.github.jroovers.kafkaesque.common.convertor;

import io.github.jroovers.kafkaesque.common.model.MeterType;
import org.springframework.core.convert.converter.Converter;

public class MeterTypeConverter implements Converter<MeterType, io.github.jroovers.kafkaesque.generated.model.MeterType> {

    @Override
    public io.github.jroovers.kafkaesque.generated.model.MeterType convert(MeterType source) {
        return switch (source) {
            case CVN -> io.github.jroovers.kafkaesque.generated.model.MeterType.CVN;
            case SLM -> io.github.jroovers.kafkaesque.generated.model.MeterType.SLM;
        };
    }
}
