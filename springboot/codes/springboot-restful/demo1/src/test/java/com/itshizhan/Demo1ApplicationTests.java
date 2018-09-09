package com.itshizhan;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo1ApplicationTests {

	@Test
	public void contextLoads() {

	}

	@Test
	public void testDate(){
		System.out.println("-----------------testDate-------------------------------");
		/*
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd E HH:mm:ss a");
		Date date = new Date();

		String time = sdf.format(date);
		System.out.println(time);

		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String str = "2008/08/08 20:08:08";
		Date date1 = null;
		try {
			date1 = sdf1.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println(date1);
		*/
		Calendar calendar = Calendar.getInstance();
		//设置年
		calendar.set(Calendar.YEAR, 2008);
		//设置月
		calendar.set(Calendar.MONTH, 7);
		//设置日
		calendar.set(Calendar.DAY_OF_MONTH, 8);
		//设置时分秒此处略去
		//calendar.set(2008, 7, 8, 20, 8, 8);//一次性设置的语句
		System.out.println(calendar);
		String time = new SimpleDateFormat("yyy-MM-dd HH:mm:ss E").format(calendar.getTime());
		System.out.println(time);

	}

}
