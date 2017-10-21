package com.wfc.boot.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author wangfc
 * @date 2017-09-24 17:54
 */
@Table(name = "relation")
@Data
public class Relation implements Serializable {

    private static final long serialVersionUID = -4910500326609551688L;

    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 菜单id
     */
    private Integer menuid;
    /**
     * 角色id
     */
    private Integer roleid;
}