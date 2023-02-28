package com.example.practiceproject.model;

public class Weapon {
    private Integer serial_number;
    private String type;
    private String name;
    private float sighting_range;
    private Integer capacity;
    private float weight;
    private int rate_of_fire;

    public Integer GetSerialNumber() {
        return this.serial_number;
    }

    public void SetSerialNumber(Integer serial_number) {
        this.serial_number = serial_number;
    }

    public String GetType() {
        return this.type;
    }

    public void SetType(String type) {
        this.type = type;
    }

    public String GetName() {
        return this.name;
    }

    public void SetName(String name) {
        this.name = name;
    }

    public float GetSightingRange() {
        return this.sighting_range;
    }

    public void SetSightingRange(float sighting_range) {
        this.sighting_range = sighting_range;
    }

    public Integer GetCapacity() {
        return this.capacity;
    }

    public void SetCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public float GetWeight() {
        return this.weight;
    }

    public void SetWeight(float weight) {
        this.weight = weight;
    }

    public Integer GetRateOfFire() {
        return this.rate_of_fire;
    }

    public void SetRateOfFire(Integer rate_of_fire) {
        this.rate_of_fire = rate_of_fire;
    }
}
