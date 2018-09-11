/**
 * Created by leeson8888 on 2018/9/10.
 */
package com.itshizhan;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/tvseries")
public class TvSeriesController {

	private  Log log = LogFactory.getLog(TvSeriesDto.class);

	@GetMapping
	public Map<String,Object> sayHello(){

		log.info("sayHello() 方法调用了");

		Map<String,Object> map = new HashMap<>();
		map.put("code",1);
		map.put("msg","success");

		List<TvSeriesDto> list = new ArrayList<>();
		Calendar c = Calendar.getInstance();
		c.set(2006,Calendar.OCTOBER,1,0,0,0);
		list.add(new TvSeriesDto(1,"大明王朝1566",c.getTime()));
		list.add(new TvSeriesDto(2,"康熙大帝",c.getTime()));

		map.put("data",list);

		return  map;
	}
}
