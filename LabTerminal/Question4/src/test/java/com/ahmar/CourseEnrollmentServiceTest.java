package com.ahmar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;


class CourseEnrollmentServiceTest {
    CourseEnrollmentService service;
    Clock clock;
    CourseRepository repository;

    @BeforeEach
    void setUp() {
        clock = mock(Clock.class);
        repository = mock(CourseRepository.class);
        service = new CourseEnrollmentService(clock, repository);
    }

    @Test
    void SuccessFullyEnrolledInAListOfCourses() {
        //Given
        Course PF = new Course("PF", "CS101", "CS");
        Course AI = new Course("AI", "AI101", "AI");
        Course AP = new Course("AP", "EE101", "CS");
        List<Course> courses = new ArrayList<>();
        courses.add(PF);
        courses.add(AI);
        courses.add(AP);
        String semester = "Fall_Semester6";
        //When
        when(clock.now()).thenReturn(LocalDate.now());
        when((repository.has(any(Course.class)))).thenReturn(true);
        when((repository.offeredForSemester(semester))).thenReturn(true);
        var enrolledCoursesList = service.enrollCourses(courses, semester);
        //Then
        assertThat(enrolledCoursesList).containsExactlyInAnyOrder(PF, AI, AP);

    }

    @Test
    void itShouldThrowRuntimeExceptionIfTheDeadlineHasPassed() {
        //Given
        Course PF = new Course("PF", "CS101", "CS");
        Course AI = new Course("AI", "AI101", "AI");
        Course AP = new Course("AP", "EE101", "CS");
        List<Course> courses = new ArrayList<>();
        courses.add(PF);
        courses.add(AI);
        courses.add(AP);
        String semester = "Fall_Semester6";
        //When - Then
        when(clock.now()).thenReturn(LocalDate.of(2024, 7, 16));
        when((repository.has(any(Course.class)))).thenReturn(true);
        when((repository.offeredForSemester(semester))).thenReturn(true);
        assertThrows(RuntimeException.class, () -> service.enrollCourses(courses, semester));


    }

    @Test
    void studentShouldNotBeAbleToEnrollForCourseThatIsNotAvailable() {
        //Given
        Course PF = new Course("PF", "CS101", "CS");
        Course AI = new Course("AI", "AI101", "AI");
        Course AP = new Course("AP", "EE101", "CS");
        List<Course> courses = new ArrayList<>();
        courses.add(PF);
        courses.add(AI);
        courses.add(AP);
        String semester = "Fall_Semester6";
        //When
        when(clock.now()).thenReturn(LocalDate.now());
        when((repository.has(PF))).thenReturn(true);
        when((repository.has(AI))).thenReturn(false);
        when((repository.has(AP))).thenReturn(true);
        when((repository.offeredForSemester(semester))).thenReturn(true);
        // Then
        var enrolledCoursesList = service.enrollCourses(courses, semester);
        assertThat(enrolledCoursesList).containsExactlyInAnyOrder(PF,AP);

    }
    @Test
    void studentShouldNotBeAbleToEnrollForCoursesThatAreNotOfferedForTheGivenSemester() {
        //Given
        Course PF = new Course("PF", "CS101", "CS");
        Course AI = new Course("AI", "AI101", "AI");
        Course AP = new Course("AP", "EE101", "CS");
        List<Course> courses = new ArrayList<>();
        courses.add(PF);
        courses.add(AI);
        courses.add(AP);
        String semester = "Fall_Semester7";
        //When
        when(clock.now()).thenReturn(LocalDate.now());
        when((repository.has(PF))).thenReturn(true);
        when((repository.has(AI))).thenReturn(true);
        when((repository.has(AP))).thenReturn(true);
        when((repository.offeredForSemester(semester))).thenReturn(false);
        // Then
        var enrolledCoursesList = service.enrollCourses(courses, semester);
        assertThat(enrolledCoursesList).isEmpty();

    }
}