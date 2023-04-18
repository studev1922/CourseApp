/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.course.dao;

import java.util.List;

/**
 *
 * @author abc
 * @param <E>: Lớp entity mục EduSys.entity
 * @param <ID>: Các khóa chính của dữ liệu entity
 */
public abstract class EduSysDAO<E, ID> {

    // Thêm dữ liệu vào database
    public abstract boolean Insert(E entity);

    // Sửa dữ liệu trong database
    public abstract boolean Update(E entity);

    // Xóa dữ liệu trong database
    public abstract boolean Delete(ID id);

    // Lấy thông tin theo mã khóa chính
    public abstract E SelectById(ID id);

    // Lấy toàn bộ thông tin
    public abstract List<E> SelectAll();

    public abstract List<E> SelectBySql(String sql, Object...agrs);
}
