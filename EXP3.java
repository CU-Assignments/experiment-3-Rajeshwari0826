//Square Root Calculation with Exception Handling
import java.util.Scanner;
public class Easy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        try {
            double number = scanner.nextDouble();
            if (number < 0) 
                throw new IllegalArgumentException("Error: Cannot calculate the square root of a negative number.");
            System.out.println("Square root: " + Math.sqrt(number));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: Invalid input. Please enter a numeric value.");
        }
    }
}

// output
// Enter a number: -3
// Error: Cannot calculate the square root of a negative number.

// ATM Withdrawal System with Exception Handling
import java.util.Scanner;
class InvalidPINException extends Exception {
    public InvalidPINException(String message) {
        super(message);
    }
}
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}
public class Medium {
    private static final int CORRECT_PIN = 1234;
    private static double balance = 3000;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter PIN: ");
            int pin = scanner.nextInt();
            if (pin != CORRECT_PIN) 
                throw new InvalidPINException("Error: Invalid PIN.");
            System.out.print("Withdraw Amount: ");
            double amount = scanner.nextDouble();
            if (amount > balance) 
                throw new InsufficientBalanceException("Error: Insufficient balance. Current Balance: " + balance);
            balance -= amount;
            System.out.println("Withdrawal successful! Remaining Balance: " + balance);
        } catch (InvalidPINException | InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: Invalid input. Please enter a valid number.");
        } finally {
            System.out.println("Final Balance: " + balance);
        }
    }
}

// output
// Enter PIN: 1234
// Withdraw Amount: 5000
// Error: Insufficient balance. Current Balance: 3000.0
// Final Balance: 3000.0



//University Enrollment System with Custom Exceptions
import java.util.HashMap;
import java.util.Scanner;
class CourseFullException extends Exception {
    public CourseFullException(String message) {
        super(message);
    }
}
class PrerequisiteNotMetException extends Exception {
    public PrerequisiteNotMetException(String message) {
        super(message);
    }
}
class EnrollmentSystem {
    private static final int MAX_CAPACITY = 2;
    private static int enrolledStudents = 0;
    public static HashMap<String, Boolean> prerequisites = new HashMap<>();
    public static void enrollStudent(String course, String prerequisite) throws CourseFullException, PrerequisiteNotMetException {
        if (!prerequisites.getOrDefault(prerequisite, false))
            throw new PrerequisiteNotMetException("Error: PrerequisiteNotMetException - Complete " + prerequisite + " before enrolling in " + course + ".");
        if (enrolledStudents >= MAX_CAPACITY)
            throw new CourseFullException("Error: CourseFullException - Enrollment limit reached for " + course + ".");
        enrolledStudents++;
        System.out.println("Successfully enrolled in " + course + "!");
    }
}
public class hard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EnrollmentSystem.prerequisites.put("Core Java", false);
        try {
            System.out.print("Enroll in Course: ");
            String course = scanner.nextLine();
            System.out.print("Prerequisite: ");
            String prerequisite = scanner.nextLine();
            EnrollmentSystem.enrollStudent(course, prerequisite);
        } catch (CourseFullException | PrerequisiteNotMetException e) {
            System.out.println(e.getMessage());
        }
    }
}


//  output 
//Enroll in Course: cse
// Prerequisite: java
// Error: PrerequisiteNotMetException - Complete java before enrolling in cse.
