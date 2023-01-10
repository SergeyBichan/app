package ru.intervale.app.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class Person {
    private Integer id_number;
    private Type type;

}
