package strategy;

import model.BodyPart;
import model.Email;
import model.EmailSpamValidationResult;

/**
 * Created by ryadav on 2017-10-28.
 */
public class NumberOfSubdomainsPolicy implements SpamDetectionPolicy {

    private String regex = "^(http[s]?://www\\.|http[s]?://|www\\.)";

    @Override
    public EmailSpamValidationResult validate(Email email) {

        EmailSpamValidationResult result = new EmailSpamValidationResult();

        result.setValidationType("Number of sub domains check");

        StringBuilder analysisResult = new StringBuilder();

        if(email.getBody() != null && !email.getBody().getParts().isEmpty()) {
            for (BodyPart bodyPart : email.getBody().getParts()) {
                if (bodyPart.getType().equals("url") && bodyPart.getHref() != null) {
                    String domain = bodyPart.getHref().replaceAll(regex, "");
                    if(domain.split("\\.").length >= 5) {
                    	result.setSpam(true);
                        analysisResult.append("Body part contains a url '"+bodyPart.getHref()+"' with 5 or more subdomains. \n");
                    }
                }
            }
        }

        result.setDetailedAnalysis(analysisResult.toString());
        return result;
    }
}
