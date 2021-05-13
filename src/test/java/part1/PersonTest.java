package part1;

import org.junit.Assert;
import org.junit.Test;

public class PersonTest {

    @Test
    public void personConstructorWorks() {
        var expectedName = "Malik";
        var expectedAge = 10;
        var person = new Person(expectedName, expectedAge);

        var actualName = person.getName();
        var actualAge = person.getAge();

        Assert.assertEquals(expectedName, actualName);
        Assert.assertEquals(expectedAge, actualAge);
    }

    @Test
    public void getNameReturnsNameCorrectly() {
        // Setup variables
        var expectedName = "Dawut";
        var person = new Person(expectedName, 10);

        // Do the action
        var actualName = person.getName();

        // Assert result
        Assert.assertEquals(expectedName, actualName);
    }

    @Test
    public void setNameSetsTheNameCorrectly() {
        var expectedName = "Asdf";
        var person = new Person();

        person.setName(expectedName);
        var actualName = person.getName();

        Assert.assertEquals(expectedName, actualName);
    }

    @Test
    public void getAgeReturnsAgeCorrectly() {
        var expectedAge = 10;
        var person = new Person("", expectedAge);

        var actualAge = person.getAge();

        Assert.assertEquals(expectedAge, actualAge);
    }

    @Test
    public void getAgeReturnsAgeCorrectly2() {
        var expectedAge = 5;
        var person = new Person("", expectedAge);

        var actualAge = person.getAge();

        Assert.assertEquals(expectedAge, actualAge);
    }

    @Test
    public void setAgeSetsTheAgeCorrectly() {
        var expectedAge = 10;
        var person = new Person();

        person.setAge(expectedAge);
        var actualAge = person.getAge();

        Assert.assertEquals(expectedAge, actualAge);
    }

    @Test
    public void reverseNameReturnsReversedName() {
        var expectedResult = "kilaM";
        var person = new Person("Malik", 0);

        var actualResult = person.reverseName();

        Assert.assertEquals(expectedResult, actualResult);
    }

}