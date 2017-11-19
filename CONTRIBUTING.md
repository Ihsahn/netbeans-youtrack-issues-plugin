# netbeans-youtrack-issues-plugin

## Guidelines for contributing to the project

### Feedback
Please direct any questions, feature requests or bugs to the 
[issue tracker](https://github.com/llorllale/netbeans-youtrack-issues-plugin/issues/).

### Requirements
To develop and run unit tests you'll need:

* Apache Maven 3+
* JDK 1.8+

#### Run the tests
Just run `mvn test`.

### How to contribute?
Fork the repository, code your changes, then submit a pull request. We ask 
several things:

* If your PR solves an issue, the first line on your commit message should be
a reference to the issue surrounded by parenthesis, followed by a space, 
followed by the issue's title. Example: `(#32) Fixing some bug`
* The rest of your commit message should clearly state what is new (NEW), 
what has merely changed (REF), what has been fixed (FIX), etc.
* First ensure your contribution meets the project's styleguides by running 
the following and making sure there are no errors: 
`mvn -P analyze clean install -DskipTests`
* Your code contribution must include tests if applicable.

### Code Coverage
Coverage is reported via [CodeCov.io](https://codecov.io/gh/llorllale/netbeans-youtrack-issues-plugin)
and also the [project's site](https://llorllale.github.io/netbeans-youtrack-issues-plugin/cobertura/).

**The current minimum target coverage is 80%.**

