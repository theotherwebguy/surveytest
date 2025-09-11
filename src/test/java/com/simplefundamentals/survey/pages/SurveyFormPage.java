package com.simplefundamentals.survey.pages;

import com.simplefundamentals.survey.locators.SurveyFormLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Page Object class representing the Google Form survey page.
 *
 * <p>This class encapsulates all actions needed to fill out and submit
 * the survey form. Each method represents one question or one group of
 * actions in the survey, providing traceable logs and clear failure points.</p>
 */
public class SurveyFormPage {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private final SurveyFormLocators locators = new SurveyFormLocators();

    public SurveyFormPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    /** Adds a short pause to mimic human behavior. */
    private void delay() {
        try { Thread.sleep(2000); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
    }

    /** Converts locator string into a {@link By} object. */
    private By by(String locator) {
        return locator.startsWith("//") ? By.xpath(locator) : By.cssSelector(locator);
    }

    /** Prints success messages for each completed step. */
    private void log(String message) {
        System.out.println("[PASSED] " + message);
    }

    /**
     * Opens the Google Form by URL and waits for the form to load.
     *
     * @param url Google Form link
     */
    public void open(String url) {
        try {
            driver.get(url);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("form#mG61Hd")));
            delay();
            log("Opened survey form: " + url);
        } catch (Exception e) {
            throw new RuntimeException("Failed to open survey form: " + url, e);
        }
    }

    // ================= SURVEY QUESTIONS =================
    /**
     * Question: "What is your age group?"
     * <p>Selects Age Group 21–23.</p>
     */
    public void selectAgeGroup() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(by(locators.getAgeGroup_21_23()))).click();
            delay();
            log("Selected Age Group 21-23");
        } catch (Exception e) { throw new RuntimeException("Failed at selectAgeGroup()", e); }
    }

    /**
     * Question: "What is your gender?"
     * <p>Selects Male option.</p>
     */

    public void selectGender() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(by(locators.getGender_male()))).click();
            delay();
            log("Selected Gender Male");
        } catch (Exception e) { throw new RuntimeException("Failed at selectGender()", e); }
    }

    /**
     * Question: "Which faculty are you enrolled in?"
     * <p>Selects Faculty of Science.</p>
     */
    public void selectFaculty() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(by(locators.getFaculty_science()))).click();
            delay();
            log("Selected Faculty Science");
        } catch (Exception e) { throw new RuntimeException("Failed at selectFaculty()", e); }
    }

    /**
     * Question: "Which year of study are you in?"
     * <p>Selects 3rd Year.</p>
     */
    public void selectYear() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(by(locators.getYear_3rd()))).click();
            delay();
            log("Selected Year 3rd");
        } catch (Exception e) { throw new RuntimeException("Failed at selectYear()", e); }
    }

    /**
     * Question: "Do you use TikTok?"
     * <p>Selects Yes.</p>
     */
    public void selectTikTokUsage() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(by(locators.getTiktok_yes()))).click();
            delay();
            log("Selected TikTok Usage Yes");
        } catch (Exception e) { throw new RuntimeException("Failed at selectTikTokUsage()", e); }
    }

    /**
     * Question: "How often do you see ads on TikTok?"
     * <p>Selects Sometimes.</p>
     */
    public void selectAdsFrequency() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(by(locators.getAds_sometimes()))).click();
            delay();
            log("Selected Ads Frequency Sometimes");
        } catch (Exception e) { throw new RuntimeException("Failed at selectAdsFrequency()", e); }
    }

    /**
     * Question: "What types of content do you consume?"
     * <p>Selects Viral Challenges and Influencer Reviews.</p>
     */
    public void selectContentTypes() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(by(locators.getViral_challenges()))).click();
            wait.until(ExpectedConditions.elementToBeClickable(by(locators.getInfluencer_reviews()))).click();
            delay();
            log("Selected Content Types: Viral Challenges & Influencer Reviews");
        } catch (Exception e) { throw new RuntimeException("Failed at selectContentTypes()", e); }
    }

    /**
     * Question: "Have you ever purchased a product you saw on TikTok?"
     * <p>Selects Yes and scrolls into view if necessary.</p>
     */
    public void selectPurchaseDecision() {
        try {
            WebElement checkbox = driver.findElement(by(locators.getBought_from_tiktok_yes()));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkbox);
            wait.until(ExpectedConditions.elementToBeClickable(checkbox)).click();
            delay();
            log("Selected Purchase Decision: Bought from TikTok Yes");
        } catch (Exception e) { throw new RuntimeException("Failed at selectPurchaseDecision()", e); }
    }

    /**
     * Question: "If yes, what product categories have you bought?"
     * <p>Selects Clothing/Fashion and Beauty/Skincare.</p>
     */
    public void selectProductOptions() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(by(locators.getBought_tiktok_clothing_fashion()))).click();
            wait.until(ExpectedConditions.elementToBeClickable(by(locators.getBought_tiktok_beauty_skincare()))).click();
            delay();
            log("Selected Product Options: Clothing & Beauty/Skincare");
        } catch (Exception e) { throw new RuntimeException("Failed at selectProductOptions()", e); }
    }

    /**
     * Question: "On a scale of 1–5, how convincing are TikTok ads?"
     * <p>Selects 4.</p>
     */
    public void selectAdConvincingScale() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(by(locators.getTiktok_ad_convincing_4()))).click();
            delay();
            log("Selected Ad Convincing Scale 4");
        } catch (Exception e) { throw new RuntimeException("Failed at selectAdConvincingScale()", e); }
    }

    /**
     * Question: "Have you made unplanned purchases influenced by TikTok?"
     * <p>Selects Yes.</p>
     */
    public void selectUnplannedPurchase() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(by(locators.getUnplanned_purchase_yes()))).click();
            delay();
            log("Selected Unplanned Purchase Yes");
        } catch (Exception e) { throw new RuntimeException("Failed at selectUnplannedPurchase()", e); }
    }

    /**
     * Question: "Do you consider your budget when making purchases?"
     * <p>Selects Sometimes.</p>
     */
    public void selectBudgetConsideration() {
        try {
            delay();
            wait.until(ExpectedConditions.elementToBeClickable(by(locators.getBudget_sometimes()))).click();
            delay();
            log("Selected Budget Consideration Sometimes");
        } catch (Exception e) { throw new RuntimeException("Failed at selectBudgetConsideration()", e); }
    }

    /**
     * Question: "Have you been exposed to budgeting content?"
     * <p>Selects "Yes" response using a safer click approach.</p>
     */
    public void selectBudgetingExposure() {
        try {
            delay();
            wait.until(ExpectedConditions.elementToBeClickable(by(locators.getBudgeting_not_sure()))).click();
            delay();
            log("Selected Budgeting Exposure: I'm not sure");
        } catch (Exception e) {
            throw new RuntimeException("Failed at selectBudgetingExposure()", e);
        }
    }




    /**
     * Question: "Would you consider financial tips from TikTok?"
     * <p>Selects Maybe.</p>
     */
    public void selectConsumerTips() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(by(locators.getTips_maybe()))).click();
            delay();
            log("Selected Consumer Tips Maybe");
        } catch (Exception e) { throw new RuntimeException("Failed at selectConsumerTips()", e); }
    }

    /**
     * Question: "Are you aware of university financial literacy campaigns?"
     * <p>Selects Not Sure.</p>
     */
    public void selectUniversityAwareness() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(by(locators.getUni_not_sure()))).click();
            delay();
            log("Selected University Awareness Not Sure");
        } catch (Exception e) { throw new RuntimeException("Failed at selectUniversityAwareness()", e); }
    }

    /**
     * Question: "How effective are short-form videos for financial education?"
     * <p>Selects Somewhat Effective.</p>
     */
    public void selectShortFormVideos() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(by(locators.getVideo_somewhat_effective()))).click();
            delay();
            log("Selected Short Form Videos Somewhat Effective");
        } catch (Exception e) { throw new RuntimeException("Failed at selectShortFormVideos()", e); }
    }

    /**
     * Question: "Would you like weekly tips from the university?"
     * <p>Selects Maybe.</p>
     */
    public void selectWeeklyTips() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(by(locators.getTip_maybe()))).click();
            delay();
            log("Selected Weekly Tips maybe");
        } catch (Exception e) { throw new RuntimeException("Failed at selectWeeklyTips()", e); }
    }

    /**
     * Question: "How comfortable are you discussing finances?"
     * <p>Selects Neutral.</p>
     */
    public void selectComfortLevel() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(by(locators.getComfort_somewhat()))).click();
            delay();
            log("Selected Comfort Level Neutral");
        } catch (Exception e) { throw new RuntimeException("Failed at selectComfortLevel()", e); }
    }

    /**
     * Question: "How important is digital content for financial education?"
     * <p>Selects Important.</p>
     */
    public void selectDigitalImportance() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(by(locators.getImportance_important()))).click();
            delay();
            log("Selected Digital Importance Important");
        } catch (Exception e) { throw new RuntimeException("Failed at selectDigitalImportance()", e); }
    }

    /**
     * Question: "To what extent do you agree with the statement [X]?"
     * <p>Selects Strongly Agree.</p>
     */
    public void selectAgreement() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(by(locators.getAgree_strongly()))).click();
            delay();
            log("Selected Agreement Strongly");
        } catch (Exception e) { throw new RuntimeException("Failed at selectAgreement()", e); }
    }

    /**
     * Question: "What formats do you prefer for learning?"
     * <p>Selects TikTok .</p>
     */
    public void selectPreferredFormats() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(by(locators.getFormatTikTok()))).click();

            delay();
            log("Selected Preferred Formats: TikTok ");
        } catch (Exception e) { throw new RuntimeException("Failed at selectPreferredFormats()", e); }
    }

    /**
     * Question: "Please explain your preferred communication format."
     * <p>Fills explanation textarea with sample text.</p>
     */
    public void fillExplanation() {
        try {
            driver.findElement(by(locators.getExplanationTextarea()))
                    .sendKeys("TikTok is  educational.");
            delay();
            log("Filled Explanation Textarea");
        } catch (Exception e) { throw new RuntimeException("Failed at fillExplanation()", e); }
    }

    /**
     * Question: "Any suggestions to improve financial communication?"
     * <p>Fills suggestion textarea with sample text.</p>
     */
    public void fillSuggestion() {
        try {
            driver.findElement(by(locators.getSuggestionTextarea()))
                    .sendKeys("Add more case studies and financial literacy videos and webinars.");
            delay();
            log("Filled Suggestion Textarea");
        } catch (Exception e) { throw new RuntimeException("Failed at fillSuggestion()", e); }
    }

    /**
     * Clicks the final "Submit" button to submit the survey.
     */
    public void submit() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(by(locators.getSubmit_button()))).click();
            delay();
            log("Submitted Survey Form");
        } catch (Exception e) { throw new RuntimeException("Failed at submit()", e); }
    }

    /**
     * Verifies if the survey submission was successful.
     *
     * @return true if a confirmation message is displayed
     */
    public boolean isSubmitted() {
        try {
            wait.until(ExpectedConditions.or(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Your response has been recorded')]")),
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Thank you')]"))
            ));
            log("Survey submission confirmed");
            return true;
        } catch (Exception e) { throw new RuntimeException("Survey submission not confirmed", e); }
    }
}
