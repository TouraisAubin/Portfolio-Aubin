CO = -g
JAVAC = javac
JCFLAG = -encoding UTF-8 -implicit:none
RM = rm
JVM= java
JVMFLAG=
FILE=
.SUFFIXES: .java .class
.java.class: 
	$(JAVAC) $(CO) $*.java

CLASSES = \
		Grid.java\
		GraphicGameGrid.java\
		DemineurToolBox.java\
		GridSizeAsk.java\
		GUI.java\
		MainMenu.java\
		MouseInterface.java\
		MenuSuperclass.java\
		MyJButton.java\
		MyJPanel.java\
		Demineur.java\
		ContinueMenu.java\
		SaveManager.java\
		ContinueMenuMouseListener.java\
		SavableGrid.java\
        
DEMINEUR = Main

classes: $(CLASSES:.java=.class)

default: classes

clean: $(RM) *.class

test: classes
	$(JVM) $(DEMINEUR)

classes: $(CLASSES:.java=.class)

run: Demineur.class
	$(JVM) $(JVMFLAG) Demineur

clean :
	-rm -f *.class

mrproper : clean Demineur.class

.class : run clean mrproper