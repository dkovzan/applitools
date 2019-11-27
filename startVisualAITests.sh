#!/bin/sh
echo "Starting Visual AI Tests Suite"
mvn clean test -Dtest=VisualAITests
echo "Tests execution is finished"
$SHELL