open module com.github.bredmold.jpms.service.impl {
    requires com.github.bredmold.jpms.service.api;

    // Jackson - required for object binding
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.datatype.jdk8;
    requires com.fasterxml.jackson.datatype.jsr310;

    // Commons Lang3, useful utilities
    requires org.apache.commons.lang3;

    // SLF4j logging framework
    requires org.slf4j;

    // Spring Boot components
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.hateoas;
    requires spring.web;
    requires spring.webmvc;

    // These components are required at link time
    requires ch.qos.logback.classic;
    requires org.apache.logging.log4j;
    requires org.apache.logging.slf4j;
    requires spring.boot.starter.logging;
}