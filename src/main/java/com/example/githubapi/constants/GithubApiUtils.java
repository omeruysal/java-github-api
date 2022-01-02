package com.example.githubapi.constants;

public class GithubApiUtils {

	public static final Integer PER_PAGE_COUNT = 30;
	public static final String BASED_URL = "https://api.github.com/users/";
	public static final String RESTTEMP_USERNAME= "username";
	public static final String RESTTEMP_PASSWORD= "password";
	public static final String HEADER_REPO= "repo";
	public static final String HEADER_FORKS= "forks";
	public static final String HEADER_URL= "url";
	public static final String HEADER_DESCRIPTION= "description";
	public static final String HEADER_USERNAME= "username";
	public static final String HEADER_CONTRIBUTIONS= "contributions";
	public static final String HEADER_FOLLOWERS= "followers";
	public static final String REPOS_PATH= "_repos";
	public static final String USERS_PATH= "_users";

	public static void exitSystem(String error) {
		System.out.println(error);
		System.exit(1);
	}
}
