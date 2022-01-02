package com.example.githubapi.service;

import org.springframework.stereotype.Service;

import com.example.githubapi.constants.GithubApiUtils;
import com.example.githubapi.dto.GithubApiResponse;
import com.example.githubapi.model.GithubApiRequest;

@Service
public class GithubProcessor {
	final GithubService githubService;
	final ValidationService validationService;
	final CsvService csvService;

	public GithubProcessor(GithubService githubService, ValidationService validationService, CsvService csvService) {
		this.githubService = githubService;
		this.validationService = validationService;
		this.csvService = csvService;
	}

	public void process(String... args) {
		GithubApiRequest request = validationService.validateAndReturnValues(args);

		GithubApiResponse response = githubService.getGithubApiResponse(request.getRepoName(), request.getRepoNumber(),
				request.getContributionCount());

		if (response != null) {
			csvService.generateRepoCsv(response, request.getRepoName());

			csvService.generateContributorCsv(response, request.getRepoName());
		} else {
			GithubApiUtils.exitSystem("Repository bulunamadi.");
		}
	}
}
