package api.endpoints;

public class BaseURLs {
	//Base Url
	public static final String BASE_URL="https://petstore.swagger.io/v2";
	
	//Target url for user flow
	public static final String CREATE_USER_URL=BASE_URL+"/user";
	public static final String GET_USER_URL=BASE_URL+"/user/{username}";
	public static final String UPDATE_USER_URL=BASE_URL+"/user/{username}";
	public static final String DELETE_USER_URL=BASE_URL+"/user/{username}";
	
	//Target url for store flow
	
	//Target url for pet flow
	
	//Test Json PlaceHolder
	public static final String JSON_URL="https://jsonplaceholder.typicode.com";
	
	public static final String JSON_CREATE=JSON_URL+"/posts";
	public static final String JSON_GET=JSON_URL+"/posts/{id}";
	public static final String JSON_UPDATE=JSON_URL+"/posts/{id}";
	public static final String JSON_DELETE=JSON_URL+"/posts/{id}";
	
	
	
}
