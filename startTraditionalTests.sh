#!/bin/sh
mvn clean test -Dtest=TraditionalTests
mvn surefire-report:report-only
mvn site -DgenerateReports=false
start ./target/site/surefire-report.html