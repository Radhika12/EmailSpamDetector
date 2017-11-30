package antiSpoofing;

import java.util.*;

public class DNSManager {

	// Only static list for this POC
	public static Map<String, HashSet<String>> domainNameAllowedServers = new HashMap<String, HashSet<String>>();
	
	public DNSManager() {
		domainNameAllowedServers.put("shopify.com", new HashSet<String>(Arrays.asList("74.125.206.110", "74.125.206.111", "74.125.206.112")));
		domainNameAllowedServers.put("gmail.com", new HashSet<String>(Arrays.asList("74.231.206.59", "74.231.206.68")));
	}
	
	// Only return set of allowed servers instead of full SPF record for this POC
	public HashSet<String> fetchSPFTextRecord(String domainName) {
		if (domainNameAllowedServers.containsKey(domainName)) {
			return domainNameAllowedServers.get(domainName);
		}
		return new HashSet<String>();
	}
	
}
