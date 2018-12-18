package com.itheima.spring_bootcrud.dao;

import com.itheima.spring_bootcrud.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by 1111111 on 2018/8/27.
 */
@Repository
public class DepartmentDao {

    private Department department = new Department(1,"经理");
    private Department department1 = new Department(4,"文员");
    private Department department2 = new Department(3,"主任");
    private Department department3 = new Department(2,"员工");
    public List<Department> findDepartment(){
        List list = new ArrayList();

        list.add(department);
        list.add(department2);
        list.add(department3);
        list.add(department1);
        return list;
    }


}
