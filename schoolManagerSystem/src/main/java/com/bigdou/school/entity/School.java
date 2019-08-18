package com.bigdou.school.entity;

import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * <P>文件描述：区域信息</P>
 *
 * @author xuqing
 * @version V1.0
 * @date 2019-8-18 17:09:12
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Document
public class School {

    @Id
    @ApiParam(value = "学校Id")
    private String id;

    @ApiParam(value = "学校名称")
    private String caption;

    @CreatedDate
    @ApiParam(value = "创建时间")
    private Date createTime;

    @LastModifiedDate
    @ApiParam(value = "最后一次修改时间")
    private Date updateTime;

}
