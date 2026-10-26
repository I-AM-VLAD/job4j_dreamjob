package ru.job4j.dreamjob.controller;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class IndexControllerTest {
    @Test
    public void whenTestGetIndex() {
        var indexController = new IndexController();
        assertThat(indexController.getIndex()).isEqualTo("index");
    }
}