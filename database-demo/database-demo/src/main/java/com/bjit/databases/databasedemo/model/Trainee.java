package com.bjit.databases.databasedemo.model;

import jakarta.persistence.*;

@Entity
public class Trainee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "trainee_id")
    private Long traineeId;
    private String firstName;
    private String lastName;
    private String bloodGroup;

    public Trainee() {
    }

    public Trainee(Long traineeId, String firstName, String lastName, String bloodGroup) {
        this.traineeId = traineeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.bloodGroup = bloodGroup;
    }

    public Long getTraineeId() {
        return traineeId;
    }

    public void setTraineeId(Long traineeId) {
        this.traineeId = traineeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }
}
