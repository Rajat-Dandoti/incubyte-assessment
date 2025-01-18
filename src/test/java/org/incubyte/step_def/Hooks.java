package org.incubyte.step_def;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.AfterAll;
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