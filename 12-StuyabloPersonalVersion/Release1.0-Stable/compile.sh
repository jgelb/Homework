#!/bin/bash

echo "Running updater from git..."
git pull
echo "Update complete."
echo "Loading code..."
mkdir assets/COMPILED
rm -rf assets/COMPILED/*.java
rm -rf assets/COMPILED/*.class
cp assets/*.java assets/COMPILED/
cp assets/mobs/*.java assets/COMPILED/
cp assets/world/*.java assets/COMPILED/
cd assets/COMPILED
pwd
echo "Compiling source..."
javac *.java
clear
java Exec
