package org.example.tests.integration.crud;

import org.example.base.BaseTest;
import org.example.endpoints.APIConstants;
import org.example.pojos.BookingResponse;
import io.qameta.allure.*;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;

public class testVerifyCreateBookingPOST extends BaseTest {
    @Owner("Promode")
    @TmsLink("https://bugz.atlassian.net/jira/software/projects/REQ/boards/1?selectedIssue=REQ-1")
    @Link(name = "Link to TC", url = "https://bugz.atlassian.net/browse/RBT-4")
    @Issue("JIRA_RBT-4")
    @Description("Verify that POST request is working fine.")
    @Test
    public void testVerifyCreateBookingPOST01() {

        requestSpecification
                .basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);

        response =
                RestAssured
                        .given(requestSpecification)
                        .when().body(payloadManager.createPayloadBookingAsString()).post();


        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        //Default Rest Assured - Validation -
        validatableResponse.body("booking.firstname", Matchers.equalTo("James"));


        BookingResponse bookingResponse = payloadManager.bookingResponseJava(response.asString());

        // AssertJ
        // assertActions.verifyStringKey(bookingResponse.getBooking().getFirstname(),"James");
        assertThat(bookingResponse.getBookingid()).isNotNull();
        assertThat(bookingResponse.getBooking().getFirstname()).isNotNull().isNotBlank();
        assertThat(bookingResponse.getBooking().getFirstname()).isEqualTo("James");


        // TestNG Assertions
        assertActions.verifyStatusCode(response, 200);
        assertActions.verifyResponseBody(bookingResponse.getBooking().getFirstname(), "James", "Verify the First Name");
    }
}
