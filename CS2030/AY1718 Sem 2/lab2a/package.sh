#!/bin/bash

# Set this to your package name (normally cs2030/simulator)
MYPACKAGE=cs2030/simulator

# Set this to the name your .jar file should be
JARFILENAME=Simulator.jar

printf "Compiling...\r\n"
javac $MYPACKAGE/*.java

printf "Packaging...\r\n"
jar cvfm $JARFILENAME manifest.txt $MYPACKAGE/*class

printf "\r\nRunning...\r\n"
java -cp . -jar $JARFILENAME