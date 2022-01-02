package com.example.githubapi.configuration;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.githubapi.service.GithubProcessor;

@Component
public class CommandLiner implements CommandLineRunner {

	private final GithubProcessor githubProcessor;

	public CommandLiner(GithubProcessor githubProcessor) {
		this.githubProcessor = githubProcessor;
	}

	@Override
	public void run(String... args) throws Exception {

		try {
			githubProcessor.process(args);
		} catch (Exception e) {
			System.err.println("Beklenmedik bir hata olustu" + e);
		}

	}

}
