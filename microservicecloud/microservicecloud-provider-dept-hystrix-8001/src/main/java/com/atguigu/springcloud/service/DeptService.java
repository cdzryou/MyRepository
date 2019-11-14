package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Dept;
import java.util.List;

/**
 * @author 游正荣
 * @create 2019-11-12 16:36
 */
public interface DeptService {
    public boolean add(Dept dept);

    public Dept get(Long id);

    public List<Dept> list();
}
