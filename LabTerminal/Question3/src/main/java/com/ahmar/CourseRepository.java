package com.ahmar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CourseRepository {

    private List<Course> courses = new ArrayList<>();

    public CourseRepository() {}

    List<Course> getCourses() {
        return courses;
    }

    void addCourse(Course course) {
        if (course == null) {
            throw new IllegalArgumentException("course must not be null");
        }

        courses.add(course);
    }

    void removeCourse(Course course) {
        if (course == null) {
            throw new IllegalArgumentException("course must not be null");
        }

        if (!courses.contains(course)) {
            throw new RuntimeException("course not found");
        }

        courses.remove(course);
    }

    boolean containsCourse(Course course) {
        return courses.contains(course);
    }

    List<Course> getCoursesFor(final String degreeProgram) {
        var coursesForDegreeProgram = courses.stream()
                .filter(flight -> flight.getDegreeProgram().equals(degreeProgram))
                .collect(Collectors.toList());

        if (coursesForDegreeProgram.isEmpty()) {
            throw new NoCourseFoundException("no courses found for " + degreeProgram);
        }

        return coursesForDegreeProgram;
    }
}
