/**
 * Created by leeson8888 on 2018/12/4.
 */
package com.itshizhan;


import com.alibaba.fastjson.JSON;
import com.itshizhan.dao.AuthorRepository;
import com.itshizhan.domain.Author;
import com.itshizhan.service.AuthorService;
import com.utils.LogUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthorTests {


	@Autowired
	AuthorRepository authorRepository;


	@Autowired
	AuthorService authorService;

	@Test
	public void saveAuthorTest(){
		Author author = new Author();
		author.setNickName("author02");
		author.setPhone("138181810002");
		author.setSignDate(new Date());
		authorRepository.save(author);
	}

	@Test
	public void findNicknameAndPhoneTest(){
		List<Author> authorList = authorService.findByNickNameAndPhone("author01","138181810001");

		//System.out.println(JSON.toJSONString(authorList));
		LogUtil.logJson(authorList);

	}
}
