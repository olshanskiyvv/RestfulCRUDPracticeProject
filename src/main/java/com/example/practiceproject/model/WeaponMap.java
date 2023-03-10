package com.example.practiceproject.model;

import javax.xml.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@XmlRootElement(name = "Weapons")
@XmlAccessorType(XmlAccessType.FIELD)
public class WeaponMap {
    private Map<Integer, Weapon> weaponMap;

    public WeaponMap() {
        weaponMap = new HashMap<>();
    }

    public Map<Integer, Weapon> getWeaponMap() {
        return weaponMap;
    }

    public void setWeaponMap(Map<Integer, Weapon> weaponMap) {
        this.weaponMap = weaponMap;
    }
}
