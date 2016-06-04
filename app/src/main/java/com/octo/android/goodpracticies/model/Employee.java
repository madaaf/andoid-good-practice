package com.octo.android.goodpracticies.model;

import java.io.Serializable;

/**
 * Created by madaaflak on 12/01/2016.
 */
public class Employee implements Serializable{

    private String fistName;
    private String lastName;
    private String picture;

    public String getFistName() {
        return fistName;
    }

    public void setFistName(String fistName) {
        this.fistName = fistName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "fistName='" + fistName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", picture='" + picture + '\'' +
                '}';
    }

    /**
     * PATTERN BUILDER
     */

    public static Builder getBuilder() {
        return new Builder();
    }

    public static class Builder {

        private Employee employee = new Employee();

        public Builder firstName(String firstName) {
            this.employee.fistName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.employee.lastName = lastName;
            return this;
        }

        public Builder picture(String picture) {
            this.employee.picture = picture;
            return this;
        }

        public Employee build() {
            return employee;
        }
    }
}
