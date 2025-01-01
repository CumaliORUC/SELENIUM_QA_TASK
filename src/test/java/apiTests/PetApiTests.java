package apiTests;

import com.aventstack.extentreports.ExtentTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import utilities.ExtentReportManager;
import utilities.TestBaseAPI;

import static org.hamcrest.Matchers.equalTo;



public class PetApiTests extends TestBaseAPI {

    private final String BASE_URL = "https://petstore.swagger.io/v2";
    private final long PET_ID = 123456; // Example Pet ID for testing
    Response response;
    ExtentTest extentTest;

    /**
     * Test: Create a Pet (POST /pet)
     */
    @Test
    public void testCreatePetPositive() {
        extentTest= ExtentReportManager.createTest("Create Pet - Positive");

        String petJson = """
                {
                  "id": %d,
                  "name": "Buddy",
                  "status": "available"
                }
                """.formatted(PET_ID);

        response=RestAssured.given()
                .baseUri(BASE_URL)
                .contentType(ContentType.JSON)
                .body(petJson)
                .when()
                .post("/pet");
                response.prettyPrint();

        logResponse(response,extentTest);

        response.then()
                .statusCode(200) // Assert status is 200
                .body("id", equalTo((int) PET_ID)) // Assert the ID matches
                .body("name", equalTo("Buddy")) // Assert the name is correct
                .body("status", equalTo("available")); // Assert the status

    }

    /**
     * Test: Retrieve a Pet by ID (GET /pet/{petId})
     */
    @Test
    public void testGetPetPositive() {
        extentTest= ExtentReportManager.createTest("Get a Pet - Positive");
        RestAssured.given()
                .baseUri(BASE_URL)
                .pathParam("petId", PET_ID)
                .when()
                .get("/pet/{petId}");

        logResponse(response,extentTest);

        response.prettyPrint();
                response.then()
                .statusCode(200)
                .body("id", equalTo((int) PET_ID))
                .body("name", equalTo("Buddy"))
                .body("status", equalTo("available"));
    }

    /**
     * Test: Update a Pet (PUT /pet)
     */


    @Test
    public void testUpdatePetPositive() {
        extentTest= ExtentReportManager.createTest("Update a Pet - Positive");
        String updatedPetJson = """
                {
                  "id": %d,
                  "name": "BuddyUpdated",
                  "status": "sold"
                }
                """.formatted(PET_ID);

        RestAssured.given()
                .baseUri(BASE_URL)
                .contentType(ContentType.JSON)
                .body(updatedPetJson)
                .when()
                .put("/pet")
                .then()
                .statusCode(200)
                .body("id", equalTo((int) PET_ID))
                .body("name", equalTo("BuddyUpdated"))
                .body("status", equalTo("sold"));

        logResponse(response,extentTest);
    }

    /**
     * Test: Delete a Pet (DELETE /pet/{petId})
     */
    @Test
    public void testDeletePetPositive() {

        extentTest= ExtentReportManager.createTest("Delete a Pet - Positive");
        RestAssured.given()
                .baseUri(BASE_URL)
                .pathParam("petId", PET_ID)
                .when()
                .delete("/pet/{petId}")
                .then()
                .statusCode(200)
                .body("message", equalTo(String.valueOf(PET_ID)));
        logResponse(response,extentTest);
    }

    /**
     * Test: Retrieve a Deleted Pet (GET /pet/{petId})
     */
    @Test
    public void testGetPetNegative() {

        extentTest= ExtentReportManager.createTest("GET a Pet - Negative");
        RestAssured.given()
                .baseUri(BASE_URL)
                .pathParam("petId", PET_ID)
                .when()
                .get("/pet/{petId}")
                .then()
                .statusCode(404) // Pet should not exist
                .body("message", equalTo("Pet not found"));
        logResponse(response,extentTest);
    }

    /**
     * Test: Create a Pet with Invalid Data (POST /pet)
     */
    @Test
    public void testCreatePetNegative() {
        extentTest= ExtentReportManager.createTest("Create a Pet - Negative");
        String invalidPetJson = """
                {
                  "id": "",
                  "name": "",
                  "status": "invalidStatus"
                }
                """;

        RestAssured.given()
                .baseUri(BASE_URL)
                .contentType(ContentType.JSON)
                .body(invalidPetJson)
                .when()
                .post("/pet")
                .then()
                .statusCode(400); // Assert that the API rejects invalid data
        logResponse(response,extentTest);
    }
}