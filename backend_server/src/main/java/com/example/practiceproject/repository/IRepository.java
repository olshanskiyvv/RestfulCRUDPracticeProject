package com.example.practiceproject.repository;

import com.example.practiceproject.model.Weapon;

import java.io.File;
import java.util.List;

public interface IRepository {
    void add(Weapon weapon);
    Weapon read(Integer serial_number);
    List<Weapon> readAll();
    boolean update(Weapon weapon, Integer serial_number);
    boolean delete(Integer serial_number);

    File getData();
}
