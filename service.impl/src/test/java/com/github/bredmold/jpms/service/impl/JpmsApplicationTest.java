package com.github.bredmold.jpms.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class JpmsApplicationTest {
    private JpmsApplication application;

    @BeforeEach
    void setUp() {
        application = new JpmsApplication();
    }

    @Test
    void renderArgs() {
        String[] args = new String[]{"this", "is", "a", "test"};
        assertThat(application.renderArgs(args)).isEqualTo("[this, is, a, test]");
    }
}
