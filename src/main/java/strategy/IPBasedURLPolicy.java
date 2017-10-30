package strategy;

import model.Email;
import model.EmailSpamValidationResult;

/**
 * Created by ryadav on 2017-10-28.
 */
public class IPBasedURLPolicy implements SpamDetectionPolicy {

    @Override
    public EmailSpamValidationResult validate(Email email) {

        //TODO: Check if any url body part contains an href with IP address in it and if is, the mail can be suspicious.

        return null;
    }
}
