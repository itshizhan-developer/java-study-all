package com.itshizhan.configs;

import org.quartz.CronTrigger;
import org.quartz.JobDataMap;
import org.quartz.SimpleTrigger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.*;

@Configuration
public class QuartzConfig {

	@Bean
	MethodInvokingJobDetailFactoryBean jobDetail1(){
		MethodInvokingJobDetailFactoryBean bean = new MethodInvokingJobDetailFactoryBean();
		bean.setTargetBeanName("myFirstQuartzJob");
		bean.setTargetMethod("sayHello");
		return  bean;
	}


	@Bean
	SimpleTriggerFactoryBean simpleTrigger(){
		SimpleTriggerFactoryBean bean = new SimpleTriggerFactoryBean();
		bean.setJobDetail(jobDetail1().getObject());
		bean.setRepeatCount(3);
		bean.setStartDelay(1000);
		bean.setRepeatInterval(3000);
		return bean;
	}

	@Bean
	JobDetailFactoryBean jobDetailFactoryBean(){
		JobDetailFactoryBean bean = new JobDetailFactoryBean();
		bean.setJobClass(MySecondQuartzJob.class);
		JobDataMap jobDataMap = new JobDataMap();
		// 设置 MySecondQuartzJob 类中 name 属性的值
		jobDataMap.put("name","itshizhan");
		bean.setJobDataAsMap(jobDataMap);
		bean.setDurability(true);
		return bean;
	}

	@Bean
	CronTriggerFactoryBean cronTrigger(){
		CronTriggerFactoryBean bean = new CronTriggerFactoryBean();
		bean.setJobDetail(jobDetailFactoryBean().getObject());
		bean.setCronExpression("* * * * * ?");
		return bean;
	}

	@Bean
	SchedulerFactoryBean schedulerFactoryBean(){
		SchedulerFactoryBean bean = new SchedulerFactoryBean();
//		SimpleTrigger simpleTrigger = simpleTrigger().getObject();
//		CronTrigger cronTrigger = cronTrigger().getObject();
//		bean.setTriggers(cronTrigger);
		return  bean;
	}
}
