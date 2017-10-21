package com.wfc.boot.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * <p>
 * 部门表
 * </p>
 *
 * @author wangfc
 * @since 2017-09-24
 */
@Table(name="dept")
@Data
public class Dept implements Serializable {


	private static final long serialVersionUID = -621790585959294402L;
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
     * 父部门id
     */
	private Integer pid;
    /**
     * 父级ids
     */
	private String pids;
    /**
     * 简称
     */
	private String simplename;
    /**
     * 全称
     */
	private String fullname;
    /**
     * 提示
     */
	private String tips;
    /**
     * 版本（乐观锁保留字段）
     */
	private Integer version;


}
