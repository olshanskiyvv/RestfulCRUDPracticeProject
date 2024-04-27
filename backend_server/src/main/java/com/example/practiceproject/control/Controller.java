package com.example.practiceproject.control;

import com.example.practiceproject.model.Weapon;
import com.example.practiceproject.service.ServiceImpl;
import com.example.practiceproject.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.net.MalformedURLException;
import java.util.List;

@RestController
@CrossOrigin
public class Controller {
    private final IService service;

    @Autowired
    public Controller(ServiceImpl serviceImpl) {
        this.service = serviceImpl;
    }

    @PostMapping(value = "/")
    public ResponseEntity<?> create(@RequestBody Weapon weapon) {
        service.create(weapon);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/")
    public ResponseEntity<List<Weapon>> readAll() {
        final List<Weapon> weapons = service.readAll();

        return weapons != null &&  !weapons.isEmpty()
                ? new ResponseEntity<>(weapons, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/weapons/{id}")
    public ResponseEntity<Weapon> read(@PathVariable(name = "id") Integer serial_number) {
        final Weapon weapon = service.read(serial_number);

        return weapon != null
                ? new ResponseEntity<>(weapon, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/weapons/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody Weapon weapon) {
        final boolean updated = service.update(weapon, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/weapons/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = service.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @GetMapping(value = "/download")
    public ResponseEntity<?> download() {
        Resource resource = null;
        File file = service.getData();
        try {
            resource = new UrlResource(file.toURI());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_XML)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"weapons.xml\"")
                .body(resource);
    }

    @PostMapping(value = "/upload")
    public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file) {
        return service.setData(file)
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

}
