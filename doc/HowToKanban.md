##HOWLER Kanban
 	
 HOWLER Kanban is a simple demo system that shows how HOWLER's English to OWL translation capabilities can be used within a non ontology-literate system to add ontology capabilities such as inferencing.
 
HOWLER Kanban is composed of two components

1. A modified version of the Wekan Kanban app ((https://github.com/wekan/wekan)
 * This provides the user interface and other Kanban specific elements 
2. The HOWLER distribution 
 * The HOWLER distribution includes a simple program that communicates with the Wekan app and performs the HOWLER specific actions
	
###To install the HOWLER Kanban app

The Wekan app is built on the Meteor JavaScript framework (https://www.meteor.com/) so the Meteor runtime components are needed. Meteor apps presume an internet connection since it downloads needed packages at runtime. 
	 
1. install meteor on the system which will host the Kanban web app: (see https://www.meteor.com/install for installation details)
2. Get the Howler Kanban release at https://github.com/OpenSextant/HOWLER-Kanban/releases/latest
2. unpack HowlerKanban.zip
3. cd to the `HowlerKanban` directory
4. `meteor`

The first time this is run any needed Meteor packages will be downloaded which may take a while (10's of minutes or longer). The above steps run the Wekan app in a developer mode rather than as a deployed app. Configuring for actual deployment is beyond these notes. See the Meteor and Wekan sites for details.

### To install the HOWLER portion of HOWLER Kanban

1. unzip the HOWLER distribution. Does not have to be on the same machine as the Wekan app.
1. cd to the HOWLER-*VERSION* directory
1. edit `resources/howler.properties` to set the host if you are not on the same machine as the Wekan app
1. run kanbaner.bat/.sh

HOWLER Kanban should now be available at http://*HOST*:3000
 
###Try it out
1. Login in as `howler` with password `howler`
2. Click ` Add a new ontology `, give it a name 
3. Type in some sentences in the input field at the bottom. Try this simple paragraph:  

     `Anything that is located in something is a place.`    
`Every place that is located in an ungoverned area is dangerous. `   
`Quetta is a city that is located in Northwest Baluchistan.`    
`Northwest Baluchistan is an ungoverned area.  `

 Each concept in the sentences will be turned into a card. Each card contains all the sentences that mention that concept.
 Sentences marked with (*) have been inferred from the ontology. For instance, the "Quetta" card shows that the ontology has inferred "Quetta is a dangerous thing".
 

###Caveats
 HOWLER Kanban is not meant to be a complete app, just a demonstration of the HOWLER capabilities. It is missing many things needed in a fully useable app,
 like the ability to delete stuff, edit existing sentences, import/export, search, .... The user must login in as the same user defined in the properties file ("howler" in the default configuration)
 Some of these might be fixed/added in the future. 
 

 