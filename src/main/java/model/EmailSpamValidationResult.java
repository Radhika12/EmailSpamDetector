package model;

/**
 * Created by ryadav on 2017-10-28.
 */
public class EmailSpamValidationResult {

	private boolean isSpam = false;
    private String detailedAnalysis;

    private String validationType;

    public boolean isSpam() {
		return isSpam;
    }

    public void setSpam(boolean spam) {
    	this.isSpam = spam;
    }

    public String getDetailedAnalysis() {
        return detailedAnalysis;
    }

    public void setDetailedAnalysis(String detailedAnalysis) {
        this.detailedAnalysis = detailedAnalysis;
    }

    public String getValidationType() {
        return validationType;
    }

    public void setValidationType(String validationType) {
        this.validationType = validationType;
    }

}
