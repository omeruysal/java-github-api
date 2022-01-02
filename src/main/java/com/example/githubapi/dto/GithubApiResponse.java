package com.example.githubapi.dto;

import java.util.List;

public class GithubApiResponse {
	private List<GithubRepoDto> githubRepoDtos;
	private List<GithubContributorDto> contributorDtos;

	public GithubApiResponse() {
	}

	@Override
	public String toString() {
		return "GithubApiResponse [githubRepoDtos=" + githubRepoDtos + ", contributorDtos=" + contributorDtos + "]";
	}

	public GithubApiResponse(List<GithubRepoDto> githubRepoDtos, List<GithubContributorDto> contributorDtos) {
		this.githubRepoDtos = githubRepoDtos;
		this.contributorDtos = contributorDtos;
	}

	public List<GithubRepoDto> getGithubRepoDtos() {
		return githubRepoDtos;
	}

	public void setGithubRepoDtos(List<GithubRepoDto> githubRepoDtos) {
		this.githubRepoDtos = githubRepoDtos;
	}

	public List<GithubContributorDto> getContributorDtos() {
		return contributorDtos;
	}

	public void setContributorDtos(List<GithubContributorDto> contributorDtos) {
		this.contributorDtos = contributorDtos;
	}

}
