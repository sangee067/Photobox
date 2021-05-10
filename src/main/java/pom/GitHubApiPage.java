package pom;

import com.jayway.restassured.response.Response;

import static com.jayway.restassured.RestAssured.given;

public class GitHubApiPage {

    private String uri = "https://api.github.com/users/";
    private Response response;

    protected Response getRequestForUserDetailsList(String username) {
        return response = given().
                    when().
                        get(uri + username).
                    then().
                        statusCode(200).
                    extract().
                        response();
    }

    protected boolean verifyNamePropertyMatchesWithUsername(String username) {
        System.out.println(" Response :: " + response.getBody().prettyPrint());
        System.out.println(" Name property value :: " + response.path("name"));
        return (response.path("name").toString().equalsIgnoreCase(username));
    }
}
