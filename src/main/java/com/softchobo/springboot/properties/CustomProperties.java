package com.softchobo.springboot.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.boot.context.properties.bind.Name;
import org.springframework.boot.convert.DurationUnit;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

@ConfigurationProperties("iam")
public class CustomProperties {

    private final Duration duration;

    public CustomProperties(@DefaultValue("1") @DurationUnit(ChronoUnit.MILLIS) @Name("duration") Duration duration) {
        this.duration = duration;
    }

    public Duration getDuration() {
        return duration;
    }

}
