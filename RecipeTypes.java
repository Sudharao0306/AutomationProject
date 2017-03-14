package com.applause.auto.pageframework.views;

import com.applause.auto.framework.pageframework.device.AbstractDeviceView;
import com.applause.auto.framework.pageframework.devicecontrols.Button;
import com.applause.auto.framework.pageframework.devicecontrols.Text;
import com.applause.auto.framework.pageframework.devicecontrols.TextBox;
import com.applause.auto.framework.pageframework.util.logger.LogController;


public class RecipeTypes extends AbstractDeviceView {
    LogController logger = new LogController(RecipeTypes.class);


    private TextBox textBox;
    private Button Desserts_Button;
    private Button Recipename;
    private Text RecipeValidationByText;



    public RecipeTypes()
        {
        super();
        logger.info("Step 3: Search Button Clicked");
        waitUntilVisible();
        search().pressButton();
        syncHelper.waitForElementToAppear(textBox());
        }
        public void OpenRecipe()
        {
        syncHelper.waitForElementToAppear(RecipeName());
        logger.info("Step 6: Clicked the Recipe to Validate whether we got the right Recipe");
        RecipeName().pressButton();
        syncHelper.waitForElementToAppear(RecipeValidation1());
        }

    @Override
    protected void waitUntilVisible()
    {
        syncHelper.waitForElementToAppear(search());
    }

    public Button search()
    {
        Desserts_Button = new Button(PageObjects.SEARCH_BUTTON);
        return Desserts_Button;

    }
    public TextBox textBox()
    {
        textBox = new TextBox(PageObjects.TEXT_BUTTON);
        return textBox;

    }

    public Text ResultNumber()
    {
       return new Text(PageObjects.RESULT_NUMBER);
    }


    public Button RecipeName()
    {
        Recipename = new Button(PageObjects.RECIPE_NAME);
        return Recipename;

    }
    public Text RecipeValidation1()
    {
        RecipeValidationByText = new Text(PageObjects.RECIPE_VALIDATION1);
        return RecipeValidationByText;
    }

    public void Scroll()
    {
        getDriver().swipe(400,1070,400,131, 1000);
        getDriver().swipe(400,1070,400,131, 1000);
        getDriver().swipe(400,1070,400,131, 1000);
        getDriver().swipe(400,1070,400,131, 1000);

    }
    public boolean Validation2()
    {
        return new Button(PageObjects.RECIPE_VALIDATION2).isDisplayed();
    }

}