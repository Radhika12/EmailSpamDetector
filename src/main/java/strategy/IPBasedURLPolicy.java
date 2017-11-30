package strategy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.BodyPart;
import model.Email;
import model.EmailSpamValidationResult;

/**
 * Created by ryadav on 2017-10-28.
 * 
 * IP-based URL: One way to obscure a server’s identity is achieved through the
use of an IP address. Use of an IP address makes it difficult for users to know
exactly where they are being directed to when they click the link. A legitimate
website usually has a domain name for its identification. Phishers usually use
some zombie systems to host phishing sites. When a link in an email contains a
link whose host is an IP address (for example, http://81.215.214.238/pp/) we flag
the email. 
 */
public class IPBasedURLPolicy implements SpamDetectionPolicy {
	

	private String regex = "^(http[s]?://www\\.|http[s]?://|www\\.)";

    @Override
    public EmailSpamValidationResult validate(Email email) {
        return null;
    }
}
