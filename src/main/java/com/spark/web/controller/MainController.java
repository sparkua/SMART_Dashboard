package com.spark.web.controller;

import com.spark.dao.MenuDao;
import com.spark.dao.StatisticExtDao;
import com.spark.dao.model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Spark on 1/7/16.
 */
@Controller
public class MainController {

    @Autowired
    private MenuDao menuDao;

    @Autowired
    private StatisticExtDao statisticExtDao;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String IndexEntry (ModelMap model) {

        model.addAttribute("message", "Spring 3 MVC Hello World");
        return "index";

    }

    @RequestMapping(value = "/test/rest", method = RequestMethod.GET)
    @ResponseBody
    public String RestGetTest (ModelMap model) {
        List<Menu> menuList = menuDao.list();
        for (Menu menu : menuList) {
            System.out.println(menu);
        }

        model.addAttribute("message", "Spring 3 MVC Hello World");
        return "index";
    }

}
