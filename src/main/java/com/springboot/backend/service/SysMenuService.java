package com.springboot.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.springboot.backend.common.R;
import com.springboot.backend.entity.SysMenu;

import java.util.List;

public interface SysMenuService extends IService<SysMenu> {

    public  R<List<SysMenu>> selectMenuList();

    public R<String> createSysMenu(SysMenu sysMenu);

    public R<String> editSysMenu(SysMenu sysMenu);

    public R<String> removeSysMenu(Long id);
}
