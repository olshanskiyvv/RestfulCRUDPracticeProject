package com.example.practiceproject.repository;

import com.example.practiceproject.model.Weapon;

import java.util.List;

public interface Repository {
    void add(Weapon weapon);
    Weapon read(Integer serial_number);
    List<Weapon> readAll();
    boolean update(Weapon weapon, Integer serial_number);
    boolean delete(Integer serial_number);
}
