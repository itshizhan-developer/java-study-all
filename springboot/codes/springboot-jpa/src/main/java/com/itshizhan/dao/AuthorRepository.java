/**
 * Created by leeson8888 on 2018/12/3.
 */
package com.itshizhan.dao;

import com.itshizhan.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository  extends JpaRepository<Author,Long>{

	List<Author> findByNickNameAndPhone(String nickname,String phone);

}
