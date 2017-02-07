package com.itmuch.cloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/1/16.
 */
@RestController
public class RibbonHystrixController {

    @Autowired
    private RibbonHistrixService ribbonHistrixService;

    @GetMapping("/ribbon/{id}")
    public User findById(@PathVariable Long id) {
        return ribbonHistrixService.findById(id);
    }
}
