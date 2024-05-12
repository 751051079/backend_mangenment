package com.springboot.backend.controller;


import com.springboot.backend.common.R;
import com.springboot.backend.entity.SysMenu;
import com.springboot.backend.entity.SysUser;
import com.springboot.backend.service.SysMenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/menu")
public class SysMenuController {

    @Autowired
    private SysMenuService sysMenuService;

    @PostMapping("/list")
    public R<List<SysMenu>> selectMenuList() {
        R<List<SysMenu>> result = sysMenuService.selectMenuList();
        return result;
    }

    @PostMapping("/add")
    public R<String> createMenu(HttpServletRequest request, @RequestBody SysMenu sysMenu) {
        R<String> result = sysMenuService.createSysMenu(sysMenu);
        return result;
    }

    @PostMapping("/edit")
    public R<String> editSysMenu(HttpServletRequest request, @RequestBody SysMenu sysMenu) {
        R<String> result = sysMenuService.editSysMenu(sysMenu);
        return result;
    }

    @GetMapping("/remove")
    public R<String> removeSysMenu(@RequestParam Long id){

        R<String> result = sysMenuService.removeSysMenu(id);

        return result;
    }
}
