package strategy;

import model.BodyPart;
import model.Email;
import model.EmailSpamValidationResult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ryadav on 2017-10-28.
 */
public class KeywordsDetectionPolicy implements SpamDetectionPolicy {

    private static final List<String> keywords = new ArrayList<>();

    public KeywordsDetectionPolicy() {
        keywords.addAll(Arrays.asList("Update", "Confirm", "User", "Customer","Client",
                                        "Suspend","Restrict", "Hold", "Verify", "Account",
                                        "Login", "Username", "Password", "SSN", "Social Security"));

    }

    @Override
    public EmailSpamValidationResult validate(Email email) {
        EmailSpamValidationResult result = new EmailSpamValidationResult();

        result.setValidationType("Keywords detection check");

        StringBuilder analysisResult = new StringBuilder();

        if(email.getBody() != null && !email.getBody().getParts().isEmpty()) {
            for (BodyPart bodyPart : email.getBody().getParts()) {
                if (bodyPart.getType().equals("text")) {
                   for(String keyword: keywords) {
                       if (bodyPart.getText().contains(keyword)) {
                           result.setSpam(true);
                           analysisResult.append("Body part contains '"+ keyword +"' keyword. \n");
                       }
                   }
                }
            }
        }

        result.setDetailedAnalysis(analysisResult.toString());
        return result;
    }
}
