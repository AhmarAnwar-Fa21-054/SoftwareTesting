package com.ahmar;

import java.util.Objects;

public class Course {
    private String name;
    private String code;
    private String degreeProgram;

    public Course(String name, String code, String degreeProgram) {
        this.name = name;
        this.code = code;
        this.degreeProgram = degreeProgram;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDegreeProgram() {
        return degreeProgram;
    }

    public void setDegreeProgram(String degreeProgram) {
        this.degreeProgram = degreeProgram;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(name, course.name) && Objects.equals(code, course.code) && Objects.equals(degreeProgram, course.degreeProgram);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, code, degreeProgram);
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", degreeProgram='" + degreeProgram + '\'' +
                '}';
    }
}
