package com.applause.auto.pageframework.views;

import com.applause.auto.framework.pageframework.device.AbstractDeviceView;
import com.applause.auto.framework.pageframework.devicecontrols.Button;


public class MainPage extends AbstractDeviceView {
    private Button RecipeButton;
    public MainPage()
    {
        super();
        waitUntilVisible();
        recipeButton().pressButton();

    }

    @Override
    protected void waitUntilVisible()
    {
        syncHelper.waitForElementToAppear(recipeButton());
    }

    public Button recipeButton()
    {
        RecipeButton = new Button(PageObjects.RECIPES_BUTTON);
        return RecipeButton;
    }


}
