package strategy;

import model.BodyPart;
import model.Email;
import model.EmailSpamValidationResult;

/**
 * Created by ryadav on 2017-10-28.
 */
public class PresenceOfJavascriptPolicy implements SpamDetectionPolicy {

	@Override
    public EmailSpamValidationResult validate(Email email) {
    	 return null;
        //TODO: Check for presence of any <script> tag.
    }
}
