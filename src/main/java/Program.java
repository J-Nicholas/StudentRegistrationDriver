import StudentRegistration.Course;
import StudentRegistration.Module;
import StudentRegistration.Student;
import org.joda.time.DateTime;

import java.util.Date;

public class Program {

    public static void main(String[] args) {
        Student mary = new Student("Mary", "Smith", new DateTime(1990, 12, 23, 0, 0));
        Student tom = new Student("Tom", "McGuire", new DateTime(1998, 3, 12, 0, 0));
        Student harry = new Student("Harry", "Millar", new DateTime(2000, 1, 21, 0, 0));
        Student mathew = new Student("Mathew", "McGill", new DateTime(1999, 4, 1, 0 ,0));

        Module softwareEngineering = new Module("Software Engineering III", "CT4177");
        Module informationRetrieval = new Module("Information Retrieval", "CT4965");
        Module artificialIntelligence = new Module("Artificial Intelligence", "CT4512");
        Module electricalEngineeringFoundation = new Module("Electrical Engineering Foundations", "EE4011");

        DateTime academicYear2021StartDate = new DateTime(2021, 9, 1, 0, 0);
        DateTime academicYear2021EndDate = new DateTime(2022, 5, 10, 0, 0);

        Course computerScience = new Course("Computer Science");
        computerScience.setStartDate(academicYear2021StartDate);
        computerScience.setEndDate(academicYear2021EndDate);

        Course electricalEngineering = new Course("Electrical Engineering");
        electricalEngineering.setStartDate(academicYear2021StartDate);
        electricalEngineering.setEndDate(academicYear2021EndDate);

        // Enroll students in modules and respective courses
        mary.enrollInCourse(computerScience);
        mary.enrollInModule(softwareEngineering);
        mary.enrollInModule(artificialIntelligence);
        mary.enrollInModule(electricalEngineeringFoundation);

        tom.enrollInCourse(computerScience);
        tom.enrollInModule(informationRetrieval);
        tom.enrollInModule(artificialIntelligence);

        harry.enrollInCourse(computerScience);
        harry.enrollInModule(artificialIntelligence);
        harry.enrollInModule(softwareEngineering);
        harry.enrollInModule(informationRetrieval);

        mathew.enrollInCourse(electricalEngineering);
        mathew.enrollInModule(electricalEngineeringFoundation);
        mathew.enrollInModule(softwareEngineering);

        // Add modules to courses
        computerScience.addModule(artificialIntelligence);
        computerScience.addModule(electricalEngineeringFoundation);
        computerScience.addModule(informationRetrieval);
        computerScience.addModule(softwareEngineering);

        electricalEngineering.addModule(electricalEngineeringFoundation);
        electricalEngineering.addModule(softwareEngineering);



        printCourseModules(computerScience);
        printCourseModules(electricalEngineering);
    }

    public static void printCourseModules(Course course) {
        // Listing modules in each course
        System.out.println("Course: " + course.getTitle());
        System.out.println("Modules:");
        for (Module module : course.getModules()) {
            System.out.println(module.getCode() + " " + module.getTitle());
        }

        // Listing students registered in each course
        System.out.println("\nStudents registered in " + course.getTitle() + ":");
        for (Student student : course.getRegisteredStudents()) {
            System.out.println("ID: " + student.getId() + " Name: " + student.getFullName() + " Username: " + student.getUserName());
            System.out.println("\tRegistered for modules: ");
            for (Module module : student.getModules()) {
                System.out.println("\t- " + module.getCode() + " " + module.getTitle());
            }
            System.out.println("\n\tRegistered for courses:");
            for (Course studentCourse : student.getCourses()) {
                System.out.println("\t- " + studentCourse.getTitle());
            }
            System.out.println();
        }
        System.out.println("\n" + course.getTitle() + " module breakdown:");
        for (Module module : course.getModules()) {
            System.out.println("Students registered for module " + module.getCode() + " " + module.getTitle());
            for (Student student : module.getRegisteredStudents()) {
                System.out.println("ID: " + student.getId() + " Name: " + student.getFullName() + " Username: " + student.getUserName());
            }
            System.out.println(); //spacer
        }
        System.out.println(); // spacer
    }
}
