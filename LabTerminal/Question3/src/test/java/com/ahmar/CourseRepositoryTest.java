package com.ahmar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;


class CourseRepositoryTest {
    @Test
    void uponInitializationItShouldNotContainAnyCourses() {
        //Given
        CourseRepository underTest = new CourseRepository();
        //When
        var courses = underTest.getCourses();
        //Then
        assertThat(courses).isEmpty();
    }

    @Test
    void itShouldSuccessfullyAddACourseToTheRepository() {
        //Given
        CourseRepository underTest = new CourseRepository();
        Course PF = new Course("PF", "CS101", "CS");
        //When
        underTest.addCourse(PF);
        var actual = underTest.containsCourse(PF);

        //Then
        assertThat(actual).isTrue();
    }

    @Test
    void itShouldThrowIllegalArgumentExceptionIfCourseIsNull() {
        //Given
        CourseRepository underTest = new CourseRepository();
        Course PF = null;
        //When - Then
        assertThrows(IllegalArgumentException.class, () -> underTest.addCourse(PF));
    }

    @Test
    void itShouldSuccessfullyRemoveTheGivenCourseFromTheRepository() {
        //Given
        CourseRepository underTest = new CourseRepository();
        Course PF = new Course("PF", "CS101", "CS");
        Course AI = new Course("AI", "AI101", "AI");
        Course AP = new Course("AP", "EE101", "CS");
        underTest.addCourse(PF);
        underTest.addCourse(AI);
        underTest.addCourse(AP);
        //When
        underTest.removeCourse(AI);
        var courses = underTest.getCourses();
        //Then
        assertThat(courses).doesNotContain(AI);
    }
    @Test
    void itShouldThrowIllegalArgumentExceptionIfWeWantToRemoveTheCourseThatIsNullFromTheRepository() {
        //Given
        CourseRepository underTest = new CourseRepository();
        Course PF = new Course("PF", "CS101", "CS");
        Course AP = new Course("AP", "EE101", "CS");
        underTest.addCourse(PF);
        underTest.addCourse(AP);
        Course AI = null;
        //When - Then
       assertThrows(IllegalArgumentException.class,()-> underTest.removeCourse(AI));
    }

    @Test
    void itShouldRuntimeExceptionIfWeWantToRemoveTheCourseThatIsNotAddedInTheRepository() {
        //Given
        CourseRepository underTest = new CourseRepository();
        Course PF = new Course("PF", "CS101", "CS");
        Course AP = new Course("AP", "EE101", "CS");
        underTest.addCourse(PF);
        underTest.addCourse(AP);
        Course AI = new Course("AI", "AI101", "AI");
        //When - Then
        assertThrows(RuntimeException.class,()-> underTest.removeCourse(AI));
    }

    @Test
    void itShouldGetCoursesForTheGivenDegreeProgram() {
        //Given
        CourseRepository underTest = new CourseRepository();
        Course PF = new Course("PF", "CS101", "CS");
        Course AI = new Course("AI", "AI101", "AI");
        Course AP = new Course("AP", "EE101", "CS");
        underTest.addCourse(PF);
        underTest.addCourse(AI);
        underTest.addCourse(AP);
        //When
      var courses = underTest.getCoursesFor("CS");
        //Then
        assertThat(courses).containsExactlyInAnyOrder(PF,AP);
    }

    @Test
    void itShouldNoCourseFoundExceptionIfNoCoursesAreFoundForTheGivenDegreeProgram() {
        //Given
        CourseRepository underTest = new CourseRepository();
        Course PF = new Course("PF", "CS101", "CS");
        Course AI = new Course("AI", "AI101", "AI");
        Course AP = new Course("AP", "EE101", "CS");
        underTest.addCourse(PF);
        underTest.addCourse(AI);
        underTest.addCourse(AP);
        //When - Then
       assertThrows(NoCourseFoundException.class,()-> underTest.getCoursesFor("BSE"));
     
        
    }
}


