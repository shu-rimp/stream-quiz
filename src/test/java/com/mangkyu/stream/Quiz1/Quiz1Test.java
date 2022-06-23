package com.mangkyu.stream.Quiz1;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Quiz1Test {

    private final Answer1 answer = new Answer1();
    private final Quiz1 quiz = new Quiz1();

    @Test
    void quiz1() throws Exception {
        assertThat(quiz.quiz1()).isEqualTo(answer.quiz1());
    }

    @Test
    void quiz2() throws Exception {
        assertThat(quiz.quiz2()).isEqualTo(answer.quiz2());
    }

    @Test
    void quiz3() throws Exception {
        assertThat(quiz.quiz3()).isEqualTo(answer.quiz3());
    }

}