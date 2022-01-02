package com.example.githubapi.service;

import static com.example.githubapi.constants.GithubApiUtils.PER_PAGE_COUNT;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import com.example.githubapi.dto.GithubApiResponse;
import com.example.githubapi.dto.GithubContributorDto;
import com.example.githubapi.dto.GithubRepoDto;
import com.example.githubapi.model.GithubContributor;
import com.example.githubapi.model.GithubRepo;;

@Service
public class GithubService {

	final GithubClient client;

	public GithubService(GithubClient client) {
		this.client = client;
	}

	public GithubApiResponse getGithubApiResponse(String orgName, Integer reposNumber, Integer contributorLimit) {
		List<GithubRepo> githubRepoList = new ArrayList<>();
		Integer totalRepoCount = client.getTotalUserRepoCount(orgName);

		if (totalRepoCount == null || totalRepoCount.compareTo(0) == 0) {
			return null;
		}

		for (int i = 0; i <= totalRepoCount / PER_PAGE_COUNT; i++) { // tum repolari cekeriz
			githubRepoList.addAll(client.getGithubRepos(orgName, i + 1));
		}

		if (CollectionUtils.isEmpty(githubRepoList)) {
			return null;
		}

		Collections.sort(githubRepoList);// siralama

		List<GithubRepoDto> sortedGithubRepoDtoList = new ArrayList<>();
		List<GithubContributorDto> githubContributorList = new ArrayList<>();

		int limit = reposNumber > githubRepoList.size() ? githubRepoList.size() : reposNumber;
		for (int i = 0; i < limit; i++) {
			GithubRepo currentRepo = githubRepoList.get(i);

			sortedGithubRepoDtoList.add(new GithubRepoDto(currentRepo.getRepositoryName(),
					currentRepo.getForkQuantity(), currentRepo.getPublicUrl(), currentRepo.getDescription()));
			List<GithubContributorDto> githubContributor = getGithubContributor(currentRepo.getContributorsUrl(),
					currentRepo.getRepositoryName(), contributorLimit);
			if (!CollectionUtils.isEmpty(githubContributor)) {
				githubContributorList.addAll(githubContributor);
			}

		}

		GithubApiResponse response = new GithubApiResponse(sortedGithubRepoDtoList, githubContributorList);

		return response;
	}

	public List<GithubContributorDto> getGithubContributor(String contributorsUrl, String repoName,
			Integer contributorLimit) {
		List<GithubContributor> githubContributorList = new ArrayList<>();

		githubContributorList = client.getGithubRepoContributors(contributorsUrl);

		if (githubContributorList == null || githubContributorList.size() == 0) {

			return null;
		}

		Collections.sort(githubContributorList);

		List<GithubContributorDto> sortedGithubContributorList = new ArrayList<>();
		int limit = contributorLimit > githubContributorList.size() ? githubContributorList.size() : contributorLimit;
		for (int i = 0; i < limit; i++) {

			GithubContributorDto dto = new GithubContributorDto();
			GithubContributor githubContributor = githubContributorList.get(i);
			Integer followersCount = client.getFollowersCount(githubContributor.getLogin());
			dto.setFollowerQuantity(followersCount != null ? followersCount : 0); // followers count
			dto.setRepositoryName(repoName); // repository name
			dto.setUsername(githubContributor.getLogin()); // username
			dto.setContributorsQuantity(githubContributor.getContributions()); // contributions

			sortedGithubContributorList.add(dto);

		}

		return sortedGithubContributorList;
	}

}
