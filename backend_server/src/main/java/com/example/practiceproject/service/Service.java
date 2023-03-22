package com.example.practiceproject.service;

import com.example.practiceproject.model.Weapon;
import com.example.practiceproject.repository.IRepository;
import com.example.practiceproject.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@org.springframework.stereotype.Service
public class Service implements IService {
    private static IRepository WEAPON_REPOSITORY;
    private static AtomicInteger WEAPON_ID_HOLDER;

    @Autowired
    public Service(Repository iRepository) {
        WEAPON_REPOSITORY = iRepository;
        List<Weapon> weaponList = WEAPON_REPOSITORY.readAll();
        Integer maxId = 0;
        for (Weapon weapon : weaponList) {
            if (weapon.getSerialNumber() > maxId) {
                maxId = weapon.getSerialNumber();
            }
        }
        WEAPON_ID_HOLDER = new AtomicInteger(maxId);
    }

    @Override
    @Async
    public void create(Weapon weapon) {
        final int weaponSerialNumber = WEAPON_ID_HOLDER.incrementAndGet();
        weapon.setSerialNumber(weaponSerialNumber);
        WEAPON_REPOSITORY.add(weapon);
    }

    @Override
    @Async
    public Weapon read(Integer serial_number) {
        return WEAPON_REPOSITORY.read(serial_number);
    }

    @Override
    @Async
    public List<Weapon> readAll() {
        return WEAPON_REPOSITORY.readAll();
    }

    @Override
    @Async
    public boolean update(Weapon weapon, Integer serial_number) {
        return WEAPON_REPOSITORY.update(weapon, serial_number);
    }

    @Override
    @Async
    public boolean delete(Integer serial_number) {
        return WEAPON_REPOSITORY.delete(serial_number);
    }

    @Override
    @Async
    public File getData() {
        return WEAPON_REPOSITORY.getData();
    }

    @Override
    @Async
    public boolean setData(MultipartFile file) {
        return WEAPON_REPOSITORY.setData(file);
    }
}
