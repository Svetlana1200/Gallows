package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataTest {
    @Test
    void first_word() {
        Data data = new Data();
        data.parse_data(1);
        assertEquals(new String(data.right_word), "бит");
        assertEquals(new String(data.user_word), "***");
        assertEquals(data.definition, "Наименьшая единица информации в цифровом компьютере, принимающая значения '0' или '1'.");
    }

    @Test
    void double_word() {
        Data data = new Data();
        data.parse_data(2);
        assertEquals(new String(data.right_word), "база данных");
        assertEquals(new String(data.user_word), "**** ******");
        assertEquals(data.definition, "Один или несколько файлов данных, предназначенных для хранения, изменения и обработки больших объемов взаимосвязанной информации.");
    }

    @Test
    void get_hint() {
        Data data = new Data();
        data.parse_data(3);
        assertEquals(new String(data.right_word), "адаптер");
        assertEquals(new String(data.user_word), "*******");
        assertEquals(data.definition, "Устройство связи компьютера с периферийными устройствами.");
        data.get_hint();
        assertEquals(new String(data.user_word), "а******");
    }

    @Test
    void get_hint_double_word() {
        Data data = new Data();
        data.parse_data(20);
        assertEquals(new String(data.right_word), "интегральная схема");
        assertEquals(new String(data.user_word), "************ *****");
        assertEquals(data.definition, "Реализация электронной схемы, выполняющей некоторую функцию, в виде единого полупроводникового кристалла, в котором изготовлены все компоненты, необходимые для осуществления этой функции.");
        data.get_hint();
        assertEquals(new String(data.user_word), "и*********** *****");
    }

    @Test
    void get_hint_twice() {
        Data data = new Data();
        data.parse_data(4);
        assertEquals(new String(data.right_word), "алгоритм");
        assertEquals(new String(data.user_word), "********");
        assertEquals(data.definition, "Заранее заданное понятное и точное предписание возможному исполнителю совершить определенную последовательность действий для получения решения задачи за конечное число шагов.");
        data.get_hint();
        assertEquals(new String(data.user_word), "а*******");
        data.get_hint();
        assertEquals(new String(data.user_word), "а*******");
    }
}
