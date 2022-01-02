package com.example.githubapi.dto;

public class GithubContributorDto {

	private String username;
	private String repositoryName;
	private Integer contributorsQuantity;
	private Integer followerQuantity;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRepositoryName() {
		return repositoryName;
	}
	public void setRepositoryName(String repositoryName) {
		this.repositoryName = repositoryName;
	}
	public Integer getContributorsQuantity() {
		return contributorsQuantity;
	}
	public void setContributorsQuantity(Integer contributorsQuantity) {
		this.contributorsQuantity = contributorsQuantity;
	}
	public Integer getFollowerQuantity() {
		return followerQuantity;
	}
	public void setFollowerQuantity(Integer followerQuantity) {
		this.followerQuantity = followerQuantity;
	}
	@Override
	public String toString() {
		return "GithubContributorDto [username=" + username + ", repositoryName=" + repositoryName
				+ ", contributorsQuantity=" + contributorsQuantity + ", followerQuantity=" + followerQuantity + "]";
	}
	
	
}
