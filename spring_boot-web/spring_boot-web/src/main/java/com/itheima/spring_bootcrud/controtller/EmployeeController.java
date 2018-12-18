package com.itheima.spring_bootcrud.controtller;

import com.itheima.spring_bootcrud.dao.DepartmentDao;
import com.itheima.spring_bootcrud.dao.EmployeeDao;
import com.itheima.spring_bootcrud.pojo.Department;
import com.itheima.spring_bootcrud.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by 1111111 on 2018/8/27.
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {


    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;

    @GetMapping("/findList")
    public String findList(Map<String,Object> map){

        List<Employee> list = employeeDao.findList();

        map.put("emps",list);

        return "empList";
    }

    @GetMapping("/emp")
    public String findDepartment(Model model){

        List<Department> departments = departmentDao.findDepartment();
        model.addAttribute("departments",departments);
        return "add";
    }

    @PostMapping("/emp")
    public String  addEmployee(Employee employee){

        System.out.println(employee);

        List<Employee> list = employeeDao.findList();
        list.add(employee);
        return "redirect:/employee/findList";
    }

    @GetMapping("/emp/{id}")
    public String findOneEmployee(@PathVariable("id") Integer id,Model model ){


        List<Employee> list = employeeDao.findList();

        Employee employee = list.get(id-1);

        model.addAttribute("emp",employee);
        List<Department> departments = departmentDao.findDepartment();
        model.addAttribute("departments",departments);

        return "add";
    }

    @PutMapping("/emp")
    public String updateEmployee(Employee employee){

        employeeDao.updateEmployee(employee);

        return "redirect:/employee/findList";
    }


    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){

        employeeDao.deleEmployee(id);
        return "redirect:/employee/findList";
    }

}
