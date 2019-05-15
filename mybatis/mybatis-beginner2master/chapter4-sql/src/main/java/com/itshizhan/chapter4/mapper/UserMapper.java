package com.itshizhan.chapter4.mapper;

import com.itshizhan.chapter4.bean.SysUser;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserMapper {
	List<SysUser> selectUserWithIf(SysUser sysUser);

	int updateByIdSelective(SysUser sysUser) ;
}
