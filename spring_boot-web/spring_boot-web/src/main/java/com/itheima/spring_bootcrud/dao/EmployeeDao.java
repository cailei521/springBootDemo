package com.itheima.spring_bootcrud.dao;

import com.itheima.spring_bootcrud.pojo.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 1111111 on 2018/8/27.
 */
@Repository
public class EmployeeDao {


     private static final List list;


    static {
        Employee employee = new Employee(1,"张三","qq.com",1,2);
        Employee employee2 = new Employee(2,"张三1","qq.com",1,2);
        Employee employee3 = new Employee(3,"张三2","qq.com",0,2);
        Employee employee4 = new Employee(4,"张三3","qq.com",0,2);
        list = new ArrayList();;

        list.add(employee);
        list.add(employee4);
        list.add(employee2);
        list.add(employee3);
    }

    public List<Employee> findList(){

        return list;

    }

    public void  save(Employee employee1){

            list.add(employee1);

    }

    public void updateEmployee(Employee employeex){



        Employee o = (Employee) list.get(employeex.getdId()-1);
        o.setGender(employeex.getGender());
        o.setLastName(employeex.getLastName());
        o.setEmail(employeex.getEmail());
    }


    public void deleEmployee(Integer id){


        list.remove(id - 1);
    }

}


