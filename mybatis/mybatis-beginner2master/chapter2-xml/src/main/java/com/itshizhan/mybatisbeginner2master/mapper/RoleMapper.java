package com.itshizhan.mybatisbeginner2master.mapper;

import com.itshizhan.mybatisbeginner2master.bean.SysRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface RoleMapper {
	List<SysRole> selectRolesByUserIdAndRoleEnabled(Long userId, Integer enabled);
	List<SysRole> selectRolesByUserIdAndRoleEnabled1(Map map);

	List<SysRole> selectRolesByUserIdAndRoleEnabled2(@Param("userId") Long id,
																									 @Param("enabled") Integer enabled);
}
