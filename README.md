

### Installation:

* mvn -Pfetch-wsdl -Djira.soapclient.jiraurl=${your_jira_url} -Djira.version=${jira_version}
* mvn axistools:wsdl2java
* mvn assembly:assembly

### Running:
There is only one function available - create issues from a csv file.
The command to run is: 
* java -jar target/bumbleebee-jira-ws-client-0.1-SNAPSHOT-jar-with-dependencies.jar ${name} ${password} ${path_to_csv_file}

The file should have the format: 
project_key,summary,description