package strategy;

import model.Email;
import model.EmailSpamValidationResult;

/**
 * Created by ryadav on 2017-10-28.
 */
public interface SpamDetectionPolicy {

    EmailSpamValidationResult validate(Email email);

}
