package com.adobe.cqservices.service;

import java.util.List;

import javax.xml.rpc.ServiceException;

import com.atlassian.jira.rpc.soap.client.JiraSoapService;
import com.atlassian.jira.rpc.soap.client.JiraSoapServiceServiceLocator;
import com.atlassian.jira.rpc.soap.client.RemoteAuthenticationException;
import com.atlassian.jira.rpc.soap.client.RemoteException;
import com.atlassian.jira.rpc.soap.client.RemoteIssue;
import com.atlassian.jira.rpc.soap.client.RemotePermissionException;
import com.atlassian.jira.rpc.soap.client.RemoteValidationException;

public class JiraService {

	public static final String USER_STORY = "6";


	public void addIssues(String username, String password, List<RemoteIssue> issues) {
		JiraSoapServiceServiceLocator locator = new JiraSoapServiceServiceLocator();
		JiraSoapService service;
		
			try {
				service = locator.getJirasoapserviceV2();
				String token = service.login(username, password);
				
				for( RemoteIssue i : issues)
				{
					service.createIssue(token, i);
				}
			} catch (ServiceException e) {
				e.printStackTrace();
			} catch (RemotePermissionException e) {
				e.printStackTrace();
			} catch (RemoteValidationException e) {
				e.printStackTrace();
			} catch (RemoteAuthenticationException e) {
				e.printStackTrace();
			} catch (RemoteException e) {
				e.printStackTrace();
			} catch (java.rmi.RemoteException e) {
				e.printStackTrace();
			}
	}

}
