package com.zhongruan.web;

import com.zhongruan.bean.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(StudentControllerPage2.BASE_CONTROLLER)
public class StudentControllerPage2 {
    // 字符串常量的提取
    public static final String BASE_CONTROLLER = "/studentControllerPage2";
    public static final String INDEX_PAGE = "../index.jsp";


    @RequestMapping("/getData")
    public String getData(HttpServletRequest request, Model m, ModelMap mm ,
                          @ModelAttribute("stu1") Student stu1,
                          @ModelAttribute("sex") Integer sex){

        // 1. 直接借用ServletAPI实现模拟数据响应
//        request.setAttribute("name1", "xiaoming1");
//        request.getSession().setAttribute("name2","xiaoming2");

        // 2. 借助ModelAndView 对象实现数据响应
//        ModelAndView mv = new ModelAndView();
//        mv.setViewName(INDEX_PAGE);
//        mv.addObject("s1",new Student(3,"隔壁老王","18"));


        // 3. 借用Model 和 ModelMap 实现响应 ： 可以理解为从ModelAndView 拆分过来的
        m.addAttribute("name3","小花");
        mm.addAttribute("name4","汪东城");
        mm.put("name5","小白脸");


        //4.可以用注解：@ModelAttribute
        //方法形参的相应方式：引用数据可以实现，但是基本 类型只能相应原本的参数
        stu1.setId(2);
        stu1.setStuName("老王");

        sex=18;


        return INDEX_PAGE;
    }



    //5.数据响应：通过返回值直接相应数据到客户端，无需相应视图
    //406:(Not Acceptable):服务器错误，表示去响应数据的时候，格式无法正常转换
    @RequestMapping("/geData2")
    @ResponseBody
    public String getData2() {
        //如果是针对当前客户端的ajax请求，需要给与数据响应

        //1.直接响应字符串
//        return "Java是世界上最好的语言";

        //2.直接响应引用对象
//        Student stu1=new Student(2,"隔壁老王","18");
//        return stu1;

        //3.直接响应集合
//        Student stu1 = new Student(2, "隔壁老王", "18");
//        Student stu2 = new Student(3, "隔壁老旭", "18");
//        Student stu3 = new Student(4, "隔壁老陈", "18");
//        List list = new ArrayList();
//        list.add(stu1);
//        list.add(stu2);
//        list.add(stu3);
//        return list;

        //4.直接响应JSON字符串
        String jsonStr="{\"id\":2,\"stuName\":\"隔壁老沈\",\"age\":\"20\"}";
        return jsonStr;


    }







}
