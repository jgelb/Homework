#!/bin/bash

echo "Loading code..."
rm -rf COMPILED
mkdir COMPILED
cp *.java COMPILED/
cp mobs/*.java COMPILED/
cp world/*.java COMPILED/
cd COMPILED
pwd
echo "Compiling source..."
javac *.java
clear
java Exec
