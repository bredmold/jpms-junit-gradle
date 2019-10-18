# JPMS (Jigsaw), JUnit 5, Gradle, Spring Boot

This project grew out of an attempt to integrate a collection of modern technologies. When I started, I had no clue
that I would be at the bleeding edge. Java 9 is now two years old, and it was in EA versions for some time before that.

Here's what I've discovered, so far.
* Gradle, my chosen build tool, isn't really set up to deliver JPMS modules
  * There are some plugins that help
  * [Badass JLink Plugin](https://badass-jlink-plugin.beryx.org/releases/latest/) does a good job of running `jlink`
  * [gradle-modules-plugin](https://github.com/java9-modularity/gradle-modules-plugin) is good, but not quite ready for prime time
* [Project Lombok](https://projectlombok.org/) isn't quite ready to live inside a JPMS module
* [Spring Boot](https://spring.io/projects/spring-boot) is very much not ready for a JPMS world
  * [SLF4j](http://www.slf4j.org/) hasn't released a JPMS-friendly version (that will be 1.8.0)
  * [Logback](http://logback.qos.ch/) hasn't release a JPMS-friendly version
  * [Log4j 2](https://logging.apache.org/log4j/2.x/)'s SLF4j tooling won't be ready until new SLF4j releases land
* Normal Java unit testing patterns need significant engineering support to work with JPMS
  * The `gradle-modules-plugin` above is designed to do that work

I'm uploading this project for the benefit of my fellow humans, to serve as a commentary on the state of Java and JPMS
in October of 2019. Perhaps I'll revisit this project later, and see if I can bring it further along.
