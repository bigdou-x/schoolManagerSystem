package com.bigdou.school.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <P>文件描述：service返回结果集</P>
 *
 * @author xuqing
 * @version V1.0
 * @date 2019-7-9 18:26:29
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Result {

    /**
     * 返回结果
     */
    private Object content;
    /**
     * 错误码 0成功 其他失败，具体见ErrorCodeEnum枚举类
     */
    private int ret = -1;
    /**
     * 数量 用于分页
     */
    private int count;

}
