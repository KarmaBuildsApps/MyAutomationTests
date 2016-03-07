package myapp.tae.ac.uk.myautomationtests;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.EditText;

import com.robotium.solo.Solo;

/**
 * Created by Karma on 04/03/16.
 */

public class MainActivityRobotiumTest extends ActivityInstrumentationTestCase2 {
    private Solo solo;
    private static final String LAUNCHER_ACTIVITY_FULL_CLASSNAME = "myapp.tae.ac.uk.myautomationtests.MainActivity";
    private static final Class<?> launcherActivityClass;

    static {
        try {
            launcherActivityClass = Class.forName(LAUNCHER_ACTIVITY_FULL_CLASSNAME);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public MainActivityRobotiumTest() {
        super(launcherActivityClass);
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
        solo = new Solo(getInstrumentation(), getActivity());
    }

    public void testDataEntryInLogin() throws Exception {
        solo.assertCurrentActivity("Wrong Class", MainActivity.class);
        EditText etField1 = (EditText) solo.getView(R.id.etUserName);
        EditText etField2 = (EditText) solo.getView(R.id.etPassword);
        Button btLogin = (Button) solo.getView(R.id.btLogin);
        solo.clickOnView(etField1);
        solo.sleep(3000);
        solo.enterText(etField1, "Mr");
        assertTrue(solo.waitForText("Mr"));
        solo.clickOnView(etField2);
        solo.enterText(etField2, "alberto");
        assertTrue(solo.waitForText("alberto"));
        solo.sleep(3000);
        solo.clickOnView(btLogin);
        solo.sleep(5000);


    }

    @Override
    public void tearDown() throws Exception {
        super.tearDown();
//        solo.finishOpenedActivities();
    }
}