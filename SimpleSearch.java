package com.applause.auto.test;

import org.testng.annotations.Test;

import com.applause.auto.framework.pageframework.util.logger.LogController;
import com.applause.auto.pageframework.testdata.TestConstants;
import com.applause.auto.pageframework.views.MainPage;
import com.applause.auto.pageframework.views.RecipeTypes;
import static org.testng.Assert.*;

public class SimpleSearch extends BaseAppiumTest {
    private MainPage Recipe;
    private RecipeTypes Search;
    private java.lang.String Validation;
    private int Count;
    String RECIPE = "Vegan Chocolate Chip Cookies";
    LogController logger = new LogController(SimpleSearch.class);
    /**
     * <ul>
     * <li>Test Name : Search for a Recipe name "Vegan Chocolate Chip Cookies"</li>
     * <li>Test Id: SFD-0001</li>
     * <li>Preconditions :</li>
     * <ul>
     * <li>None</li>
     * </ul>
     * <li>Steps</li>
     * <ul>
     * <li>1. Click Recipes on the Welcome Screen </li>
     * <li>2. Click on Search Text Box </li>
     * <li>3. Enter "Vegan Chocolate Chip Cookies" </li>
     * <li>4. Click on the "Vegan Chocolate Chip Cookies" Recipe</li>
     * </ul>
     * <li>Expected Results</li>
     * <ul>
     * <li>1. "Vegan Chocolate Chip Cookies" recipe is Displayed</li>
     * <li>2. Scroll to see that entire "Vegan Chocolate Chip Cookies" recipe is Displayed</li>
     * </ul>
     * </ul>
     * @return
     */

    @Test(groups = { TestConstants.TestNGGroups.SANITY }, description = "SFD-0001")
    public void MainWelcomePage() {

        logger.info("Step 1: Recipes button on the Main Page Clicked");
        Recipe = new MainPage();

        logger.info("Step 2: Peforming Search");
        Search = new RecipeTypes();
        logger.info("Step 4: Clicked on the Text Box to Enter Search Recipe");
        Search.textBox().enterText(RECIPE + '\n');

        Count = Integer.parseInt(Search.ResultNumber().getStringValue());
        if (Count > 0) {
            Search.OpenRecipe();
            Validation = Search.RecipeValidation1().getStringValue();
            logger.info("Step 5: Clicked on the Text Box to Enter Recipe");
            assertEquals(Validation, RECIPE, "Failure: ");
            logger.info("Step 7: You got the "+RECIPE+" Recipe ");

            logger.info("Step 8: Another Validation ---- Scrolling through the entire Recipe ");
            Search.Scroll();
            assertTrue(Search.Validation2());
            logger.info("Step 9: The Entire Recipe was Displayed");
        }
        else
        {
            logger.info("Sorry we did not find " +RECIPE);
        }
    }
}
