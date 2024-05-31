package com.ahmar;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CourseEnrollmentService {

    private LocalDate enrollmentDeadline = LocalDate.of(2024, 7, 15);
    List<Course> enrolledCoursesList = new ArrayList<>();
    Clock clock;
    CourseRepository courseRepository;

    public CourseEnrollmentService(Clock clock, CourseRepository courseRepository) {
        this.clock = clock;
        this.courseRepository = courseRepository;
    }

    public List<Course> enrollCourses(List<Course> courses, String semester) {
        var today = clock.now();

        if (today.isAfter(enrollmentDeadline)) {
            throw new RuntimeException("the deadline has passed and you can't enroll in any course now");
        }

        for (Course course : courses) {
            boolean isAvailable = courseRepository.has(course);
            boolean offeredForSemester = courseRepository.offeredForSemester(semester);

            if (isAvailable && offeredForSemester) {
                enrolledCoursesList.add(course);
            }
        }

        return enrolledCoursesList;
    }
}
