package com.ahmar;

public interface CourseRepository {
    boolean has(Course course);
    boolean offeredForSemester(String semester);
}
