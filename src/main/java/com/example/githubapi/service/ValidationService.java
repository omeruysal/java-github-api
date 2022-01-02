package com.example.githubapi.service;

import static com.example.githubapi.constants.GithubApiUtils.exitSystem;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.example.githubapi.model.GithubApiRequest;

@Service
public class ValidationService {

	public GithubApiRequest validateAndReturnValues(String... args) {
		for (String arg : args) {
			if (StringUtils.isEmpty(arg)) {
				exitSystem("Geçerli bir değer giriniz.");
			}
		}

		String orgName = args[0];

		Integer repoNumber = getIntArg(args[1]);
		if (repoNumber == null) {
			exitSystem("Lutfen repo number icin numeric bir deger giriniz.");
		}

		if (repoNumber < 1) {
			exitSystem("Lutfen repo number icin sifirdan buyuk bir deger giriniz.");
		}

		Integer contributorNumber = getIntArg(args[2]);
		if (contributorNumber == null) {
			exitSystem("Lutfen contributor number icin numeric bir deger giriniz.");
		}

		if (contributorNumber < 1) {
			exitSystem("Lutfen contributor number icin sifirdan buyuk bir deger giriniz.");
		}

		return new GithubApiRequest(orgName, repoNumber, contributorNumber);
	}

	private Integer getIntArg(String intArg) {
		try {
			return Integer.valueOf(intArg);
		} catch (Exception e) {
			return null;
		}
	}

}
