package br.ufu.quiz.pooatividadefinalquiz.enums;

import lombok.Getter;

public enum Category {

    MATH("Matemática"),
    ENGLISH("Inglês"),
    SCIENCE("Ciências"),
    HISTORY("História"),
    GEOGRAPHY("Geografia"),
    PHYSICS("Física"),
    BIOLOGY("Biologia"),
    MISCELLANEOUS("Outros");

    @Getter
    private final String portugueseName;

    Category(String portugueseName) {
        this.portugueseName = portugueseName;
    }
}
