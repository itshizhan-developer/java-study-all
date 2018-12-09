/**
 * Created by leeson8888 on 2018/12/4.
 */
package com.itshizhan.service;

import com.itshizhan.dao.AuthorRepository;
import com.itshizhan.domain.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl  implements AuthorService{

	@Autowired
	AuthorRepository authorRepository;

	@Override
	public List<Author> findByNickNameAndPhone(String nickname, String phone) {
		return authorRepository.findByNickNameAndPhone(nickname,phone);
	}
}
