package com.example.exam.DAO;

import com.example.exam.model.Employe;

import java.util.List;

public interface EmployeDao {
    List<Employe> selectAll();

    boolean addLine(Employe std );

    boolean delete(int id);

    void close();
    Employe find(Long id );

    List<Employe> selectOne(String condition);

}
