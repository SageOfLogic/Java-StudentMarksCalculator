import java.util.Scanner;

public class StudentMarks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("- Student Marks Calculator-");
        System.out.print("Enter number of students: ");
        int studentCount = validateInteger(sc);

        for (int s = 1; s <= studentCount; s++) {
            System.out.println("\nStudent " + s );
            System.out.print("Enter Student Name: ");
            String name = sc.nextLine();

            System.out.print("Enter number of subjects: ");
            int subjectCount = validateInteger(sc);

            double[] marks = new double[subjectCount];
            double total = 0;

            for (int i = 0; i < subjectCount; i++) {
                System.out.print("Enter marks for Subject " + (i + 1) + ": ");
                marks[i] = validateMarks(sc);
                total += marks[i];
            }

            double average = total / subjectCount;
            char grade = calculateGrade(average);

            System.out.println("\n-Result-");
            System.out.println("Name: " + name);
            System.out.println("Total Marks: " + total);
            System.out.printf("Average: %.2f%n", average);
            System.out.println("Grade: " + grade);
        }

        sc.close();
    }

    public static char calculateGrade(double avg) {
        if (avg >= 90) return 'A';
        else if (avg >= 75) return 'B';
        else if (avg >= 60) return 'C';
        else if (avg >= 40) return 'D';
        else return 'F';
    }

    public static double validateMarks(Scanner sc) {
        while (true) {
            try {
                double value = Double.parseDouble(sc.next());
                if (value < 0 || value > 100) {
                    System.out.print("Invalid marks! Enter between 0-100: ");
                } else {
                    sc.nextLine(); // consume newline
                    return value;
                }
            } catch (NumberFormatException e) {
                System.out.print("Invalid input! Enter a valid number: ");
            }
        }
    }

    public static int validateInteger(Scanner sc) {
        while (true) {
            try {
                int value = Integer.parseInt(sc.next());
                if (value <= 0) {
                    System.out.print("Enter a positive number: ");
                } else {
                    sc.nextLine(); // consume newline
                    return value;
                }
            } catch (NumberFormatException e) {
                System.out.print("Invalid input! Enter a valid integer: ");
            }
        }
    }
}
