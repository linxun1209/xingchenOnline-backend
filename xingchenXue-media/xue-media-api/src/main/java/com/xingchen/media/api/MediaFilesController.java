package com.xingchen.media.api;

import com.xingchen.base.enums.CourseEnum;
import com.xingchen.base.model.PageParams;
import com.xingchen.base.model.PageResult;
import com.xingchen.domain.dto.QueryMediaParamsDto;
import com.xingchen.domain.dto.UploadFileParamsDto;
import com.xingchen.domain.dto.UploadFileResultDto;
import com.xingchen.domain.entity.MediaFiles;
import com.xingchen.media.service.MediaFilesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author: 35238
 * 功能: 媒资文件管理
 * 时间: 2024-04-15 22:09
 */
@Api(value = "媒资文件管理接口",tags = "媒资文件管理接口")
@RestController
public class MediaFilesController {


    @Autowired
    MediaFilesService mediaFileService;


    @ApiOperation("媒资列表查询接口")
    @GetMapping("/files")
    public PageResult<MediaFiles> list(PageParams pageParams, @RequestBody QueryMediaParamsDto queryMediaParamsDto){
        Long companyId = 1232141425l;
        return mediaFileService.queryMediaFiels(companyId,pageParams,queryMediaParamsDto);
    }


    //------------------------------------整合minio-上传图片--------------------------------------

    @ApiOperation("上传图片文件")
    @PostMapping(value = "/upload/coursefile",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseBody
    public UploadFileResultDto upload(@RequestPart("filedata") MultipartFile filedata) throws IOException {

        Long companyId = 1232141425L; //机构端还没写，这个机构id先写死
        UploadFileParamsDto uploadFileParamsDto = new UploadFileParamsDto();
        //文件大小
        uploadFileParamsDto.setFileSize(filedata.getSize());
        //图片类型
        uploadFileParamsDto.setFileType(CourseEnum.MINIO_TYPE_IMG.getCode());
        //文件名称
        uploadFileParamsDto.setFilename(filedata.getOriginalFilename());//文件名称
        //文件大小
        long fileSize = filedata.getSize();
        uploadFileParamsDto.setFileSize(fileSize);
        //创建临时文件，这个临时文件会在服务器
        File tempFile = File.createTempFile("minio", "temp");//临时文件，前缀+后缀，随便写都可以
        //用户上传的文件拷贝到临时文件。也就是把用户上传的文件，保存到服务器中
        filedata.transferTo(tempFile);
        //从临时文件获取文件路径
        String absolutePath = tempFile.getAbsolutePath();
        //上传文件到Minio
        UploadFileResultDto uploadFileResultDto = mediaFileService.uploadFile(companyId, uploadFileParamsDto, absolutePath);

        return uploadFileResultDto;
    }
}