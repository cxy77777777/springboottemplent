package com.lvgu.industrynew.files;

import com.lvgu.industrynew.domain.Result;
import com.lvgu.industrynew.utils.FileManagerUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/files")
@CrossOrigin
@Api(value = "FileManagerController", tags = "文件管理", description = "文件管理")
public class FileManagerController {
    @Autowired
    private FileManagerUtil fileManagerUtil;
    @Value("${uploadpath}")
    private String savePath;

    @ApiOperation(value="上传文件", response= Object.class)
    @RequestMapping(value = "fileUpload",method = RequestMethod.POST)
    public Result fileUpload(HttpServletRequest request)throws IOException {
        return new Result().ok(fileManagerUtil.uploadFile(request));
    }

    @ApiOperation(value="下载文件", response=Object.class)
    @RequestMapping(value = "fileDownload",method = RequestMethod.GET)
    public Result fileDownload(HttpServletRequest request, HttpServletResponse response, String path, String fileName){
        FileManagerUtil.fileDownLoad(response,savePath+fileName,fileName);
        return new Result().ok("下载成功！");
    }

    @ApiOperation(value="删除文件", response=Object.class)
    @RequestMapping(value = "deleteFile",method = RequestMethod.POST)
    public Result deleteFile(String path){
        return new Result().ok(String.valueOf(FileManagerUtil.deleteFile(path)));
    }
}
