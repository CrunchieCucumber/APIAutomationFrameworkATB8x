package org.example.tests.integration.sample;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestIntegrationSample {

    @Test(groups = "integration",priority = 1)
    @Owner("Ayushi")
    @Description("Test1")
    public void testCreateBooking(){
        Assert.assertTrue(true);
    }

    @Test(groups = "integration",priority = 2)
    @Owner("Ayushi")
    @Description("Test2")
    public void testVerifyBookingID() {
        Assert.assertTrue(true);
    }
}
