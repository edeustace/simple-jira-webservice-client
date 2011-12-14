## Introduction
A dead simple jira webservice client, it only does one thing - create stories from a csv file. I created it so that I didn't have to use the rather laborious web ui of Jira.
### Installation:
There are a few maven commands that you need to run to init your project. They basically download the wsdl for your jira service, then generate java classes from it.
The you run the Assembler that creates an executable jar with all the libs you need built in.

    cd ${path_to_repo}
    mvn -Pfetch-wsdl -Djira.soapclient.jiraurl=${your_jira_url} -Djira.version=${jira_version}
    mvn axistools:wsdl2java
    mvn assembly:assembly

### Running:
There is only one function available - create issues from a csv file.
The command to run is: 

    java -jar target/simple-jira-webservice-client-0.1-jar-with-dependencies.jar ${username} ${password} ${path_to_csv_file}

The csv file should have the format: 

    ${project_key},${summary},${description}
    