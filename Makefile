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
	rm -f *.class

test-create: classes Test/TestRunner.class Test/ComplexTest.class
	java -cp $(TESTCLASSPATH) TestRunner ComplexTest#testCreate

test-negate: classes Test/TestRunner.class Test/ComplexTest.class
	java -cp $(TESTCLASSPATH) TestRunner ComplexTest#testNegate

test-add: classes Test/TestRunner.class Test/ComplexTest.class
	java -cp $(TESTCLASSPATH) TestRunner ComplexTest#testAdd

test-mul: classes Test/TestRunner.class Test/ComplexTest.class
	java -cp $(TESTCLASSPATH) TestRunner ComplexTest#testMul

test-string: classes Test/TestRunner.class Test/ComplexTest.class
	java -cp $(TESTCLASSPATH) TestRunner ComplexTest#testString

test: test-create test-negate test-add test-mul test-string
