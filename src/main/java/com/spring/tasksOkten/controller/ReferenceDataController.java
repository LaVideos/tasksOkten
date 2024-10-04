package com.spring.tasksOkten.controller;

import com.spring.tasksOkten.properties.Fuel;
import com.spring.tasksOkten.properties.ReferenceDataProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ReferenceDataController {

    private final ReferenceDataProperties referenceDataProperties;

    @GetMapping("/engine-types")
    public ResponseEntity<List<String>> getEngineTypes() {
        return ResponseEntity.ok(referenceDataProperties.getEngineTypes());
    }

    @GetMapping("/fuel-types")
    public ResponseEntity<List<Fuel>> getFuelTypes() {
        List<Fuel> fuels = referenceDataProperties.getFuels();
        System.out.println("Fuel types: " + fuels);
        return ResponseEntity.ok(fuels);
    }

    @GetMapping("/fuel-types/{name}")
    public ResponseEntity<Fuel> getFuelType(@PathVariable String name) {
        Optional<Fuel> result = Optional
                .ofNullable(referenceDataProperties)
                .map(ReferenceDataProperties::getFuels)
                .stream()
                .flatMap(Collection::stream)
                .filter(fuel -> Objects.equals(fuel.getName(), name))
                .findFirst();

        return ResponseEntity.of(result);
    }
}
