package ru.intervale.app.domain;

import lombok.*;

import java.io.Serializable;

@Getter
@RequiredArgsConstructor
@ToString
public class Person implements Serializable{
    private Integer id_number;
    private Type type;
}
