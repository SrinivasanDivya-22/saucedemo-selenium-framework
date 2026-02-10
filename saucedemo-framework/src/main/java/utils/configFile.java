package utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class configFile {

	private static JsonNode jsonData;
static {
		if (jsonData == null) {
            try {
                ObjectMapper mapper = new ObjectMapper();

                String path = System.getProperty("user.dir")
                        + "/src/test/resources/testData/testData.json";

                System.out.println("Loading JSON from: " + path);

                byte[] jsonBytes = Files.readAllBytes(Paths.get(path));
                jsonData = mapper.readTree(jsonBytes);

            } catch (IOException e) {
                throw new RuntimeException("❌ Failed to load testData.json", e);
            }
        }
}

	public static String getUsername() 
	{
		return jsonData.get("login").get("username").asText();
	}
	public static String getPassword()
	{
		return jsonData.get("login").get("password").asText();
	}
	
	public static String getinvalidUsername() 
	{
		return jsonData.get("loginInvalid").get("username").asText();
	}
	public static String getinvalidPassword()
	{
		return jsonData.get("loginInvalid").get("password").asText();
	}
	
	public static String getFirstName() {
		return jsonData.get("checkout").get("firstName").asText();
	}

	public static String getLastName() {
		return jsonData.get("checkout").get("lastName").asText();
	}

	public static String getPostalCode() {
		return jsonData.get("checkout").get("postalCode").asText();
	}

}

