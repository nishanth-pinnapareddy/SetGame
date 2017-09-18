#!/bin/bash

# class file dir
mkdir -p build

# compile
javac -d build -cp . src/*.java

# run
java -cp .:build GameRunner