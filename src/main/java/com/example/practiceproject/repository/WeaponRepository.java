package com.example.practiceproject.repository;

import com.example.practiceproject.model.Weapon;
import com.example.practiceproject.model.WeaponMap;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@org.springframework.stereotype.Repository
public class WeaponRepository implements Repository {

    private static final Map<Integer, Weapon> WEAPON_REPOSITORY_MAP = new HashMap<>();

    private void MapToXml() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(WeaponMap.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        WeaponMap weaponMap = new WeaponMap();
        weaponMap.setWeaponMap(WEAPON_REPOSITORY_MAP);
        jaxbMarshaller.marshal(weaponMap, System.out);
        jaxbMarshaller.marshal(weaponMap, new File("src/main/java/com/example/practiceproject/repository/weapons.xml"));
    }

    private void XmlToMap() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(WeaponMap.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        WeaponMap weaponMap = (WeaponMap) jaxbUnmarshaller.unmarshal(new File("src/main/java/com/example/practiceproject/repository/weapons.xml") );

        WEAPON_REPOSITORY_MAP.clear();
        WEAPON_REPOSITORY_MAP.putAll(weaponMap.getWeaponMap());
    }

    @Override
    public void add(Weapon weapon) {
        WEAPON_REPOSITORY_MAP.put(weapon.getSerialNumber(), weapon);
        try {
            this.MapToXml();
        } catch (JAXBException e) {
            System.out.print("XML write error:\n" + e);
        }
    }

    @Override
    public Weapon read(Integer serial_number) {
        if (WEAPON_REPOSITORY_MAP.isEmpty()) {
            try {
                this.XmlToMap();
            } catch (JAXBException e) {
                System.out.print("XML read error:\n" + e);
            }
        }
        return WEAPON_REPOSITORY_MAP.get(serial_number);
    }

    @Override
    public List<Weapon> readAll() {
        if (WEAPON_REPOSITORY_MAP.isEmpty()) {
            try {
                this.XmlToMap();
            } catch (JAXBException e) {
                System.out.print("XML read error:\n" + e);
            }
        }
        return new ArrayList<>(WEAPON_REPOSITORY_MAP.values());
    }

    @Override
    public boolean update(Weapon weapon, Integer serial_number) {
        if (WEAPON_REPOSITORY_MAP.containsKey(serial_number)) {
            try {
                weapon.setSerialNumber(serial_number);
                WEAPON_REPOSITORY_MAP.put(serial_number, weapon);
                this.MapToXml();
            } catch (JAXBException e) {
                System.out.print("XML write error:\n" + e);
                return false;
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Integer serial_number) {
        boolean result = false;
        try {
            result = WEAPON_REPOSITORY_MAP.remove(serial_number) != null;
            this.MapToXml();
        } catch (JAXBException e) {
            System.out.print("XML write error:\n" + e);
        }
        return result;
    }
}
