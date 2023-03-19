# java-multi-modules

Playground project to integrate maven and java modules with clean architecture
in mind.

## Setup

Instructions for developers to adjust their environment to develop on the project.

### Intellij Formatter

Maven automatically performs code style checks with [spotless](https://github.com/diffplug/spotless) and the java-google-style.
To adjust the intellij code style to the ones used by the automatic formatter make these changes:

1. install the intellij plugin [https://plugins.jetbrains.com/plugin/8527-google-java-format](https://plugins.jetbrains.com/plugin/8527-google-java-format)
2. Import [intellij-java-google-style.xml](config/intellij-java-google-style.xml): **Settings > Editor > Code Style** and either click on the gear and select **Import** or change the already installed format in the drop-down.