
package com.github.kazuma1989.sbms.index.controller;

import com.github.kazuma1989.sbms.index.service.IndexService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    IndexService service;

    @GetMapping("/")
    public String index() {
        service.testAccess();

        return "index";
    }
}
