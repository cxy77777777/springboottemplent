package com.lvgu.industrynew.controller.sys;

import com.lvgu.industrynew.comments.Constant;
import com.lvgu.industrynew.comments.PageData;
import com.lvgu.industrynew.domain.Result;
import com.lvgu.industrynew.dto.SysDictDataDTO;
import com.lvgu.industrynew.entity.SysDictDataEntity;
import com.lvgu.industrynew.entity.SysUserEntity;
import com.lvgu.industrynew.service.SysDictDataService;
import com.lvgu.industrynew.utils.BeanUtilss;
import com.lvgu.industrynew.utils.RedisCache;
import com.lvgu.industrynew.utils.SpringSecurityUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;


/**
 * 字典数据
 *
 * @author fyh 731530116@qq.com
 * @since 1.0.0 2022-08-05
 */
@RestController
@RequestMapping("v1/api/sysdictdata")
@Api(tags="字典数据")
public class SysDictDataController {
    @Autowired
    private SysDictDataService sysDictDataService;
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
            PageData<SysDictDataDTO> page = sysDictDataService.page(params);
            return new Result().ok(page);
        }catch (Exception e){
            e.printStackTrace();
            return new Result().error("查询列表失败！");
        }
    }

    @GetMapping("getListByDictType")
    @ApiOperation("根据字典类型查询数据")
    public Result getListByDictType(@RequestParam("dictType") String dictType){
        try {
            List<SysDictDataEntity> list = sysDictDataService.getListByType(dictType);
            return new Result().ok(list);
        }catch (Exception e){
            e.printStackTrace();
            return new Result().error("查询列表失败！");
        }
    }

    @GetMapping("getById")
    @ApiOperation("信息")
    public Result getById(@RequestParam("id") String id){
        try {
            SysDictDataDTO data = sysDictDataService.get(id);
            return new Result().ok(data);
        }catch (Exception e){
            e.printStackTrace();
            return new Result().error("查询详情失败！");
        }
    }

    @PostMapping("save")
    @ApiOperation("保存")
    public Result save(@RequestBody SysDictDataDTO dto, HttpServletRequest request){
        try {
            SysUserEntity user = SpringSecurityUtils.getUserInfo().getUserEntity();
            BeanUtilss.setBasValue(dto,user);
            sysDictDataService.saveData(dto);
            return new Result().ok("保存成功");
        }catch (Exception e){
            e.printStackTrace();
            return new Result().error("保存失败！");
        }
    }

    @PostMapping("update")
    @ApiOperation("修改")
    public Result update(@RequestBody SysDictDataDTO dto, HttpServletRequest request){
        try {
            SysUserEntity user = SpringSecurityUtils.getUserInfo().getUserEntity();
            BeanUtilss.updateBasValue(dto,user);
            sysDictDataService.updateData(dto);
            return new Result().ok("修改成功");
        }catch (Exception e){
            e.printStackTrace();
            return new Result().error("修改失败！");
        }
    }

    @GetMapping("deletedById")
    @ApiOperation("删除")
    public Result deletedById(@RequestParam("id") String id){
        try {
            sysDictDataService.deleteByIdd(id);
            return new Result().ok("删除成功！");
        }catch (Exception e){
            e.printStackTrace();
            return new Result().error("删除失败！");
        }
    }
}