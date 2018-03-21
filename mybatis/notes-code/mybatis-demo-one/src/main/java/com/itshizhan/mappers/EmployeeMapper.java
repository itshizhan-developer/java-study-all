/**
 * Created by leeson8888 on 2018/3/21.
 */
package com.itshizhan.mappers;

import com.itshizhan.beans.Employee;

public interface EmployeeMapper {

   Employee selectEmpoyeeById(Integer id);
   int insertEmployee(Employee employee);

}
