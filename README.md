This is the repo for Hangman GOOS demo series.

# Installation
Please install the following tools for this project. The latest version should be fine unless specific version is listed.

* git
* jdk 1.8
* Intellij (please choose either community or ultimate edition)
    * Intellij idea community edition with the following plug-in installed
        * lombok plug-in
        * cucumber java plug-in
    * Intellij idea ultimate edition (evaluation) with the following plug-in installed
        * lombok plug-in
* Chrome and Chrome driver

# Setup Command Line Development Environment
Use git to clone this project into a folder. Then in this folder, run the command below in order.

* Start Web Application `./gradlew run` (on port 8090)
* Run All Tests `./gradlew ci` (on port 8080)
* if you want to start it on a port rather than 8090 (e.g. 8070), please do `./gradlew run -Pport=8070`

# Setup Intellij Development Environment

* Start Web Application
    * Intellij idea community edition
        * Run com.odde.bbuddy.Application as a Java application by setting environment variable "SPRING_PROFILES_ACTIVE" to "dev"
    * Intellij idea ultimate edition
        * Run com.odde.bbuddy.Application as a Spring Boot application by setting environment variable "SPRING_PROFILES_ACTIVE" to "dev"
* Run Unit Tests. Run those unit tests as normal.
* Run Acceptance Tests (cucumber). In feature file, you can select the feature or one scenario and then run it. In the configuration, you need to set environment variable "SPRING_PROFILES_ACTIVE" to "test"
* [Spring Boot Developer Tools](http://docs.spring.io/spring-boot/docs/current/reference/html/using-boot-devtools.html) is used so that you can hot load any modified code, template file and resource file without restart the application. Please follow the steps below to enable this hot load feature.
    * Enable the "build project automatically" option of compiler in Intellij
    * Start the application in Intellij as described in the first item. Don't start it with gradle in command line.
    * Edit any code or file, and make the project. Then, the change will be reloaded automatically.
    * You can install a Chrome extension called [Live Reload](https://chrome.google.com/webstore/detail/livereload/jnihajbhpnppcggbcgedagnkighmdlei?hl=en) so that the tab (in which this application is opened) will be refreshed automatically.

# Tips for Mac installation
Here are some tips for Mac installations.
* [Homebrew](http://brew.sh/) is recommended for Mac tool and app installations
    * Tools and services can be installed via, for example, `brew install git`
    * Applications can be installed via, for example, `brew cask install chrome`

# Tips for Windows installation
Here are some tips for Windows installations.
* Please consider to install [Babun](http://babun.github.io/) and then install command line tools like git and rvm in it
