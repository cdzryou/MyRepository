package com.atguigu.springcloud.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author 游正荣
 * @create 2019-11-12 14:58
 */
@NoArgsConstructor
@Data
@Accessors(chain=true)
public class Dept implements Serializable {//Dep(Entity) orm mysql->Dept(table) 类表关系映射
    private static final long serialVersionUID = -7246960705321338256L;
    private Long 	deptno; // 主键
    private String 	dname; // 部门名称
    private String 	db_source;// 来自那个数据库，因为微服务架构可以一个服务对应一个数据库，同一个信息被存储到不同数据库

    public Dept(String dname)
    {
        super();
        this.dname = dname;
    }

}
