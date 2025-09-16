package com.simplefundamentals.survey.pages;

import com.simplefundamentals.survey.locators.SurveyFormLocators;
import com.simplefundamentals.survey.utils.SurveyRandomizer;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

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
    private final SurveyRandomizer randomizer = new SurveyRandomizer();

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
            delay();
            String locator = randomizer.getRandomAgeGroup();
            wait.until(ExpectedConditions.elementToBeClickable(by(locator))).click();
            delay();
            log("Selected Age Group randomly: " + locator);
        } catch (Exception e) { throw new RuntimeException("Failed at selectAgeGroup()", e); }
    }

    /**
     * Question: "What is your gender?"
     * <p>Selects Male option.</p>
     */

    public void selectGender() {
        try {
            delay();
            String locator = randomizer.getRandomGender(); // <-- random selection
            wait.until(ExpectedConditions.elementToBeClickable(by(locator))).click();
            delay();
            log("Selected Gender randomly: " + locator);
        } catch (Exception e) { throw new RuntimeException("Failed at selectGender()", e); }
    }

    /**
     * Question: "Which faculty are you enrolled in?"
     * <p>Selects a random faculty option using SurveyRandomizer.</p>
     */
    public void selectFaculty() {
        try {
            delay();
            String locator = randomizer.getRandomFaculty(); // <-- random selection
            wait.until(ExpectedConditions.elementToBeClickable(by(locator))).click();
            delay();
            log("Selected Faculty randomly: " + locator);
        } catch (Exception e) {
            throw new RuntimeException("Failed at selectFaculty()", e);
        }
    }


    /**
     * Question: "Which year of study are you in?"
     * <p>Selects a random year using SurveyRandomizer.</p>
     */
    public void selectYear() {
        try {
            delay();
            String locator = randomizer.getRandomYear(); // <-- random selection
            wait.until(ExpectedConditions.elementToBeClickable(by(locator))).click();
            delay();
            log("Selected Year randomly: " + locator);
        } catch (Exception e) {
            throw new RuntimeException("Failed at selectYear()", e);
        }
    }


    /**
     * Question: "Do you use TikTok?"
     * <p>Selects Yes.</p>
     */
    public void selectTikTokUsage() {
        try {
            delay();
            wait.until(ExpectedConditions.elementToBeClickable(by(locators.getTiktok_yes()))).click();
            delay();
            log("Selected TikTok Usage Yes");
        } catch (Exception e) { throw new RuntimeException("Failed at selectTikTokUsage()", e); }
    }

    /**
     * Question: "How often do you see ads on TikTok?"
     * <p>Selects a random frequency using SurveyRandomizer.</p>
     */
    public void selectAdsFrequency() {
        try {
            delay();
            String locator = randomizer.getRandomAdsFrequency(); // random selection
            wait.until(ExpectedConditions.elementToBeClickable(by(locator))).click();
            delay();
            log("Selected Ads Frequency randomly: " + locator);
        } catch (Exception e) {
            throw new RuntimeException("Failed at selectAdsFrequency()", e);
        }
    }


    /**
     * Question: "What types of content do you consume?"
     * <p>Selects random content types using SurveyRandomizer (multi-select).</p>
     */
    public void selectContentTypes() {
        try {
            delay();
            // Get a random list of content types (could be 1 or many)
            List<String> selectedLocators = randomizer.getRandomContentTypes();

            for (String locator : selectedLocators) {
                wait.until(ExpectedConditions.elementToBeClickable(by(locator))).click();
                delay();
                log("Selected Content Type: " + locator);
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed at selectContentTypes()", e);
        }
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
     * <p>Selects one or more random product options using SurveyRandomizer,
     * while ignoring the "Other" option to avoid crashes.</p>
     */
    public void selectProductOptions() {
        try {
            delay();
            List<String> selectedLocators = randomizer.getRandomProductOptions();

            // Filter out "Other" option safely
            selectedLocators.removeIf(locator -> locator.contains("Other") || locator.toLowerCase().contains("other"));

            for (String locator : selectedLocators) {
                wait.until(ExpectedConditions.elementToBeClickable(by(locator))).click();
                delay();
                log("Selected Product Option: " + locator);
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed at selectProductOptions()", e);
        }
    }



    /**
     * Question: "On a scale of 1–5, how convincing are TikTok ads?"
     * <p>Selects a random value using SurveyRandomizer.</p>
     */
    public void selectAdConvincingScale() {
        try {
            delay();
            String locator = randomizer.getRandomAdConvincingScale(); // random 1–5

            wait.until(ExpectedConditions.elementToBeClickable(by(locator))).click();
            delay();
            log("Selected Ad Convincing Scale randomly: " + locator);
        } catch (Exception e) {
            throw new RuntimeException("Failed at selectAdConvincingScale()", e);
        }
    }


    /**
     * Question: "Have you made unplanned purchases influenced by TikTok?"
     * <p>Selects Yes.</p>
     */
    public void selectUnplannedPurchase() {
        try {
            delay();
            wait.until(ExpectedConditions.elementToBeClickable(by(locators.getUnplanned_purchase_yes()))).click();
            delay();
            log("Selected Unplanned Purchase Yes");
        } catch (Exception e) { throw new RuntimeException("Failed at selectUnplannedPurchase()", e); }
    }

    /**
     * Question: "Do you consider your budget when making purchases?"
     * <p>Selects a random option using SurveyRandomizer.</p>
     */
    public void selectBudgetConsideration() {
        try {
            delay();
            String locator = randomizer.getRandomBudgetConsideration(); // new random method
            wait.until(ExpectedConditions.elementToBeClickable(by(locator))).click();
            delay();
            log("Selected Budget Consideration randomly: " + locator);
        } catch (Exception e) {
            throw new RuntimeException("Failed at selectBudgetConsideration()", e);
        }
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
            delay();
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
            delay();
            wait.until(ExpectedConditions.elementToBeClickable(by(locators.getUni_not_sure()))).click();
            delay();
            log("Selected University Awareness Not Sure");
        } catch (Exception e) { throw new RuntimeException("Failed at selectUniversityAwareness()", e); }
    }

    /**
     * Question: "How effective are short-form videos for financial education?"
     * <p>Selects a random effectiveness option using SurveyRandomizer.</p>
     */
    public void selectShortFormVideos() {
        try {
            delay();
            String locator = randomizer.getRandomShortFormVideoEffectiveness(); // new random method
            wait.until(ExpectedConditions.elementToBeClickable(by(locator))).click();
            delay();
            log("Selected Short Form Videos randomly: " + locator);
        } catch (Exception e) {
            throw new RuntimeException("Failed at selectShortFormVideos()", e);
        }
    }


    /**
     * Question: "Would you like weekly tips from the university?"
     * <p>Selects Maybe.</p>
     */
    public void selectWeeklyTips() {
        try {
            delay();
            wait.until(ExpectedConditions.elementToBeClickable(by(locators.getTip_maybe()))).click();
            delay();
            log("Selected Weekly Tips maybe");
        } catch (Exception e) { throw new RuntimeException("Failed at selectWeeklyTips()", e); }
    }

    /**
     * Question: "How comfortable are you discussing finances?"
     * <p>Selects a random comfort level, but never Neutral.</p>
     */
    public void selectComfortLevel() {
        try {
            delay();

            String locator;
            // keep trying until it's not Neutral
            do {
                locator = randomizer.getRandomComfortLevel();
            } while (locator.toLowerCase().contains("neutral"));

            wait.until(ExpectedConditions.elementToBeClickable(by(locator))).click();
            delay();
            log("Selected Comfort Level (non-neutral) randomly: " + locator);
        } catch (Exception e) {
            throw new RuntimeException("Failed at selectComfortLevel()", e);
        }
    }



    /**
     * Question: "How important is digital content for financial education?"
     * <p>Selects a random importance option using SurveyRandomizer (excludes Neutral).</p>
     */
    public void selectDigitalImportance() {
        try {
            delay();

            String locator;
            int attempts = 0;
            do {
                locator = randomizer.getRandomDigitalImportance();
                attempts++;
                // Prevent infinite loop in case all locators are Neutral by mistake
                if (attempts > 10) {
                    throw new RuntimeException("Randomizer kept picking Neutral for Digital Importance.");
                }
            } while (locator.contains("Neutral"));

            wait.until(ExpectedConditions.elementToBeClickable(by(locator))).click();
            delay();
            log("Selected Digital Importance randomly (non-neutral): " + locator);
        } catch (Exception e) {
            throw new RuntimeException("Failed at selectDigitalImportance()", e);
        }
    }



    /**
     * Question: "To what extent do you agree with the statement [X]?"
     * <p>Selects a random agreement option, but never Neutral.</p>
     */
    public void selectAgreement() {
        try {
            delay();

            String locator;
            // Keep picking until it's not Neutral
            do {
                locator = randomizer.getRandomAgreement();
            } while (locator.toLowerCase().contains("neutral"));

            wait.until(ExpectedConditions.elementToBeClickable(by(locator))).click();
            delay();
            log("Selected Agreement (non-neutral) randomly: " + locator);
        } catch (Exception e) {
            throw new RuntimeException("Failed at selectAgreement()", e);
        }
    }


    /**
     * Question: "What formats do you prefer for learning?"
     * <p>Selects one or more random formats from SurveyRandomizer.</p>
     */
    public void selectPreferredFormats() {
        try {
            delay();
            // Get a list of 1–all random preferred formats
            List<String> selectedLocators = randomizer.getRandomPreferredFormats();

            for (String locator : selectedLocators) {
                wait.until(ExpectedConditions.elementToBeClickable(by(locator))).click();
                delay();
                log("Selected Preferred Format: " + locator);
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed at selectPreferredFormats()", e);
        }
    }


    /**
     * Question: "Please explain your preferred communication format."
     * <p>Fills explanation textarea with random text.</p>
     */
    public void fillExplanation() {
        try {
            delay();
            String text = randomizer.getRandomExplanation();
            driver.findElement(by(locators.getExplanationTextarea()))
                    .sendKeys(text);
            delay();
            log("Filled Explanation Textarea with: " + text);
        } catch (Exception e) {
            throw new RuntimeException("Failed at fillExplanation()", e);
        }
    }

    /**
     * Question: "Any suggestions to improve financial communication?"
     * <p>Fills suggestion textarea with random text.</p>
     */
    public void fillSuggestion() {
        try {
            delay();
            String text = randomizer.getRandomSuggestion();
            driver.findElement(by(locators.getSuggestionTextarea()))
                    .sendKeys(text);
            delay();
            log("Filled Suggestion Textarea with: " + text);
        } catch (Exception e) {
            throw new RuntimeException("Failed at fillSuggestion()", e);
        }
    }


    /**
     * Clicks the final "Submit" button to submit the survey.
     */
    public void submit() {
        try {
            delay();
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
