/**
 * Created by leeson8888 on 2018/9/12.
 */
package com.itshizhan.dao;

import com.itshizhan.entity.Area;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaDaoTest {

	// inspectation=> spring=>core autowired , error=>warning
	@Autowired
	private AreaDao areaDao;

	@Test
	public void queryArea(){
		List<Area> areaList = areaDao.queryArea();
		System.out.println(areaList);
		assertEquals(2,areaList.size());
	}


}
