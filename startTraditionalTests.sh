#!/bin/sh
echo "Starting Traditional Tests Suite"
mvn clean test -Dtest=TraditionalTests
echo "Tests execution is finished"

echo "Generating surefire report"
mvn surefire-report:report-only
mvn site -DgenerateReports=false

echo "Opening report in standart browser"
start ./target/site/surefire-report.html

$SHELL