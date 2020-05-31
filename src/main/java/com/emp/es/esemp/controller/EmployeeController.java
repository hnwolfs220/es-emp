package com.emp.es.esemp.controller;
/*
 * @Author huangxk
 * @Description：
 * @Date
 **/

import com.emp.es.esemp.dao.EmployeeRepository;
import com.emp.es.esemp.entity.Employee;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("es")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    /**
     * 添加
     * @return
     */
    @RequestMapping("add")
    public String add() {
        Employee employee = new Employee();
        employee.setId("2");
        employee.setFirstName("li");
        employee.setLastName("ming");
        employee.setAge(27);
        employee.setAbout("i am a boy");
        employeeRepository.save(employee);
        System.err.println("add a obj");
        return "success";
    }
    @RequestMapping("addAuto")
    public String addAuto(@RequestParam("id") String id,
                          @RequestParam("firstName") String firstName,
                          @RequestParam("lastName") String lastName,
                          @RequestParam("age") int age,
                          @RequestParam("about") String about) {
        Employee employee = new Employee();
        employee.setId(id);
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setAge(age);
        employee.setAbout(about);
        employeeRepository.save(employee);
        return "sucess";

    }

    /**
     * 删除
     * @return
     */
    @RequestMapping("delete")
    public String delete() {
        Employee employee = employeeRepository.queryEmployeeById("1");
        employeeRepository.delete(employee);
        return "success";
    }

    /**
     * 局部更新
     * @return
     */
    @RequestMapping("update")
    public String update() {
        Employee employee = employeeRepository.queryEmployeeById("1");
        employee.setFirstName("哈哈");
        employeeRepository.save(employee);
        System.err.println("update a obj");
        return "success";
    }
    /**
     * 查询
     * @return
     */
    @RequestMapping("query/{id}")
    public Employee query(@PathVariable String id) {
        Employee accountInfo = employeeRepository.queryEmployeeById(id);
        System.err.println(new Gson().toJson(accountInfo));
        return accountInfo;
    }
}