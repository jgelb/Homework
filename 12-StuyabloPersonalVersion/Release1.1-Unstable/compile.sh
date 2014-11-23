echo "Running git updater..."
echo "$: git pull"
git pull
cd assets
pwd
echo "Compiling java files..."
mkdir COMPILED
cp *.java COMPILED/
cp mobs/*.java COMPILED/
cp mobs/*.txt COMPILED/
cp world/*.java COMPILED/
cp world/*.txt COMPILED/
cd COMPILED
javac *.java
rm *.java
java Exec
