#!/bin/bash

echo "Loading code..."

mkdir COMPILED
rm -rf COMPILED/*.java
rm -rf COMPILED/*.class
cp *.java COMPILED/
cp mobs/*.java COMPILED/
cp world/*.java COMPILED/
cd COMPILED
pwd
echo "Compiling source..."
javac *.java
clear
java Exec
