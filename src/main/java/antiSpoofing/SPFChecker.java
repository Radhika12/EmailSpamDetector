package antiSpoofing;

import java.util.HashSet;
import java.util.List;

import model.Email;
import model.Header;

public class SPFChecker {

	private DNSManager dnsManager = new DNSManager();

	public boolean spfCheck(Email email) {
		
		if (email != null && email.getHeaders() != null && email.getHeaders().size() != 0) {
			
			String returnPath = getReturnPath(email.getHeaders());
			String sendingServer = getSendingServer(email.getHeaders());
			
			if ( returnPath != null &&  sendingServer != null) {
				String domainName = returnPath.substring(returnPath.indexOf("@") + 1);
				HashSet<String> allowedServers = dnsManager.fetchSPFTextRecord(domainName);
				
				if (allowedServers.contains(sendingServer)) {
					return true;
				} else {
					return false;
				}

			} else {
				return true; // if SPF specific headers are not provided in the email, return true.
			}
		}
		
		return false; // If email or its headers are null, spf check fails. 
	}

	private String getReturnPath(List<Header> headers) {
	
		for (int i = 0; i < headers.size() ; i ++) {
			if (headers.get(i).getName().equals("Return-Path")) {
				return headers.get(i).getValue();
			}
		}
		
		return "";
	}

	private String getSendingServer(List<Header> headers) {
	
		for (int i = 0; i < headers.size() ; i ++) {
			if (headers.get(i).getName().equals("Sending Server")) {
				return headers.get(i).getValue();
			}
		}
		
		return "";
	}
	
}
