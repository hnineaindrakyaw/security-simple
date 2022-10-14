package com.example.springsecuritymaster.controller;

import com.example.springsecuritymaster.dao.DepartmentDao;
import com.example.springsecuritymaster.ds.Department;
import com.example.springsecuritymaster.security.annotation.departments.IsDepartmentCreate;
import com.example.springsecuritymaster.security.annotation.departments.IsDepartmentDelete;
import com.example.springsecuritymaster.security.annotation.departments.IsDepartmentRead;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class DepartmentController {
    @Autowired
    private DepartmentDao departmentDao;
@IsDepartmentRead
    @GetMapping("/departments")
    public ModelAndView listEmployees(){
        return  new ModelAndView(
                "departments","departments",departmentDao.findAll()
        );
    }
    @IsDepartmentCreate
    @GetMapping("/create-department")
    public  String createDepartment(Model model){
        model.addAttribute("department",new Department());
        return "departments-form";



    }
  @IsDepartmentCreate
    @PostMapping("/create-department")
    public  String saveDepartment(@Valid Department department, BindingResult result){
        if(result.hasErrors()){
            return "departments-form";
        }
        departmentDao.save(department);
        return  "redirect:/departments";
    }
   @IsDepartmentDelete
    @GetMapping("/departments/delete")
    public  String deleteDepartment(@RequestParam("id") int id){
       departmentDao.deleteById(id);
        return  "redirect:/departments";
    }


}
