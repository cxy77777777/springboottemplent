package com.lvgu.industrynew.controller.sys;

import com.lvgu.industrynew.entity.SysUserEntity;
import com.lvgu.industrynew.utils.SpringSecurityUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import com.lvgu.industrynew.comments.Constant;
import com.lvgu.industrynew.comments.PageData;
import com.lvgu.industrynew.domain.Result;
import com.lvgu.industrynew.dto.SysUserRoleDTO;
import com.lvgu.industrynew.service.ISysUserRoleService;
import com.lvgu.industrynew.utils.BeanUtilss;
import com.lvgu.industrynew.utils.RedisCache;

import java.util.Map;


/**
 * 用户角色表
 *
 * @author fyh 731530116@qq.com
 * @since 1.0.0 2023-08-10
 */
@RestController
@RequestMapping("v1/api/sysuserrole")
@Api(tags="用户角色表")
public class SysUserRoleController {
    @Autowired
    private ISysUserRoleService sysUserRoleService;
    @Autowired
    private RedisCache redisCache;

    @PostMapping("page")
    @ApiOperation("分页")
    @ApiImplicitParams({
        @ApiImplicitParam(name = Constant.PAGE, value = "当前页码，从1开始", paramType = "query", required = true, dataType="int") ,
        @ApiImplicitParam(name = Constant.LIMIT, value = "每页显示记录数", paramType = "query",required = true, dataType="int") ,
        @ApiImplicitParam(name = Constant.ORDER_FIELD, value = "排序字段", paramType = "query", dataType="String") ,
        @ApiImplicitParam(name = Constant.ORDER, value = "排序方式，可选值(asc、desc)", paramType = "query", dataType="String")
    })
    public Result page(@RequestBody Map<String, Object> params){
        try {
            PageData<SysUserRoleDTO> page = sysUserRoleService.page(params);
            return new Result().ok(page);
        }catch (Exception e){
            e.printStackTrace();
            return new Result().error("查询列表失败！");
        }
    }

    @GetMapping("getById")
    @ApiOperation("信息")
    public Result getById(@RequestParam("id") String id){
        try {
            SysUserRoleDTO data = sysUserRoleService.get(id);
            return new Result().ok(data);
        }catch (Exception e){
            e.printStackTrace();
            return new Result().error("查询详情失败！");
        }
    }

    @PostMapping("save")
    @ApiOperation("保存")
    public Result save(@RequestBody SysUserRoleDTO dto, HttpServletRequest request){
        try {
            SysUserEntity user = SpringSecurityUtils.getUserInfo().getUserEntity();
            BeanUtilss.setBasValue(dto,user);
            sysUserRoleService.save(dto);
            return new Result().ok("保存成功！");
        }catch (Exception e){
            e.printStackTrace();
            return new Result().error("保存失败！");
        }
    }

    @PostMapping("update")
    @ApiOperation("修改")
    public Result update(@RequestBody SysUserRoleDTO dto, HttpServletRequest request){
        try {
            SysUserEntity user = SpringSecurityUtils.getUserInfo().getUserEntity();
            BeanUtilss.updateBasValue(dto,user);
            sysUserRoleService.update(dto);
            return new Result().ok("修改成功！");
        }catch (Exception e){
            e.printStackTrace();
            return new Result().error("修改失败！");
        }
    }

    @GetMapping("deletedById")
    @ApiOperation("删除")
    public Result deletedById(@RequestParam("id") String id){
        try {
            String[]ids = new String[]{id};
            sysUserRoleService.delete(ids);
            return new Result().ok("删除成功！");
        }catch (Exception e){
            e.printStackTrace();
            return new Result().error("删除失败！");
        }
    }
}