/**
 * Created by leeson8888 on 2018/3/21.
 */
package com.itshizhan.dao;

import com.itshizhan.beans.Employee;

import java.util.List;

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

}
