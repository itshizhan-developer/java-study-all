package com.itshizhan.controller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BatchController {
	@Autowired
	JobLauncher jobLauncher;

	@Autowired
	Job job;
	@GetMapping("/dobatch")
	public String hello() {
		try {
			JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis())
							.toJobParameters();
			jobLauncher.run(job, jobParameters);
			return "dobatch success";
		} catch (Exception e) {
			e.printStackTrace();
			return "dobatch fail";
		}

	}
}
