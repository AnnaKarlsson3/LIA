package com.example;

import edu.umd.cs.findbugs.annotations.NonNull;
import io.micronaut.context.annotation.ConfigurationProperties;

@ConfigurationProperties("application")
public class ApplicationConfigurationProperties implements ApplicationConfiguration {

    protected final Integer DEFAULT_MAX = 10;

    @NonNull
    private Integer max = DEFAULT_MAX;

    @Override
    @NonNull
    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        if(max != null) {
            this.max = max;
        }
    }
}