package com.example.githubapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RepoNumber {

	@JsonProperty("public_repos")
	private Integer totalRepoCount;

	

	public Integer getTotalRepoCount() {
		return totalRepoCount;
	}



	public void setTotalRepoCount(Integer totalRepoCount) {
		this.totalRepoCount = totalRepoCount;
	}



	@Override
	public String toString() {
		return "RepoNumber [totalRepoCount=" + totalRepoCount + "]";
	}



	
}
