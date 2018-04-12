/**
 * Created by leeson8888 on 2018/3/21.
 */
package com.itshizhan.dao;

import com.itshizhan.beans.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface EmployeeMapper {

   // 查询
   Employee selectEmpoyeeById(Integer id);

   // 添加 ，也可以 public void 不返还
   void insertEmployee(Employee employee);

   // 更新
   void updateEmployee(Employee employee);

   //删除
   void deleteEmployById(Integer id);

   // 增加时 返回自增的ID：方法一
   void   insertEmployeeGetId(Employee employee);
   // 增加时 返回自增的ID：方法二
   void insertEmployeeGetIdTwo(Employee employee);

   // 多个参数：根据部门id和性别查询员工
   List<Employee> selectEmpoyeeByDidAndGender(Integer did,String gender);

   // 多个参数：根据部门id和性别查询员工
   List<Employee> selectEmpoyeeByDidAndGenderPlus(@Param("did1") Integer did, @Param("gender") String gender);

   // 多个参数封装为map
   List<Employee> selectEmpoyeeByMap(Map<String,Object> map);


}
