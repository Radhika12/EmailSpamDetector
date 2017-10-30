package strategy;

import model.Email;
import model.EmailSpamValidationResult;

/**
 * Created by ryadav on 2017-10-28.
 */
public class AgeOfDomainPolicy implements SpamDetectionPolicy {

    @Override
    public EmailSpamValidationResult validate(Email email) {

        // TODO: Use Apache Commons Net to get the Whois and fetch 'Created on' from it to determine how old the domain is
        // if its too new, it could be suspicious.
        // Example https://www.mkyong.com/java/java-whois-example/

        return null;
    }
}
