package com.itshizhan.configs;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MySecondQuartzJob extends QuartzJobBean {
	private String name;

	public void setName(String name) {
		this.name = name;
	}

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		System.out.println("hello:" + name + ":" + new Date());
	}

}
