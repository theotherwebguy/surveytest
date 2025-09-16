package com.simplefundamentals.survey.utils;

import com.simplefundamentals.survey.locators.SurveyFormLocators;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Helper class for generating random survey answers.
 * Each method returns a locator string (CSS or XPath) for the selected option.
 */
public class SurveyRandomizer {

    private final SurveyFormLocators locators = new SurveyFormLocators();
    private final Random random = new Random();

    public String getRandomAgeGroup() {
        List<String> options = List.of(
                locators.getAgeGroup_18_20(),
                locators.getAgeGroup_21_23(),
                locators.getAgeGroup_24_26(),
                locators.getAgeGroup_27_above()
        );
        return options.get(random.nextInt(options.size()));
    }

    /** Returns a random Gender locator */
    public String getRandomGender() {
        List<String> options = List.of(
                locators.getGender_male(),
                locators.getGender_female(),
                locators.getGender_other(),
                locators.getGender_prefer_not()
        );
        return options.get(random.nextInt(options.size()));
    }

    /** Returns a random Faculty locator */
    public String getRandomFaculty() {
        List<String> options = List.of(
                locators.getFaculty_science(),
                locators.getFaculty_education(),
                locators.getFaculty_humanities(),
                locators.getFaculty_commerce(),
                locators.getFaculty_other()
        );
        return options.get(random.nextInt(options.size()));
    }

    /** Returns a random Year of Study locator */
    public String getRandomYear() {
        List<String> options = List.of(
                locators.getYear_1st(),
                locators.getYear_2nd(),
                locators.getYear_3rd(),
                locators.getYear_4th(),
                locators.getYear_honours()
        );
        return options.get(random.nextInt(options.size()));
    }

    /** Returns a random Ads Frequency locator */
    public String getRandomAdsFrequency() {
        List<String> options = List.of(
                locators.getAds_all_time(),
                locators.getAds_sometimes(),
                locators.getAds_rarely(),
                locators.getAds_never()
        );
        return options.get(random.nextInt(options.size()));
    }

    /**
     * Returns a random combination of TikTok content types.
     * Can return 1 to all options, randomly.
     */
    public List<String> getRandomContentTypes() {
        List<String> allOptions = List.of(
                locators.getViral_challenges(),
                locators.getInfluencer_reviews(),
                locators.getUnboxing_demos(),
                locators.getTutorials(),
                locators.getNone_option()
        );
        List<String> selected = new ArrayList<>();
        for (String option : allOptions) {
            if (random.nextBoolean()) { // 50% chance to pick each
                selected.add(option);
            }
        }
        // Ensure at least one option is selected
        if (selected.isEmpty()) {
            selected.add(allOptions.get(random.nextInt(allOptions.size())));
        }
        return selected;
    }

    /** Returns a random 1–5 TikTok ad convincing scale locator */
    public String getRandomAdConvincingScale() {
        List<String> options = List.of(
                locators.getTiktok_ad_convincing_1(),
                locators.getTiktok_ad_convincing_2(),
                locators.getTiktok_ad_convincing_3(),
                locators.getTiktok_ad_convincing_4(),
                locators.getTiktok_ad_convincing_5()
        );
        return options.get(random.nextInt(options.size()));
    }

    /** Returns a random selection of TikTok product options (1–all) */
    public List<String> getRandomProductOptions() {
        List<String> allOptions = List.of(
                locators.getBought_tiktok_clothing_fashion(),
                locators.getBought_tiktok_beauty_skincare(),
                locators.getBought_tiktok_gadgets_technology(),
                locators.getBought_tiktok_food_lifestyle(),
                locators.getBought_tiktok_subscriptions_apps(),
                locators.getBought_tiktok_other()
        );

        List<String> selected = new ArrayList<>();
        for (String option : allOptions) {
            if (random.nextBoolean()) { // ~50% chance to pick each
                selected.add(option);
            }
        }
        // Ensure at least one option is selected
        if (selected.isEmpty()) {
            selected.add(allOptions.get(random.nextInt(allOptions.size())));
        }
        return selected;
    }


    /** Returns a random short-form video effectiveness option */
    public String getRandomShortFormVideoEffectiveness() {
        List<String> options = List.of(
                locators.getVideo_very_effective(),
                locators.getVideo_somewhat_effective(),
                locators.getVideo_neutral(),
                locators.getVideo_not_very_effective(),
                locators.getVideo_not_effective_at_all()
        );
        return options.get(random.nextInt(options.size()));
    }


    /** Returns a random Budget Consideration option */
    public String getRandomBudgetConsideration() {
        List<String> options = List.of(
                locators.getBudget_always(),
                locators.getBudget_sometimes(),
                locators.getBudget_rarely(),
                locators.getBudget_never()
        );
        return options.get(random.nextInt(options.size()));
    }


    /** Returns a random Comfort Level option */
    public String getRandomComfortLevel() {
        List<String> options = List.of(
                locators.getComfort_very(),
                locators.getComfort_somewhat(),
                locators.getComfort_neutral(),
                locators.getComfort_uncomfortable(),
                locators.getComfort_notAtAll()
        );
        return options.get(random.nextInt(options.size()));
    }


    /** Returns a random Digital Importance option */
    public String getRandomDigitalImportance() {
        List<String> options = List.of(
                locators.getImportance_very(),
                locators.getImportance_important(),
                locators.getImportance_neutral(),
                locators.getImportance_notVery(),
                locators.getImportance_notAtAll()
        );
        return options.get(random.nextInt(options.size()));
    }


    /** Returns a random Agreement option */
    public String getRandomAgreement() {
        List<String> options = List.of(
                locators.getAgree_strongly(),
                locators.getAgree(),
                locators.getAgree_neutral(),
                locators.getAgree_disagree(),
                locators.getAgree_stronglyDisagree()
        );
        return options.get(random.nextInt(options.size()));
    }


    /** /** Returns one or more random Preferred Communication Formats */
    public List<String> getRandomPreferredFormats() {
        List<String> allOptions = List.of(
                locators.getFormatTikTok(),
                locators.getFormatInstagram(),
                locators.getFormatYouTube(),
                locators.getFormatWhatsAppSMS(),
                locators.getFormatWorkshops(),
                locators.getFormatPodcasts()
        );

        List<String> selected = new ArrayList<>();
        for (String option : allOptions) {
            if (random.nextBoolean()) { // ~50% chance per option
                selected.add(option);
            }
        }
        // Ensure at least one option is selected
        if (selected.isEmpty()) {
            selected.add(allOptions.get(random.nextInt(allOptions.size())));
        }
        return selected;
    }



    /** Returns a random explanation text */
    public String getRandomExplanation() {
        List<String> options = List.of(
                "TikTok is educational.",
                "I find TikTok entertaining and informative.",
                "TikTok helps me stay updated on trends.",
                "The platform offers diverse content.",
                "I use TikTok to learn new skills.",
                "TikTok provides relatable content.",
                "It’s a great source of news and updates.",
                "I enjoy influencer content on TikTok.",
                "TikTok allows me to relax and laugh.",
                "The content variety keeps me engaged.",
                "TikTok helps me discover new products.",
                "It connects me with like-minded communities.",
                "I like how quick and short the videos are.",
                "It motivates me to try new things.",
                "I get career and study tips from TikTok.",
                "The algorithm shows me relevant content.",
                "I enjoy music and dance trends on TikTok.",
                "It gives me inspiration for hobbies.",
                "I find relatable humor on TikTok.",
                "It helps me escape from stress.",
                "TikTok helps me learn languages.",
                "It keeps me socially connected.",
                "TikTok provides exposure to global culture.",
                "I like the creativity on TikTok.",
                "It’s a good break during studies.",
                "I learn cooking tips from TikTok.",
                "It’s more engaging than other platforms.",
                "TikTok shows me DIY projects.",
                "I use it for entertainment before bed.",
                "TikTok is my go-to platform for fun.",
                "It helps me improve my communication skills.",
                "I find new study hacks on TikTok.",
                "The recommendations feel personalized.",
                "It inspires me to be more creative.",
                "I enjoy the humor and memes.",
                "TikTok introduces me to new cultures.",
                "It gives me workout and fitness tips.",
                "I learn about mental health awareness.",
                "TikTok helps me stay positive.",
                "It keeps me entertained during breaks.",
                "I use TikTok to follow trends in fashion.",
                "It’s a fun way to discover music.",
                "TikTok helps me explore new hobbies.",
                "I enjoy the artistic content.",
                "It helps me stay motivated for studies.",
                "TikTok helps me connect with creators.",
                "It provides entertainment while traveling.",
                "I enjoy learning about technology tips.",
                "TikTok makes boring tasks fun.",
                "It teaches me about personal growth.",
                "TikTok inspires me to try cooking recipes.",
                "I use TikTok to keep up with pop culture.",
                "It improves my knowledge of world issues.",
                "TikTok encourages me to try challenges.",
                "It helps me reduce boredom.",
                "TikTok shows me relatable life stories.",
                "I use it to improve my confidence.",
                "It introduces me to inspirational people.",
                "I find helpful academic content.",
                "It’s a good distraction from stress.",
                "TikTok broadens my world view.",
                "I enjoy funny animal videos.",
                "It motivates me with success stories.",
                "TikTok helps me relax after studying.",
                "I learn new productivity hacks.",
                "It shows me motivational quotes.",
                "I enjoy cultural and travel content.",
                "TikTok teaches me soft skills.",
                "I use TikTok to connect with global youth.",
                "It inspires me to create my own content.",
                "TikTok is fun and engaging daily.",
                "It keeps me aware of social issues.",
                "TikTok makes learning enjoyable.",
                "I follow science facts on TikTok.",
                "It improves my general knowledge.",
                "TikTok is a source of inspiration.",
                "It keeps me entertained during commutes.",
                "I follow business tips on TikTok.",
                "TikTok helps me stay trendy.",
                "It makes studying more bearable.",
                "TikTok shows me motivational stories.",
                "I enjoy short documentaries on TikTok.",
                "It provides unique perspectives.",
                "TikTok helps me build confidence.",
                "I discover new books through TikTok.",
                "It’s my escape after a long day.",
                "I use TikTok to learn photography tricks.",
                "It helps me manage stress better.",
                "TikTok gives me mindfulness tips.",
                "It connects me to global events.",
                "TikTok helps me explore fashion styles.",
                "I get beauty and skincare tips.",
                "It helps me practice creativity.",
                "TikTok sparks new ideas for projects.",
                "I use it to find travel destinations.",
                "It’s like a mini-learning platform.",
                "TikTok shows me everyday life hacks.",
                "It inspires me to think differently.",
                "I follow motivational speakers.",
                "It helps me discover side hustles.",
                "TikTok makes me laugh daily.",
                "It’s a quick way to unwind.",
                "I enjoy exploring new perspectives.",
                "It boosts my mood instantly.",
                "TikTok helps me learn public speaking.",
                "I enjoy wellness and health tips.",
                "It sparks curiosity in me.",
                "I use TikTok for daily motivation.",
                "It helps me engage with my passions.",
                "TikTok introduces me to new food ideas.",
                "It encourages positive habits.",
                "I like the realness of TikTok content.",
                "It gives me financial literacy tips.",
                "TikTok feels refreshing compared to TV.",
                "I follow career advice on TikTok.",
                "It connects me to creative communities.",
                "TikTok is my learning and fun hub.",
                "I find entrepreneurial tips there.",
                "It helps me balance work and life.",
                "TikTok provides valuable life lessons.",
                "It’s both fun and educational.",
                "TikTok makes global culture accessible.",
                "It gives me a sense of belonging.",
                "TikTok helps me set new goals.",
                "It fuels my curiosity.",
                "I learn digital skills from TikTok.",
                "It introduces me to different viewpoints.",
                "TikTok helps me discover new art forms.",
                "It’s an outlet for self-expression.",
                "I follow study vloggers on TikTok.",
                "It inspires me to push boundaries.",
                "TikTok connects me to role models.",
                "I enjoy creative storytelling there.",
                "It gives me strategies for success.",
                "TikTok keeps me culturally updated.",
                "I enjoy its quick learning content.",
                "It offers me fresh perspectives daily."
        );
        return options.get(random.nextInt(options.size()));
    }

    /** Returns a random suggestion text */
    public String getRandomSuggestion() {
        List<String> options = List.of(
                "Add more case studies and financial literacy videos.",
                "Provide short, engaging financial tips daily.",
                "Create more interactive quizzes and polls.",
                "Offer webinars with guest speakers.",
                "Simplify explanations with infographics.",
                "Add real-world financial success stories.",
                "Include budgeting challenges.",
                "Introduce expert Q&A sessions.",
                "Make financial communication more visual.",
                "Use relatable examples for young people.",
                "Add more regional case studies.",
                "Provide financial tips in short video format.",
                "Make a weekly financial podcast.",
                "Use memes to explain financial topics.",
                "Offer beginner-friendly investment guides.",
                "Include financial literacy games.",
                "Use live sessions for Q&A.",
                "Make financial topics easier to understand.",
                "Offer real-world budgeting templates.",
                "Add interviews with financial experts.",
                "Create a financial FAQ section.",
                "Provide success stories of young entrepreneurs.",
                "Add step-by-step saving guides.",
                "Make infographics for complex topics.",
                "Include more practical examples.",
                "Offer downloadable resources.",
                "Add quick polls for feedback.",
                "Introduce peer-to-peer discussion forums.",
                "Add localized financial advice.",
                "Include stories from students’ experiences.",
                "Offer video tutorials for beginners.",
                "Create short animated explainers.",
                "Add gamified learning modules.",
                "Provide real-time financial updates.",
                "Use roleplay to teach financial decisions.",
                "Offer themed weekly challenges.",
                "Include real-time quizzes with prizes.",
                "Add more scholarship information.",
                "Introduce financial simulation games.",
                "Create monthly budgeting competitions.",
                "Offer daily motivational money quotes.",
                "Use influencers to promote financial literacy.",
                "Make group learning activities.",
                "Add behind-the-scenes from financial experts.",
                "Provide stories about money mistakes.",
                "Offer templates for business planning.",
                "Use scenarios from student life.",
                "Include more hands-on exercises.",
                "Make step-by-step loan guides.",
                "Add peer reviews on financial strategies.",
                "Offer a mentorship program online.",
                "Provide practical internship case studies.",
                "Add trending financial news recaps.",
                "Include visual timelines for goals.",
                "Offer group discussions live.",
                "Add real-world startup journeys.",
                "Include interactive budgeting apps.",
                "Provide tips for earning side income.",
                "Offer tax basics for beginners.",
                "Add insurance awareness sessions.",
                "Use storytelling for financial lessons.",
                "Offer workshops on digital banking.",
                "Provide resources for debt management.",
                "Add tips for balancing study and money.",
                "Introduce global case comparisons.",
                "Offer downloadable money planners.",
                "Include testimonials from students.",
                "Make more content in multiple languages.",
                "Use humor to simplify finance.",
                "Add career-related financial tips.",
                "Offer monthly progress trackers.",
                "Include practical money-saving hacks.",
                "Provide live budgeting walkthroughs.",
                "Introduce interactive challenges.",
                "Add case-based learning activities.",
                "Offer scholarships guidance sessions.",
                "Include peer competitions.",
                "Make money management a game.",
                "Provide monthly resource packs.",
                "Introduce finance roleplay videos.",
                "Offer themed learning weeks.",
                "Add Q&A with entrepreneurs.",
                "Provide group-based case studies.",
                "Introduce quick fact cards.",
                "Add real-time student polls.",
                "Provide student-focused budgeting apps.",
                "Include practical side hustle guides.",
                "Add live-streamed study sessions.",
                "Offer collaboration spaces online.",
                "Make micro-learning videos.",
                "Provide quizzes with leaderboards.",
                "Include financial trivia challenges.",
                "Add alumni stories about finance.",
                "Provide motivational budgeting stories.",
                "Offer interactive saving diaries.",
                "Include finance-based simulations.",
                "Add visual step-by-step guides.",
                "Offer community discussion boards.",
                "Make infographic series weekly.",
                "Provide global money-saving hacks.",
                "Add peer mentoring sessions.",
                "Offer monthly expert columns.",
                "Include AI-based personalized tips.",
                "Provide live group debates.",
                "Make scenario-based decision challenges.",
                "Offer internship finance lessons.",
                "Add content on digital currencies.",
                "Provide tax return workshops.",
                "Include credit score awareness.",
                "Add fun finance trivia nights.",
                "Offer student budgeting eBooks.",
                "Make collaborative projects.",
                "Provide rewards for consistent learners.",
                "Add storytelling-based finance videos.",
                "Offer budgeting simulations.",
                "Include career-specific financial advice.",
                "Make daily finance challenges.",
                "Provide personalized finance journals.",
                "Add lifestyle-based finance examples.",
                "Offer gamified money competitions.",
                "Introduce mini-documentaries.",
                "Include expert advice series.",
                "Provide role models’ financial journeys.",
                "Add multi-language infographics.",
                "Offer comparative finance lessons.",
                "Make live Q&A podcasts.",
                "Provide scholarship interview tips.",
                "Add mock finance competitions.",
                "Include digital wallet tutorials.",
                "Offer budgeting milestone trackers.",
                "Make student case competitions.",
                "Provide saving streak rewards.",
                "Include daily financial challenges."
        );
        return options.get(random.nextInt(options.size()));
    }






}
