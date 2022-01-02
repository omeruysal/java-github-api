package com.example.githubapi.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GithubRepo implements Comparable<GithubRepo> {
	private Integer id;
	@JsonProperty("name")
	private String repositoryName;
	@JsonProperty("forks")
	private Long forkQuantity;
	@JsonProperty("html_url")
	private String publicUrl;
	private String description;
	@JsonProperty("contributors_url")
	private String contributorsUrl;

	public GithubRepo() {
	}

	public GithubRepo(Integer id, String repositoryName, Long forkQuantity, String publicUrl, String description,
			String contributorsUrl) {
		super();
		this.id = id;
		this.repositoryName = repositoryName;
		this.forkQuantity = forkQuantity;
		this.publicUrl = publicUrl;
		this.description = description;
		this.contributorsUrl = contributorsUrl;
	}

	@Override
	public String toString() {
		return "GithubRepo [id=" + id + ", repositoryName=" + repositoryName + ", forkQuantity=" + forkQuantity
				+ ", publicUrl=" + publicUrl + ", description=" + description + ", contributorsUrl=" + contributorsUrl
				+ "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContributorsUrl() {
		return contributorsUrl;
	}

	public void setContributorsUrl(String contributorsUrl) {
		this.contributorsUrl = contributorsUrl;
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
	public int hashCode() {
		return Objects.hash(description, forkQuantity, publicUrl, repositoryName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GithubRepo other = (GithubRepo) obj;
		return Objects.equals(description, other.description) && Objects.equals(forkQuantity, other.forkQuantity)
				&& Objects.equals(publicUrl, other.publicUrl) && Objects.equals(repositoryName, other.repositoryName);
	}

	@Override
	public int compareTo(GithubRepo o) {
		if (o.forkQuantity == null)
			return -1;
		return o.forkQuantity.compareTo(this.forkQuantity);
	}

}
