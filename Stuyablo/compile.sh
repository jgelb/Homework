#!/bin/bash

rm -rf COMPILED
mkdir COMPILED
cp *.java COMPILED/
cp mobs/*.java COMPILED/
cp world/*.java COMPILED/
cd COMPILED
pwd
javac Exec.java
java Exec
