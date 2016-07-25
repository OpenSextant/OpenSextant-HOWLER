@echo OFF
java.exe -Xmx1G -Dlog4j.configuration=file:./resources/log4j.properties  -classpath ./lib/* org.opensextant.howler.kanban.Kanbaner ./resources/howler.properties