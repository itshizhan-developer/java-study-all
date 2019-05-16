package com.itshizhan.chapter4.mapper;

import com.itshizhan.chapter4.bean.SysUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public interface UserMapper {
	List<SysUser> selectUserWithIf(SysUser sysUser);

	int updateByIdSelective(SysUser sysUser);

	int insertUserSelective(SysUser sysUser) ;

	SysUser selectByIdOrUserName(SysUser sysUser) ;

	// 根据用户ids 集合批量查询用户
	List<SysUser> selectByIdList(List<Long> idList);

	// 根据用户ids 集合批量查询用户
	List<SysUser> selectByIdList1(ArrayList<Long> idList);

	// 根据用户ids 集合或数字批量查询用户
	List<SysUser> selectByIdList2(Long [] idArray);

	// 根据用户ids 集合或数字批量查询用户
	List<SysUser> selectByIdList3(@Param("list1") List<Long> list1,
																@Param("list2") List<Long> list2);

	//批量插入用户
	int insertUserByList(@Param("userList") List<SysUser> userList);

}
