package detector;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Email;
import model.EmailSpamValidationResult;
import strategy.KeywordsDetectionPolicy;
import strategy.NumberOfSubdomainsPolicy;
import strategy.SpamDetectionPolicy;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ryadav
 */
public class EmailSpamDetector {

    // Not super clean
    // Not really checking for different validation in the samples
    // Only on the small data sets

    private ObjectMapper om = new ObjectMapper();

    private List<SpamDetectionPolicy> policies = Arrays.asList(
        new KeywordsDetectionPolicy(),
            new NumberOfSubdomainsPolicy()
    );

    public void run() {

        List<EmailSpamValidationResult> results = new ArrayList<>();

        try {
            Email email = om.readValue(new File("C:\\Users\\Chintan\\Desktop\\EmailSpamDetector\\src\\main\\resources\\emailSamples\\emailSample3.json"),
                                        Email.class);

            for (SpamDetectionPolicy policy: policies) {
                results.add(policy.validate(email));
            }

            for (EmailSpamValidationResult result: results) {
                if(result.isSpam()) {
                    System.out.println(result.getValidationType() + " failed. Details are as follows.");
                    System.out.println(result.getDetailedAnalysis());
                } else {
                    System.out.println(result.getValidationType() + " passed. :)");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
