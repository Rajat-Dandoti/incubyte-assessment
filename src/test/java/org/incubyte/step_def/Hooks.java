package org.incubyte.step_def;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.incubyte.driver_base.DriverBase;

public class Hooks extends DriverBase {

    @Before
    public static void setUp() {
        initializeDriver();
    }

    @After
    public static void tearDown() {
        tearDownDriver();
    }
}