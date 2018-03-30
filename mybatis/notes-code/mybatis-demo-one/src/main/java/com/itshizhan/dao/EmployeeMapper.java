/**
 * Created by leeson8888 on 2018/3/21.
 */
package com.itshizhan.dao;

import com.itshizhan.beans.Employee;

import java.util.List;

public interface EmployeeMapper {

   Employee selectEmpoyeeById(Integer id);

   int insertEmployee(Employee employee);

   List<Employee> selectEmployeeLikeName(String gender, String lastName);

   List<Employee> selectEmployeeLikeNamePlus(String gender);

}
