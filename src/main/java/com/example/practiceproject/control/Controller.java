package com.example.practiceproject.control;

import com.example.practiceproject.model.Weapon;
import com.example.practiceproject.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {
    private final Service weaponService;

    @Autowired
    public Controller(Service service) {
        this.weaponService = service;
    }

    @PostMapping(value = "/")
    public ResponseEntity<?> create(@RequestBody Weapon weapon) {
        weaponService.create(weapon);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/")
    public ResponseEntity<List<Weapon>> read() {
        final List<Weapon> weapons = weaponService.readAll();

        return weapons != null &&  !weapons.isEmpty()
                ? new ResponseEntity<>(weapons, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/weapons/{id}")
    public ResponseEntity<Weapon> read(@PathVariable(name = "id") Integer serial_number) {
        final Weapon weapon = weaponService.read(serial_number);

        return weapon != null
                ? new ResponseEntity<>(weapon, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/weapons/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody Weapon weapon) {
        final boolean updated = weaponService.update(weapon, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/weapons/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = weaponService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
