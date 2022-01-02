package com.example.githubapi.service;

import static com.example.githubapi.constants.GithubApiUtils.HEADER_CONTRIBUTIONS;
import static com.example.githubapi.constants.GithubApiUtils.HEADER_DESCRIPTION;
import static com.example.githubapi.constants.GithubApiUtils.HEADER_FOLLOWERS;
import static com.example.githubapi.constants.GithubApiUtils.HEADER_FORKS;
import static com.example.githubapi.constants.GithubApiUtils.HEADER_REPO;
import static com.example.githubapi.constants.GithubApiUtils.HEADER_URL;
import static com.example.githubapi.constants.GithubApiUtils.HEADER_USERNAME;
import static com.example.githubapi.constants.GithubApiUtils.REPOS_PATH;
import static com.example.githubapi.constants.GithubApiUtils.USERS_PATH;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import com.example.githubapi.dto.GithubApiResponse;
import com.opencsv.CSVWriter;

@Service
public class CsvService {
	public void generateRepoCsv(GithubApiResponse list, String orgName) {
		if (CollectionUtils.isEmpty(list.getGithubRepoDtos())) {
			return;
		}
		String path = orgName + REPOS_PATH;
		String[] headerForGithubRepoDto = { HEADER_REPO, HEADER_FORKS, HEADER_URL, HEADER_DESCRIPTION };

		List<String[]> csvDataForRepo = new ArrayList<>();

		csvDataForRepo.add(headerForGithubRepoDto);
		list.getGithubRepoDtos().forEach(repo -> {
			String[] temp = { repo.getRepositoryName(), repo.getForkQuantity().toString(), repo.getPublicUrl(),
					repo.getDescription() };
			csvDataForRepo.add(temp);
		});

		writeIntoCsv(csvDataForRepo, path);
	}

	public void generateContributorCsv(GithubApiResponse list, String orgName) {
		if (CollectionUtils.isEmpty(list.getContributorDtos())) {
			return;
		}
		String path = orgName + USERS_PATH;
		String[] headerForGithubContributorDto = { HEADER_REPO, HEADER_USERNAME, HEADER_CONTRIBUTIONS,
				HEADER_FOLLOWERS };

		List<String[]> csvDataForContribution = new ArrayList<>();
		csvDataForContribution.add(headerForGithubContributorDto);
		list.getContributorDtos().forEach(cont -> {
			String[] temp = { cont.getRepositoryName(), cont.getUsername(), cont.getContributorsQuantity().toString(),
					cont.getFollowerQuantity().toString() };
			csvDataForContribution.add(temp);
		});

		writeIntoCsv(csvDataForContribution, path);

	}

	public void writeIntoCsv(List<String[]> csvDataForContribution, String path) {
		try (CSVWriter writer = new CSVWriter(new FileWriter(System.getProperty("user.home") + "\\Desktop\\" + path + ".csv"))) {
			
			writer.writeAll(csvDataForContribution);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
