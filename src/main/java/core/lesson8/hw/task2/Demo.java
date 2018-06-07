package core.lesson8.hw.task2;


public class Demo {

    Student createHighestParent() {
        return new Student("Test", "Test", 3, new Course[3]);
    }

    SpecialStudent createLowestChild() {
        return new SpecialStudent("Test", "Test", 3, new Course[3], 12, "email");
    }

}
