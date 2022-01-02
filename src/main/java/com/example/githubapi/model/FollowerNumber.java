package com.example.githubapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FollowerNumber {

	@JsonProperty("followers")
	private Integer followerCount;

	public Integer getFollowerCount() {
		return followerCount;
	}

	public void setFollowerCount(Integer followerCount) {
		this.followerCount = followerCount;
	}
	
	
}
