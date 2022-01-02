package com.example.githubapi.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.githubapi.model.FollowerNumber;
import com.example.githubapi.model.GithubContributor;
import com.example.githubapi.model.GithubRepo;
import com.example.githubapi.model.RepoNumber;
import static com.example.githubapi.constants.GithubApiUtils.BASED_URL;
import static com.example.githubapi.constants.GithubApiUtils.RESTTEMP_PASSWORD;
import static com.example.githubapi.constants.GithubApiUtils.RESTTEMP_USERNAME;

@Service
public class GithubClient {

	Logger logger = LoggerFactory.getLogger(getClass());
	RestTemplate restTemplate;

	GithubClient(RestTemplateBuilder restTemplateBuilder) {
		restTemplate = restTemplateBuilder.basicAuthentication(RESTTEMP_USERNAME, RESTTEMP_PASSWORD).build();
	}

	public Integer getTotalUserRepoCount(String orgName) {
		try {
			ResponseEntity<RepoNumber> json = restTemplate.getForEntity(BASED_URL + orgName, RepoNumber.class);
			if (json != null && json.getBody() != null) {
				logger.info("GithubClient:getTotalUserRepoCount total : " + json.getBody().getTotalRepoCount());
				return json.getBody().getTotalRepoCount();
			}

		} catch (Exception e) {
			logger.error("GithubClient:getTotalUserRepoCount error : ", e);
		}

		return null;

	}

	public List<GithubRepo> getGithubRepos(String orgName, int pageNumber) {

		try {

			ResponseEntity<List<GithubRepo>> responseEntity = restTemplate.exchange(
					BASED_URL + orgName + "/repos?page=" + pageNumber, HttpMethod.GET, null,
					new ParameterizedTypeReference<List<GithubRepo>>() {
					});
			logger.info("GithubClient:getGithubRepos repos : " + responseEntity.getBody());

			return responseEntity.getBody();

		} catch (Exception e) {

			logger.error("GithubClient:getGithubRepos error : ", e);
		}

		return null;
	}

	public List<GithubContributor> getGithubRepoContributors(String url) {

		try {
			ResponseEntity<List<GithubContributor>> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null,
					new ParameterizedTypeReference<List<GithubContributor>>() {
					});
			logger.info("GithubClient:getGithubRepoContributors contributors : " + responseEntity.getBody());

			return responseEntity.getBody();
			
		} catch (Exception e) {

			logger.error("GithubClient:getGithubRepoContributors error : ", e);
		}
		
		return null;

	}

	public Integer getFollowersCount(String orgName) {
		try {
			ResponseEntity<FollowerNumber> followersCount = restTemplate.getForEntity(BASED_URL + orgName,
					FollowerNumber.class);
			logger.info("GithubClient:getFollowersCount follower count : " + followersCount.getBody().getFollowerCount());

			return followersCount.getBody().getFollowerCount();

		} catch (Exception e) {
			logger.error("GithubClient:getFollowersCount error : ", e);
		}

		return null;
	}

}
