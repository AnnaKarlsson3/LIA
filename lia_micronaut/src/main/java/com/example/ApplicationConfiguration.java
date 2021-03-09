package com.example;

import javax.validation.constraints.NotNull;

public interface ApplicationConfiguration {
    @NotNull Integer getMax();
}
