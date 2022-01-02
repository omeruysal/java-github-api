package com.example.githubapi.dto;

public class GithubRepoDto {

	private String repositoryName;
	private Long forkQuantity;
	private String publicUrl;
	private String description;
	
	
	public GithubRepoDto() {
	}
	
	
	public GithubRepoDto(String repositoryName, Long forkQuantity, String publicUrl, String description) {
		super();
		this.repositoryName = repositoryName;
		this.forkQuantity = forkQuantity;
		this.publicUrl = publicUrl;
		this.description = description;
	}


	public String getRepositoryName() {
		return repositoryName;
	}
	public void setRepositoryName(String repositoryName) {
		this.repositoryName = repositoryName;
	}
	public Long getForkQuantity() {
		return forkQuantity;
	}
	public void setForkQuantity(Long forkQuantity) {
		this.forkQuantity = forkQuantity;
	}
	public String getPublicUrl() {
		return publicUrl;
	}
	public void setPublicUrl(String publicUrl) {
		this.publicUrl = publicUrl;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}


	@Override
	public String toString() {
		return "GithubRepoDto [repositoryName=" + repositoryName + ", forkQuantity=" + forkQuantity + ", publicUrl="
				+ publicUrl + ", description=" + description + "]";
	}
	
	
	
}
