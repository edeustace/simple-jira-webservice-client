package com.adobe.cqservices.commandline;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.rpc.ServiceException;

import au.com.bytecode.opencsv.CSVReader;

import com.adobe.cqservices.service.JiraService;
import com.atlassian.jira.rpc.soap.client.RemoteIssue;

public class SOAPClient {

	public static void main(String[] args) throws ServiceException,
			IOException {
		
		if( args.length != 3)
		{
			throw new RuntimeException("You must specify a username, password & file path");
		}
		
		String username = args[0];
		String password = args[1];
		String file = args[2];
		
		System.out.println("username: " + username);
		System.out.println("password: " + password);
		System.out.println("file: " + file);
	    
		CSVReader reader = new CSVReader(new FileReader(args[2]));
	    List<String[]> entries = reader.readAll();
	    
	    List<RemoteIssue> issues = new ArrayList<RemoteIssue>();
	    
	    for( String[] entry : entries)
	    {
	    	if( entry.length != 3)
	    	{
	    		continue;
	    	}
	    	
	    	RemoteIssue issue = new RemoteIssue();
	    	issue.setProject(entry[0]);
	    	issue.setSummary(entry[1]);
	    	issue.setDescription(entry[2]);
	    	issue.setType(JiraService.USER_STORY);
	    	issues.add(issue);
	    }
	    
	    JiraService impl = new JiraService();
		impl.addIssues(username, password, issues);
		System.out.println("done.");
	}
}
