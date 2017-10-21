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
 * @date 2017-09-24 17:52
 */
@Table(name="operation_log")
@Data
public class OperationLog implements Serializable{

    private static final long serialVersionUID = -4782813677773875699L;
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 日志类型
     */
    private String logtype;
    /**
     * 日志名称
     */
    private String logname;
    /**
     * 用户id
     */
    private Integer userid;
    /**
     * 类名称
     */
    private String classname;
    /**
     * 方法名称
     */
    private String method;
    /**
     * 创建时间
     */
    private Date createtime;
    /**
     * 是否成功
     */
    private String succeed;
    /**
     * 备注
     */
    private String message;
}