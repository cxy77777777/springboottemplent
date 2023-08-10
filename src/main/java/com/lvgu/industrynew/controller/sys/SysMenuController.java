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
import com.lvgu.industrynew.dto.SysMenuDTO;
import com.lvgu.industrynew.service.ISysMenuService;
import com.lvgu.industrynew.utils.BeanUtilss;
import com.lvgu.industrynew.utils.RedisCache;

import java.util.Map;


/**
 * 菜单
 *
 * @author fyh 731530116@qq.com
 * @since 1.0.0 2023-08-10
 */
@RestController
@RequestMapping("v1/api/sysmenu")
@Api(tags="菜单")
public class SysMenuController {
    @Autowired
    private ISysMenuService sysMenuService;
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
            PageData<SysMenuDTO> page = sysMenuService.page(params);
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
            SysMenuDTO data = sysMenuService.get(id);
            return new Result().ok(data);
        }catch (Exception e){
            e.printStackTrace();
            return new Result().error("查询详情失败！");
        }
    }

    @PostMapping("save")
    @ApiOperation("保存")
    public Result save(@RequestBody SysMenuDTO dto, HttpServletRequest request){
        try {
            SysUserEntity user = SpringSecurityUtils.getUserInfo().getUserEntity();
            BeanUtilss.setBasValue(dto,user);
            sysMenuService.save(dto);
            return new Result().ok("保存成功！");
        }catch (Exception e){
            e.printStackTrace();
            return new Result().error("保存失败！");
        }
    }

    @PostMapping("update")
    @ApiOperation("修改")
    public Result update(@RequestBody SysMenuDTO dto, HttpServletRequest request){
        try {
            SysUserEntity user = SpringSecurityUtils.getUserInfo().getUserEntity();
            BeanUtilss.updateBasValue(dto,user);
            sysMenuService.update(dto);
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
            sysMenuService.delete(ids);
            return new Result().ok("删除成功！");
        }catch (Exception e){
            e.printStackTrace();
            return new Result().error("删除失败！");
        }
    }
}