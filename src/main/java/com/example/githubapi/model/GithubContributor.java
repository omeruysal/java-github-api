package com.example.githubapi.model;

public class GithubContributor implements Comparable<GithubContributor> {

	private String followers_url;
	private Integer contributions;
	private String login;

	public GithubContributor() {
	}

	

	@Override
	public String toString() {
		return "GithubContributor [followers_url=" + followers_url + ", contributions=" + contributions + "]";
	}
	

	
	public String getLogin() {
		return login;
	}



	public void setLogin(String login) {
		this.login = login;
	}



	public String getFollowers_url() {
		return followers_url;
	}

	public void setFollowers_url(String followers_url) {
		this.followers_url = followers_url;
	}

	public Integer getContributions() {
		return contributions;
	}

	public void setContributions(Integer contributions) {
		this.contributions = contributions;
	}

	@Override
	public int compareTo(GithubContributor o) {

		if (o.contributions == null)
			return -1;
		return o.contributions.compareTo(this.contributions);
	}

}
