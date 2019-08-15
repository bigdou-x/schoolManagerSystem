package com.bigdou.school.datastructure;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <P>文件描述：单链表</P>
 *
 * @author xuqing
 * @version V1.0
 * @date 2019-8-1 10:52:35
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ListNode {

    /**
     * 节点存储的信息
     */
    int value;
    /**
     * 下个节点
     */
    ListNode next;

}
