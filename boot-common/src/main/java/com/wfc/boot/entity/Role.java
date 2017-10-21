package com.wfc.boot.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author wangfc
 * @date 2017-09-24 17:55
 */
@Table(name="role")
@Data
public class Role implements Serializable {

    private static final long serialVersionUID = -197718996715130620L;


    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 序号
     */
    private Integer num;
    /**
     * 父角色id
     */
    private Integer pid;
    /**
     * 角色名称
     */
    private String name;
    /**
     * 部门名称
     */
    private Integer deptid;
    /**
     * 提示
     */
    private String tips;
    /**
     * 保留字段(暂时没用）
     */
    private Integer version;

}