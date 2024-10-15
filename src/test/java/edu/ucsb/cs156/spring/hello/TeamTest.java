package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList; 
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test // Case 1
    public void equals_returns_correct1_bool() {
        Team other = new Team("test-team");
        assertEquals(true, other.equals(other));
    }
    @Test // Case 2
    public void equals_returns_correct2_bool() {
        Team other = new Team("test-team");
        char c = 'd';
        assertEquals(false, other.equals(c));
        
    }
    @Test // Case 3
    public void equals_returns_correct3_bool() {
        Team other = new Team("test-team");
        Team other2 = new Team("test-team");
        Team other3 = new Team("troll");
        ArrayList<String> mem = new ArrayList<>();
        mem.add("one");

        ArrayList<String> mem2 = new ArrayList<>();
        mem2.add("two");
    
        assertEquals(true, other.equals(other2));

        other.setMembers(mem);
        other2.setMembers(mem2);

        assertEquals(false, other.equals(other2));
        
        other = new Team("test-team");
        other2 = new Team("test-team");

        other.setName("monkey");
        other.setName("donkey");
        assertEquals(false, other.equals(other2));

        other.setMembers(mem);
        other2.setMembers(mem2);

        assertEquals(false, other.equals(other2));
    }
    @Test 
    public void hashCode_test() {
        Team t = new Team("new-team");
        int result = t.hashCode();
        int expectedResult = 1331150443;
        assertEquals(expectedResult, result);
    }

   
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

}
