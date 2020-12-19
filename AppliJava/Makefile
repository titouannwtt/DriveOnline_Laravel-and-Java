SRC_DIR := src/
BIN_DIR := bin/

#packages
VIEWS_DIR := $(SRC_DIR)views/
HELPERS_DIR := $(SRC_DIR)helpers/
WEB_DIR := $(SRC_DIR)web/


FLAGS := -d $(BIN_DIR) -sourcepath $(SRC_DIR) -classpath $(BIN_DIR)
JC := javac
JEXE := java -classpath "$(BIN_DIR)"
JDOC := javadoc
RM := rm -rf 
MKDIR := mkdir

$(BIN_DIR):
	$(MKDIR) $(BIN_DIR)

all: $(BIN_DIR) $(BIN_DIR)Connexion.class $(BIN_DIR)Gestionnaire.class


#Main

$(BIN_DIR)Connexion.class: $(SRC_DIR)Connexion.java
	$(JC) $(FLAGS) $(SRC_DIR)Connexion.java

$(BIN_DIR)Gestionnaire.class: $(SRC_DIR)Gestionnaire.java
	$(JC) $(FLAGS) $(SRC_DIR)Gestionnaire.java


#Helpers

$(BIN_DIR)Polices.class: $(HELPERS_DIR)Polices.java
	$(JC) $(FLAGS) $(HELPERS_DIR)Polices.java

$(BIN_DIR)Palette.class: $(HELPERS_DIR)Palette.java 
	$(JC) $(FLAGS) $(HELPERS_DIR)Palette.java

$(BIN_DIR)Avatar.class: $(HELPERS_DIR)Avatar.java 
	$(JC) $(FLAGS) $(HELPERS_DIR)Avatar.java


#Web

$(BIN_DIR)PostRequest.class: $(WEB_DIR)PostRequest.java 
	$(JC) $(FLAGS) $(WEB_DIR)PostRequest.java



#Views

$(BIN_DIR)ContPanel.class: $(VIEWS_DIR)ContPanel.java $(HELPERS_DIR)Palette.class $(HELPERS_DIR)Polices.class
	$(JC) $(FLAGS) $(VIEWS_DIR)ContPanel.java

$(BIN_DIR)FenetreConnexion.class: $(VIEWS_DIR)FenetreConnexion.java
	$(JC) $(FLAGS) $(VIEWS_DIR)FenetreConnexion.java
	
$(BIN_DIR)IDPanel.class: $(VIEWS_DIR)IDPanel.java $(HELPERS_DIR)Palette.class $(HELPERS_DIR)Polices.class
	$(JC) $(FLAGS) $(VIEWS_DIR)IDPanel.java

$(BIN_DIR)ListeFontes.class: $(VIEWS_DIR)ListeFontes.java
	$(JC) $(FLAGS) $(VIEWS_DIR)ListeFontes.java

$(BIN_DIR)ContPanelG.class: $(VIEWS_DIR)ContPanelG.java $(HELPERS_DIR)Palette.class $(HELPERS_DIR)Polices.class
	$(JC) $(FLAGS) $(VIEWS_DIR)ContPanelG.java

$(BIN_DIR)FenetreGestionnaire.class: $(VIEWS_DIR)FenetreGestionnaire.java
	$(JC) $(FLAGS) $(VIEWS_DIR)FenetreGestionnaire.java


#Clean bin dir
clean:
	$(RM) $(BIN_DIR)*

#utilities for development
dev1: clean $(BIN_DIR)Connexion.class
dev2: clean $(BIN_DIR)Gestionnaire.class

#launch program
run1: 
	$(JEXE) Connexion

run2:
	$(JEXE) Gestionnaire


.PHONY: clean
