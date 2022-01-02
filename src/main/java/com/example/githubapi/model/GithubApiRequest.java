package com.example.githubapi.model;

public class GithubApiRequest {
	private String repoName;
	private Integer repoNumber;
	private Integer contributionCount;

	public GithubApiRequest() {
	}

	public GithubApiRequest(String repoName, Integer repoNumber, Integer contributionCount) {
		this.repoName = repoName;
		this.repoNumber = repoNumber;
		this.contributionCount = contributionCount;
	}

	public String getRepoName() {
		return repoName;
	}

	public void setRepoName(String repoName) {
		this.repoName = repoName;
	}

	public Integer getRepoNumber() {
		return repoNumber;
	}

	public void setRepoNumber(Integer repoNumber) {
		this.repoNumber = repoNumber;
	}

	public Integer getContributionCount() {
		return contributionCount;
	}

	public void setContributionCount(Integer contributionCount) {
		this.contributionCount = contributionCount;
	}

}
