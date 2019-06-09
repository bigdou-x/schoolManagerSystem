package com.bigdou.xuqing.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@Table
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name")
    private String userName;

    private String password;

    @Column(name = "gmt_create",updatable = false)
    @CreationTimestamp
    private Date createTime;

    @Column(name = "gmt_modified")
    @UpdateTimestamp
    private Date updateTime;

}
