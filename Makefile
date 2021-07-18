CLASSPATH = .:Lib/:Lib/jsoup-1.13.1.jar
TESTCLASSPATH = $(CLASSPATH):Test/:Test/junit4.jar
JFLAGS = -g -cp $(TESTCLASSPATH)
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	Complex.java


default: classes

classes: $(CLASSES:.java=.class)

run: classes
	java -cp $(CLASSPATH) Complex

clean:
	rm -f *.class Test/*.class

test-build: classes Test/TestRunner.class Test/ComplexTest.class

test-create: test-build
	java -cp $(TESTCLASSPATH) TestRunner ComplexTest#testCreate

test-negate: test-build
	java -cp $(TESTCLASSPATH) TestRunner ComplexTest#testNegate

test-add: test-build
	java -cp $(TESTCLASSPATH) TestRunner ComplexTest#testAdd

test-mul: test-build
	java -cp $(TESTCLASSPATH) TestRunner ComplexTest#testMul

test-string: test-build
	java -cp $(TESTCLASSPATH) TestRunner ComplexTest#testString

test-z-sequence: test-build
	java -cp $(TESTCLASSPATH) TestRunner ComplexTest#testZSequence

test: test-build
	java -cp $(TESTCLASSPATH) TestRunner ComplexTest
