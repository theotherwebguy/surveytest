package com.simplefundamentals.survey;

import com.simplefundamentals.survey.pages.SurveyFormPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * JUnit 5 test class for automating the submission of a Google Form survey.
 *
 * <p>Responsibilities:
 * <ul>
 *     <li>Sets up and tears down the Selenium WebDriver lifecycle.</li>
 *     <li>Executes a full end-to-end test case that fills in all survey questions
 *     using the Page Object {@link SurveyFormPage}.</li>
 *     <li>Validates that the survey is successfully submitted.</li>
 * </ul>
 *
 * <p>Tools & Frameworks:
 * <ul>
 *     <li>Selenium WebDriver for browser automation</li>
 *     <li>JUnit 5 for structuring and executing the test</li>
 *     <li>WebDriverManager for driver binary management</li>
 * </ul>
 *
 * <p>Execution Notes:
 * <ul>
 *     <li>The test runs in headless mode by default. To run with a visible browser,
 *     pass {@code -Dheadless=false} as a system property.</li>
 *     <li>ChromeOptions are configured for stability and CI/CD environments.</li>
 * </ul>
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SurveyFormTest {

    private WebDriver driver;
    private SurveyFormPage formPage;

    /**
     * Sets up the ChromeDriver instance and initializes the SurveyFormPage object.
     * Runs once before all test cases.
     */
    @BeforeAll
    void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();

        // Run headless unless explicitly disabled
        if (Boolean.parseBoolean(System.getProperty("headless", "false"))) {
            options.addArguments("--headless=new");
        }
        options.addArguments("--disable-gpu", "--window-size=1920,1080");

        driver = new ChromeDriver(options);
        formPage = new SurveyFormPage(driver);
    }

    /**
     * Quits the WebDriver instance after all tests are completed.
     */
    @AfterAll
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    /**
     * End-to-end test that:
     * <ol>
     *     <li>Opens the Google Form.</li>
     *     <li>Selects answers for all survey questions.</li>
     *     <li>Submits the form.</li>
     *     <li>Asserts that the submission confirmation message is displayed.</li>
     * </ol>
     */
    @Test
    void testSurveyMultipleSubmissions() {
        int runs = 300;

        for (int i = 1; i <= runs; i++) {
            System.out.println("=== Starting submission " + i + " ===");

            // Create a new browser session
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-gpu", "--window-size=1920,1080");
            if (Boolean.parseBoolean(System.getProperty("headless", "false"))) {
                options.addArguments("--headless=new");
            }

            WebDriver driver = new ChromeDriver(options);
            SurveyFormPage formPage = new SurveyFormPage(driver);

            try {
                formPage.open("https://docs.google.com/forms/d/e/1FAIpQLSfGU49rRQ0-NXGMh6nOHmh6azNPOK3EvFIeVSxG1eWIOjfw6w/viewform");

                formPage.selectAgeGroup();
                formPage.selectGender();
                formPage.selectFaculty();
                formPage.selectYear();
                formPage.selectTikTokUsage();
                formPage.selectAdsFrequency();
                formPage.selectContentTypes();
                formPage.selectPurchaseDecision();
                formPage.selectProductOptions();
                formPage.selectAdConvincingScale();
                formPage.selectUnplannedPurchase();
                formPage.selectBudgetConsideration();
                formPage.selectBudgetingExposure();
                formPage.selectConsumerTips();
                formPage.selectUniversityAwareness();
                formPage.selectShortFormVideos();
                formPage.selectWeeklyTips();
                formPage.selectComfortLevel();
                formPage.selectDigitalImportance();
                formPage.selectAgreement();
                formPage.selectPreferredFormats();
                formPage.fillExplanation();
                formPage.fillSuggestion();
                formPage.submit();

                Assertions.assertTrue(formPage.isSubmitted(), "Survey should be submitted successfully");

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                // Always quit the browser after each submission
                driver.quit();
            }

            // Wait 2–4 minutes before the next submission
            int waitTime = 120_000 + (int)(Math.random() * 120_000);
            System.out.println("Waiting " + (waitTime / 1000) + " seconds before next submission...");
            try { Thread.sleep(waitTime); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        }
    }


}

