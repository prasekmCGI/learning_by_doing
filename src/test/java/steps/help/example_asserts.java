package steps.help;

import cucumber.api.java.en.Then;
import static org.junit.Assert.*;

public class example_asserts {
	
	String str1 = new String ("abc");
    String str2 = new String ("abc");
    String str3 = null;
    String str4 = "abc";
    String str5 = "abc";
		
    int val1 = 5;
    int val2 = 6;

    String[] expectedArray = {"one", "two", "three"};
    String[] resultArray =  {"one", "two", "three"};   
    
    @Then("^test of assertEquals$")
    public void test_of_assertEquals() throws Exception {
    	//Check that two objects are equal
        assertEquals(str1, str2);
    }

    @Then("^test of assertTrue$")
    public void test_of_assertTrue() throws Exception {
    	//Check that a condition is true
        assertTrue (val1 < val2);
    }

    @Then("^test of assertFalse$")
    public void test_of_assertFalse() throws Exception {
    	//Check that a condition is false
        assertFalse(val1 > val2);
    }

    @Then("^test of assertNotNull$")
    public void test_of_assertNotNull() throws Exception {
    	//Check that an object isn't null
        assertNotNull(str1);
    }

    @Then("^test of assertNull$")
    public void test_of_assertNull() throws Exception {
    	//Check that an object is null
        assertNull(str3);
    }

    @Then("^test of assertSame$")
    public void test_of_assertSame() throws Exception {
    	//Check if two object references point to the same object
        assertSame(str4,str5);
    }

    @Then("^test of assertNotSame$")
    public void test_of_assertNotSame() throws Exception {
    	//Check if two object references not point to the same object
        assertNotSame(str1,str3);
    }

    @Then("^test of assertArrayEquals$")
    public void test_of_assertArrayEquals() throws Exception {
    	//Check whether two arrays are equal to each other.
        assertArrayEquals(expectedArray, resultArray);
    }
    
}