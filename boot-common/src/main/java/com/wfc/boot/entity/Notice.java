package com.wfc.boot.entity;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author wangfc
 * @date 2017-09-24 17:51
 */
@Table(name="notice")
@Data
public class Notice implements Serializable {

    private static final long serialVersionUID = -4465705549606040707L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 标题
     */
    private String title;
    /**
     * 类型
     */
    private Integer type;
    /**
     * 内容
     */
    private String content;
    /**
     * 创建时间
     */
    private Date createtime;
    /**
     * 创建人
     */
    private Integer creater;
}