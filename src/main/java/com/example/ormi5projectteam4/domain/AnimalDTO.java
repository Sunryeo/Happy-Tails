package com.example.ormi5projectteam4.domain;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AnimalDTO {
    private Integer id;
    private String name;
    private String breed;
    private Integer age;
    private Integer weight;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Gender gender;
    private NeuteringStatus neuteringStatus;
    private Species species;

    public static AnimalDTO fromAnimal(Animal animal) {
        return AnimalDTO.builder()
                .id(animal.getId())
                .name(animal.getName())
                .breed(animal.getBreed())
                .age(animal.getAge())
                .weight(animal.getWeight())
                .createdAt(animal.getCreatedAt())
                .updatedAt(animal.getUpdatedAt())
                .gender(animal.getGender())
                .neuteringStatus(animal.getNeuteringStatus())
                .species(animal.getSpecies())
                .build();
    }
}
