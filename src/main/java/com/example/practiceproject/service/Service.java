package com.example.practiceproject.service;

import com.example.practiceproject.model.Weapon;
import com.example.practiceproject.repository.WeaponRepository;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@org.springframework.stereotype.Service
public class Service implements WeaponService {
    private static final WeaponRepository WEAPON_REPOSITORY = new WeaponRepository();
    private static final AtomicInteger WEAPON_ID_HOLDER = new AtomicInteger();

    @Override
    public void create(Weapon weapon) {
        final int weaponSerialNumber = WEAPON_ID_HOLDER.incrementAndGet();
        weapon.setSerialNumber(weaponSerialNumber);
        WEAPON_REPOSITORY.add(weapon);
    }

    @Override
    public Weapon read(Integer serial_number) {
        return WEAPON_REPOSITORY.read(serial_number);
    }

    @Override
    public List<Weapon> readAll() {
        return WEAPON_REPOSITORY.readAll();
    }

    @Override
    public boolean update(Weapon weapon, Integer serial_number) {
        return WEAPON_REPOSITORY.update(weapon, serial_number);
    }

    @Override
    public boolean delete(Integer serial_number) {
        return WEAPON_REPOSITORY.delete(serial_number);
    }
}
