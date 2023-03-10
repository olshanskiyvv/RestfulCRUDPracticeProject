package com.example.practiceproject.repository;

import com.example.practiceproject.model.Weapon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@org.springframework.stereotype.Repository
public class WeaponRepository implements Repository {

    private static final Map<Integer, Weapon> WEAPON_REPOSITORY_MAP = new HashMap<>();
    @Override
    public void add(Weapon weapon) {
        WEAPON_REPOSITORY_MAP.put(weapon.getSerialNumber(), weapon);
    }

    @Override
    public Weapon read(Integer serial_number) {
        return WEAPON_REPOSITORY_MAP.get(serial_number);
    }

    @Override
    public List<Weapon> readAll() {
        return new ArrayList<>(WEAPON_REPOSITORY_MAP.values());
    }

    @Override
    public boolean update(Weapon weapon, Integer serial_number) {
        if (WEAPON_REPOSITORY_MAP.containsKey(serial_number)) {
            weapon.setSerialNumber(serial_number);
            WEAPON_REPOSITORY_MAP.put(serial_number, weapon);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Integer serial_number) {
        return WEAPON_REPOSITORY_MAP.remove(serial_number) != null;
    }
}
