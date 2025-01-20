package org.example.tests.integration.sample;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestIntegrationSample {

    @Test(groups = "qa",priority = 1)
    @Owner("Ayushi")
    @Description("Test1")
    public void testCreateBooking(){
        Assert.assertTrue(true);
    }

    @Test(groups = "qa",priority = 2)
    @Owner("Ayushi")
    @Description("Test2")
    public void testVerifyBookingID() {
        Assert.assertTrue(true);
    }
}
