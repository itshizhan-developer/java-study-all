/**
 * Created by leeson8888 on 2018/12/3.
 */
package com.itshizhan.service;

import com.itshizhan.domain.Author;


import java.util.List;

public interface AuthorService {

	List<Author> findByNickNameAndPhone(String nickname,String phone);

}
