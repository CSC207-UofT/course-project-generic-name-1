package com.generic.plannr.UseCaseTests;

import com.generic.plannr.Entities.Event;
import com.generic.plannr.UseCases.EventDateComparator;
import com.generic.plannr.UseCases.UserManager;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static com.generic.plannr.StaticTestVariables.TODAY;
import static com.generic.plannr.UseCases.SortTodaysEvents.*;
import static org.junit.Assert.assertEquals;

public class SortTodaysEventsTest {

    UserManager user;
    Event e1, e2, e3;
    ArrayList<String> COURSES;
    EventDateComparator EDC;

    @Before
    public void setUp() {
        COURSES = new ArrayList<>();
        EDC = new EventDateComparator();
        user = new UserManager("test", COURSES);

        e1 = new Event("test", 2, TODAY, TODAY);
        e2 = new Event("test", 1, TODAY.plusSeconds(1), TODAY.plusSeconds(1));
        e3 = new Event("test", 0, TODAY.plusSeconds(2), TODAY.plusSeconds(2));

        user.addEventToUsersList(e1);
        user.addEventToUsersList(e3);
        user.addEventToUsersList(e2);
    }

    @Test(timeout = 50)
    public void TestSortByDate() {
        ArrayList<Event> expected = new ArrayList<>(Arrays.asList(e1, e2, e3));
        assertEquals(expected, sortByDate(user));
    }

    @Test(timeout = 50)
    public void TestSortByPriority() {
        ArrayList<Event> expected = new ArrayList<>(Arrays.asList(e3, e2, e1));
        assertEquals(expected, sortByPriority(user));
    }

}
