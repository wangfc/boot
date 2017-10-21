package com.wfc.boot.entity;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author wangfc
 * @date 2017-09-24 17:45
 */
@Table(name = "dict")
@Data
public class Dict implements Serializable {

    private static final long serialVersionUID = 7129206078067303573L;

    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 排序
     */
    private Integer num;
    /**
     * 父级字典
     */
    private Integer pid;
    /**
     * 名称
     */
    private String name;
    /**
     * 提示
     */
    private String tips;

}