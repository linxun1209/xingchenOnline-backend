package com.xingchen.media.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.xingchen.base.model.PageParams;
import com.xingchen.base.model.PageResult;
import com.xingchen.base.model.RestResponse;
import com.xingchen.domain.dto.QueryMediaParamsDto;
import com.xingchen.domain.dto.UploadFileParamsDto;
import com.xingchen.domain.dto.UploadFileResultDto;
import com.xingchen.domain.entity.MediaFiles;

/**
 * 媒资信息(MediaFiles)表服务接口
 *
 * @author makejava
 * @since 2024-04-15 22:18:03
 */
public interface MediaFilesService extends IService<MediaFiles> {
    /**
     * @description 媒资文件查询方法
     * @param pageParams 分页参数
     * @param queryMediaParamsDto 查询条件
     * @return com.xuecheng.base.model.PageResult<com.xuecheng.media.model.po.MediaFiles>
     */
    PageResult<MediaFiles> queryMediaFiels(Long companyId, PageParams pageParams, QueryMediaParamsDto queryMediaParamsDto);

    /**
     * 上传图片文件
     * @param companyId 机构id
     * @param uploadFileParamsDto 上传文件信息
     * @param localFilePath 文件磁盘路径
     * @return 文件信息
     */
    UploadFileResultDto uploadFile(Long companyId, UploadFileParamsDto uploadFileParamsDto, String localFilePath);

    /**
     * 为了让事务不失效，把MediaFilesServiceImpl的addMediaFilesToDb方法写一份到这个接口
     * @param companyId
     * @param fileMd5
     * @param uploadFileParamsDto
     * @param bucket
     * @param objectName
     * @return
     */
    MediaFiles addMediaFilesToDb(Long companyId, String fileMd5, UploadFileParamsDto uploadFileParamsDto, String bucket, String objectName);


    /**
     * @description 上传视频-检查文件是否存在
     * @param fileMd5 文件的md5
     */
    RestResponse<Boolean> checkFile(String fileMd5);

    /**
     * @description 上传视频-检查分块是否存在
     * @param fileMd5  文件的md5
     * @param chunkIndex  分块序号
     */
    RestResponse<Boolean> checkChunk(String fileMd5, int chunkIndex);

    /**
     * @description 上传视频-上传分块
     * @param fileMd5  文件md5
     * @param chunk  分块序号
     * @param localChunkFilePath  分块文件本地路径
     */
    RestResponse uploadChunk(String fileMd5,int chunk,String localChunkFilePath);


    /**
     * @description 上传视频-合并分块
     * @param companyId  机构id
     * @param fileMd5  文件md5
     * @param chunkTotal 分块总和
     * @param uploadFileParamsDto 文件信息
     */
    RestResponse mergechunks(Long companyId, String fileMd5, int chunkTotal, UploadFileParamsDto uploadFileParamsDto);


}