package com.spring.tasksOkten.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
@ConfigurationProperties(prefix = "reference-data")
public class ReferenceDataProperties {
    private List<String> engineTypes;
    private List<Fuel> fuels;
}
