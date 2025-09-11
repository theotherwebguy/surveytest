package com.simplefundamentals.survey.locators;

import lombok.Data;

@Data
public class SurveyFormLocators {

    // === Age Group (Radio Buttons) ===
    private final String ageGroup_18_20 = "div[aria-label='18–20']";
    private final String ageGroup_21_23 = "div[aria-label='21–23']";
    private final String ageGroup_24_26 = "div[aria-label='24–26']";
    private final String ageGroup_27_above = "div[aria-label='27 and above']";

    // === Gender (Radio Buttons) ===
    private final String gender_female = "div[aria-label='Female']";
    private final String gender_male = "div[aria-label='Male']";
    private final String gender_other =
            "//div[@role='heading' and contains(.,'Gender')]/following::div[@role='radio' and @aria-label='Other'][1]";
    private final String gender_prefer_not =
            "//div[@role='heading' and contains(.,'Gender')]/following::div[@role='radio' and @aria-label='Prefer not to say'][1]";

    private final String faculty_science = "div[aria-label='Science & Agriculture']";
    private final String faculty_education = "div[aria-label='Education']";
    private final String faculty_other =
            "//div[@role='heading' and contains(.,'Faculty')]/following::div[@role='radio' and @aria-label='Other'][1]";

    // === Year of Study (Radio Buttons) ===
    private final String year_1st = "div[aria-label='1st Year']";
    private final String year_2nd = "div[aria-label='2nd Year']";
    private final String year_3rd = "div[aria-label='3rd Year']";
    private final String year_4th = "div[aria-label='4th Year']";
    private final String year_honours = "div[aria-label='Honours/Postgraduate']";

    // === TikTok Usage (Radio Buttons) ===
    private final String tiktok_yes =
            "//div[@role='heading'][normalize-space(.)='Do you use TikTok regularly?']/following::div[@role='radio' and @aria-label='Yes'][1]";
    private final String tiktok_no =
            "//div[@role='heading'][normalize-space(.)='Do you use TikTok regularly?']/following::div[@role='radio' and @aria-label='No'][1]";

    // === Ads Frequency (Radio Buttons) ===
    private final String ads_all_time = "div[aria-label='All the time']";
    private final String ads_sometimes = "div[aria-label='Sometimes']";
    private final String ads_rarely = "div[aria-label='Rarely']";
    private final String ads_never = "div[aria-label='Never']";

    // === TikTok Content Types (Checkboxes) ===
    private final String influencer_reviews = "div[role='checkbox'][aria-label='Influencer reviews or endorsements']";
    private final String unboxing_demos = "div[role='checkbox'][aria-label='Unboxing or product demo videos']";
    private final String tutorials = "div[role='checkbox'][aria-label='Tutorials (e.g. skincare, tech, DIY)']";
    private final String none_option = "div[role='checkbox'][aria-label='None']";


    // Using only aria-label to locate checkboxes (more stable)
    private final String bought_from_tiktok_yes = "//div[@role='checkbox' and @aria-label='Yes']";
    private final String bought_from_tiktok_no = "//div[@role='checkbox' and @aria-label='No']";


    // === TikTok Product Options (Checkboxes) ===
    private final String bought_tiktok_clothing_fashion = "div[role='checkbox'][aria-label='Clothing / Fashion']";
    private final String bought_tiktok_beauty_skincare = "div[role='checkbox'][aria-label='Beauty / Skincare products']";
    private final String bought_tiktok_gadgets_technology = "div[role='checkbox'][aria-label='Gadgets / Technology']";
    private final String bought_tiktok_food_lifestyle = "div[role='checkbox'][aria-label='Food or lifestyle items']";
    private final String bought_tiktok_subscriptions_apps = "div[role='checkbox'][aria-label='Subscriptions or apps']";
    private final String bought_tiktok_other =
            "//div[@role='heading' and contains(.,'TikTok product options')]/following::div[@role='checkbox' and @aria-label='Other:'][1]";

    private final String bought_tiktok_other_input = "div[jsname='R6ztRd'] input[type='text']";

    private final String tiktok_ad_convincing_1 = "div[role='radio'][aria-label='1']";
    private final String tiktok_ad_convincing_2 = "div[role='radio'][aria-label='2']";
    private final String tiktok_ad_convincing_3 = "div[role='radio'][aria-label='3']";
    private final String tiktok_ad_convincing_4 = "div[role='radio'][aria-label='4']";
    private final String tiktok_ad_convincing_5 = "div[role='radio'][aria-label='5']";

    // === Unplanned Purchase after TikTok (Radio Buttons) ===
    private final String unplanned_purchase_yes =
            "//div[@role='heading' and contains(.,'unplanned purchase')]/following::div[@role='radio' and @aria-label='Yes'][1]";
    private final String unplanned_purchase_no =
            "//div[@role='heading' and contains(.,'unplanned purchase')]/following::div[@role='radio' and @aria-label='No'][1]";

    // === Budget Consideration (Radio Buttons) ===
    private final String budget_question = "//div[@role='heading' and contains(.,'think about your budget before buying')]";

    // Options inside that question only
    private final String budget_always = budget_question + "/following::div[@role='radiogroup'][1]//div[@role='radio' and @aria-label='Always']";
    private final String budget_sometimes = budget_question + "/following::div[@role='radiogroup'][1]//div[@role='radio' and @aria-label='Sometimes']";
    private final String budget_rarely = budget_question + "/following::div[@role='radiogroup'][1]//div[@role='radio' and @aria-label='Rarely']";
    private final String budget_never = budget_question + "/following::div[@role='radiogroup'][1]//div[@role='radio' and @aria-label='Never']";
    // === Faculty (Radio Buttons) ===
    private final String faculty_humanities = "div[aria-label='Humanities & Social Sciences']";
    private final String faculty_commerce = "div[aria-label='Commerce/Administration/Law']";
    private final String sponsored_content = "div[role='checkbox'][aria-label='Sponsored content from brands']";
    private final String viral_challenges = "div[role='checkbox'][aria-label='Viral challenges like #TikTokMadeMeBuyIt']";
    // === TikTok Advertising Convincing Scale (Radio Buttons) ===


// ==================== TikTok Budgeting Content Exposure Question ====================
// === TikTok Budgeting Content Exposure (Radio Buttons) ===
private final String budgeting_yes = "div[role='radio'][aria-label='Yes']";
    private final String budgeting_no = "div[role='radio'][aria-label='No']";
    private final String budgeting_not_sure = "div[role='radio'][aria-label=\"I'm not sure\"]";


    // === TikTok Responsible Consumer Tips (Radio Buttons) ===
    private final String tips_yes   = "div[role='radio'][aria-label='Yes']";
    private final String tips_no    = "div[role='radio'][aria-label='No']";
    private final String tips_maybe = "div[role='radio'][aria-label='Maybe']";


    // === Universities Smart Spending Awareness (Radio Buttons) ===
    private final String uni_yes      = "div[role='radio'][aria-label='Yes']";
    private final String uni_no       = "div[role='radio'][aria-label='No']";
    private final String uni_not_sure = "div[role='radio'][aria-label='Not sure']";


    // === Short-Form Videos Effectiveness (Radio Buttons) ===
    private final String video_very_effective = "div[aria-label='Very effective']";
    private final String video_somewhat_effective = "div[aria-label='Somewhat effective']";
    private final String video_neutral =
            "//div[@role='heading' and contains(.,'short-form videos')]/following::div[@role='radio' and @aria-label='Neutral'][1]";
    private final String video_not_very_effective = "div[aria-label='Not very effective']";
    private final String video_not_effective_at_all = "div[aria-label='Not effective at all']";

    // Locate the whole question block first
    private final String weekly_tips_section =
            "//div[@role='listitem'][.//div[@role='heading' and contains(.,'weekly WhatsApp or SMS tip')]]";

    // Options scoped inside that block
    private final String tip_yes   = weekly_tips_section + "//div[@role='radio'][@aria-label='Yes']";
    private final String tip_no    = weekly_tips_section + "//div[@role='radio'][@aria-label='No']";
    private final String tip_maybe = weekly_tips_section + "//div[@role='radio'][@aria-label='Maybe']";

    // === Comfort Sharing Budgeting/Spending Story (Radio Buttons) ===
    private final String comfort_very = "div[aria-label='Very comfortable']";
    private final String comfort_somewhat = "div[aria-label='Somewhat comfortable']";
    private final String comfort_neutral =
            "//div[@role='heading' and contains(.,'sharing budgeting')]/following::div[@role='radio' and @aria-label='Neutral'][1]";
    private final String comfort_uncomfortable = "div[aria-label='Uncomfortable']";
    private final String comfort_notAtAll = "div[aria-label='Not at all comfortable']";

    // === Importance of Digital Platforms (Radio Buttons) ===
    private final String importance_very = "div[aria-label='Very important']";
    private final String importance_important = "div[aria-label='Important']";
    private final String importance_neutral =
            "//div[@role='heading' and contains(.,'importance of digital platforms')]/following::div[@role='radio' and contains(@aria-label,'Neutral')][1]";
    private final String importance_notVery = "div[aria-label='Not very important']";
    private final String importance_notAtAll = "div[aria-label='Not important at all']";

    // === Agreement with Social Media Financial Content (Radio Buttons) ===
    private final String agree_strongly = "div[aria-label='Strongly agree']";
    private final String agree = "div[aria-label='Agree']";
    private final String agree_neutral =
            "//div[@role='heading' and contains(.,'financial content')]/following::div[@role='radio' and @aria-label='Neutral'][1]";
    private final String agree_disagree = "div[aria-label='Disagree']";
    private final String agree_stronglyDisagree = "div[aria-label='Strongly disagree']";

    // === Preferred Communication Formats  ===
    private final String formatTikTok      = "//div[@role='radio' and contains(@aria-label,'TikTok videos with bite')]";
    private final String formatInstagram   = "//div[@role='radio' and @aria-label='Instagram Reels']";
    private final String formatYouTube     = "//div[@role='radio' and contains(@aria-label,'YouTube tutorials')]";
    private final String formatWhatsAppSMS = "//div[@role='radio' and contains(@aria-label,'WhatsApp/SMS micro')]";
    private final String formatWorkshops   = "//div[@role='radio' and contains(@aria-label,'In-person or virtual workshops')]";
    private final String formatPodcasts    = "//div[@role='radio' and @aria-label='Podcasts']";


    // === Explanation for Top 2 Communication Formats ===
    private final String explanationTextarea = "textarea[jsname='YPqjbf']";

    // === Suggestions for Improving Communication ===
    private final String suggestionTextarea =
            "//div[contains(.,'Do you have any ideas or suggestions')]/following::textarea[@jsname='YPqjbf'][1]";

    // === Submit Button ===
    private final String submit_button =
            "//div[@role='button' and descendant::span[contains(normalize-space(.),'Submit')]]";
}
