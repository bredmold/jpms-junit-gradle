package com.github.bredmold.jpms.service.impl;

import java.util.Arrays;

/**
 * Main application class
 */
public class JpmsApplication {
    public static void main(String[] args) {
        var application = new JpmsApplication();
        System.out.println(application.renderArgs(args));
    }

    String renderArgs(String[] args) {
        return Arrays.toString(args);
    }
}
