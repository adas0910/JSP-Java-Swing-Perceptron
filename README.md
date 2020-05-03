# JSP-Java-Swing-Perceptron
[![MIT License](https://img.shields.io/badge/license-MIT-blue.svg?style=flat)](http://choosealicense.com/licenses/mit/)

An implementation of logic gates with single layered perceptron in Java while implementing event handling as per project requirements. See [Note](#Note) below for further information.

## Installation

### Requirements:
* java 12.0.1 or higher
* Java(TM) SE Runtime Environment (build 12.0.1+12) or higher
* Java HotSpot(TM) 64-Bit Server VM (build 12.0.1+12, mixed mode, sharing) or higher

### Cloning:
```sh
git clone https://github.com/adas0910/JSP-Java-Swing-Perceptron.git
```

## Using JSP

1. Clone JSP to a local directory.

2. Compile the contents of src/main 
```sh
cd dir/JSP-Java-Swing-Program/src/main
dir/JSP-Java-Swing-Program/src/main>javac Driver.java Perceptron.java Truthtable.java
```

3. Provide the path for src/main to include the class files and compile the contents of src/gui 
```sh
cd dir/JSP-Java-Swing-Program/src/gui
dir/src/gui>javac -cp dir/JSP-Java-Swing-Program/src/main/ ConsoleOutput.java Mainform.java
```

4. Run Mainform to start the application
```sh
dir/JSP-Java-Swing-Program/src/gui>java -cp dir/JSP-Java-Swing-Program/src/main/; Mainform
```


### Note
This project is a part of ICS-121, Java Programming, coursework's semester project at International Center for Applied Sciences(ICAS), Manipal Academy of Higher Education. As per the project requirements we were mainly tasked with implementing event handling and other various concepts and building an application. 

### License
Everything is under the MIT License.

