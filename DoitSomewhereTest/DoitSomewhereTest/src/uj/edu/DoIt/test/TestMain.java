package uj.edu.DoIt.test;

import uj.edu.DoIt.*;
import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.Smoke;

import com.jayway.android.robotium.solo.Solo;

public class TestMain extends ActivityInstrumentationTestCase2<DoitSomewhereActivity> {
	
	private Solo solo;
	
	public TestMain() {
		super("uj.edu.DoIt.DoitSomewhere", DoitSomewhereActivity.class);
	}

	protected void setUp() throws Exception {
		solo = new Solo(getInstrumentation(), getActivity());
	}
	@Smoke
	public void testBLogin() throws Exception {
		
		//solo.assertCurrentActivity("Expected Doitsomewhere activity", "DoitSomewhere"); 
		solo.enterText(0, "user1");
		solo.enterText(1, "haslo1");
		solo.clickOnButton("Login"); 
		solo.goBack();
	}
	
	@Smoke
	public void testCSetLocation() throws Exception {
		solo.enterText(0, "user1");
		solo.enterText(1, "haslo1");
		solo.clickOnButton("Login"); 
		solo.enterText(0, "124");
		solo.enterText(1, "36");
		solo.clickOnButton("Find locations");
		solo.goBack();
		solo.goBack();
	}
	
	@Smoke
	public void testDWatchLocationList() throws Exception {
		solo.enterText(0, "user1");
		solo.enterText(1, "haslo1");
		solo.clickOnButton("Login"); 
		solo.enterText(0, "124");
		solo.enterText(1, "36");
		solo.clickOnButton("Find locations");
		solo.clickOnText("dolor");
		solo.goBack();
		solo.goBack();
		solo.goBack();
		solo.clickOnButton("logout"); 
	}

	@Smoke
	public void testACreateAccount() throws Exception {
		solo.clickOnButton("Create new account");
		solo.enterText(0, "user1");
		solo.enterText(1, "user1@mail.com");
		solo.enterText(2, "password1");
		solo.enterText(3, "password1");
		solo.clickOnButton("Register");
		solo.goBack();
		}
	
	@Override
	public void tearDown() throws Exception {
		//Robotium will finish all the activities that have been opened
		solo.finishOpenedActivities();
	}
}
