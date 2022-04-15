package io.github.jroovers.kafkaesque.common;

import org.apache.avro.Schema;
import org.apache.avro.SchemaBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
class SchemaGeneratorTest {

    @Test
    void generateSchema() {
        Schema meterType = SchemaBuilder.enumeration("MeterType")
                .namespace("io.github.jroovers.kafkaesque.generated.model")
                .symbols("CVN", "SLM");
        Schema meter = SchemaBuilder.record("Meter")
                .namespace("io.github.jroovers.kafkaesque.generated.model")
                .fields()
                .requiredString("identification")
                .name("meterType")
                .type(meterType)
                .withDefault("SLM")
                .requiredInt("counters")
                .endRecord();
        Schema snapshotReading = SchemaBuilder.record("SnapshotReading")
                .namespace("io.github.jroovers.kafkaesque.generated.model")
                .fields()
                .requiredLong("time")
                .requiredLong("consumed")
                .requiredLong("produced")
                .endRecord();
        Schema dayReading = SchemaBuilder.record("DayReading")
                .namespace("io.github.jroovers.kafkaesque.generated.model")
                .fields()
                .name("meter")
                .type(meter)
                .noDefault()
                .name("readings")
                .type()
                .array()
                .items()
                .type(snapshotReading)
                .noDefault()
                .endRecord();
        String json = dayReading.toString();
        System.out.println(json);
        Assertions.assertNotNull(json);
    }
}
