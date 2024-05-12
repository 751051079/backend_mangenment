package com.springboot.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springboot.backend.common.R;
import com.springboot.backend.entity.SysMenu;
import com.springboot.backend.mapper.SysMenuMapper;
import com.springboot.backend.service.SysMenuService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {

    @Transactional(rollbackFor = Exception.class)
    @Override
    public R<List<SysMenu>> selectMenuList() {

        LambdaQueryWrapper<SysMenu> lambdaQueryWrapper = new LambdaQueryWrapper<>();


        List<SysMenu> list = list(lambdaQueryWrapper);

        return R.success(list);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public R<String> createSysMenu(SysMenu sysMenu) {

        if(sysMenu.getMenuName() == null){
            R.error("请输入菜单名称！");
        }

        LambdaQueryWrapper<SysMenu> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(SysMenu::getMenuName,sysMenu.getMenuName());

        SysMenu sysMenu1 = getOne(lambdaQueryWrapper);

        if(sysMenu1!=null){
            return R.error("菜单名称已存在，请重新输入！");
        }

        save(sysMenu);

        return R.success("新增菜单成功！");
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public R<String> editSysMenu(SysMenu sysMenu) {

        if(sysMenu.getMenuName() == null){
            R.error("请输入菜单名称！");
        }

        LambdaQueryWrapper<SysMenu> lambdaQueryWrapper = new LambdaQueryWrapper<>();

        lambdaQueryWrapper.eq(SysMenu::getMenuName,sysMenu.getMenuName());

        // 添加不等于条件，排除相同 menuId 的记录
        if (sysMenu.getMenuId() != null) {
            lambdaQueryWrapper.ne(SysMenu::getMenuId, sysMenu.getMenuId());
        }

        // 执行查询
        SysMenu menuList = getOne(lambdaQueryWrapper);

        // 如果菜单列表不为空，则存在具有相同名称但不同 menuId 的记录
        if (menuList!=null) {
            return R.error("菜单名称已存在，请重新输入！");
        }

        update(lambdaQueryWrapper);

        return R.success("修改菜单成功！");
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public R<String> removeSysMenu(Long id) {

        removeById(id);

        return R.success("删除成功");
    }


}
