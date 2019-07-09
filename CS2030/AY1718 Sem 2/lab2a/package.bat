@ECHO OFF

:: Set this to your package name (normally cs2030/simulator)
SET mypackage=cs2030/simulator

:: Set this to the name your .jar file should be
SET jarfilename=Simulator.jar

echo Compiling...
javac %mypackage%\*.java

echo Packaging...
jar cvfm %jarfilename% manifest.txt %mypackage%\*class

echo.
echo Running...
java -cp . -jar %jarfilename%