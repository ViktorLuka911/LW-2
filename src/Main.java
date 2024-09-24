import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] args) {
        int N = getInput(); // Отримати кількість студентів
        Student[] students = CreateStudents(N); // Створити масив студентів
        StudentsThisFaculty(students); // Показати студентів за факультетом
        StudentsAfterThisYear(students); // Показати студентів, що народилися після вказаного року
        StudentsThisGroup(students); // Показати студентів за групою
    }

    private static int getInput() {
        int N = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nВведіть кількість студентів: ");
        try {
            N = scanner.nextInt();
            if (N <= 0) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Помилка: Число менше 1.");
            System.exit(1);
        }
        return N; // Повернення зчитаного числа
    }

    private static Student[] CreateStudents(int N) {
        Student[] students = new Student[N];
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Введення даних для кожного студента
        for (int i = 0; i < N; i++) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("\nВведіть дані для студента " + (i + 1) + ":");

            System.out.print("ID: ");
            int id = 0;
            try {
                id = scanner.nextInt();
                scanner.nextLine(); // Очищення буфера
                if (id <= 0) {
                    throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException e) {
                System.err.println("Помилка: Число менше 1.");
                i--;    // Можливість повторити введення даних про студента
                continue;
            }

            System.out.print("Ім'я: ");
            String firstname = scanner.nextLine();

            System.out.print("Прізвище: ");
            String lastname = scanner.nextLine();

            System.out.print("По батькові: ");
            String middlename = scanner.nextLine();

            System.out.print("Дата народження (yyyy-MM-dd): ");
            LocalDate dateOfBirth = LocalDate.of(2000, 1, 1); // Значення за замовчуванням
            try {
                dateOfBirth = LocalDate.parse(scanner.nextLine(), formatter);
            } catch (Exception e) {
                System.err.println("Помилка: Неправильний формат дати.");
                i--;    // Можливість повторити введення даних про студента
                continue;
            }

            System.out.print("Адреса: ");
            String address = scanner.nextLine();

            System.out.print("Номер телефону: ");
            String phoneNumber = scanner.nextLine();

            System.out.print("Факультет: ");
            String faculty = scanner.nextLine();

            System.out.print("Курс: ");
            String course = scanner.nextLine();

            System.out.print("Група: ");
            String group = scanner.nextLine();

            // Додаємо створеного студента до масиву
            students[i] = new Student(id, firstname, lastname, middlename, dateOfBirth, address, phoneNumber, faculty, course, group);
        }

        return students;
    }

    private static void StudentsThisFaculty(Student[] students) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nВведіть назву факультету: ");
        String faculty = scanner.nextLine();

        System.out.print("\nСписок студентів заданого факультету:\n\n");

        for (Student student : students) {
            if (student.getFaculty().equals(faculty)) {
                System.out.println(student);
            }
        }
    }

    private static void StudentsAfterThisYear(Student[] students) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nВведіть рік: ");
        int year = 0;
        try {
            year = scanner.nextInt();
            scanner.nextLine(); // Очищення буфера
            if (year <= 0) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Помилка: Число менше 1.");
            System.exit(1);
        }

        LocalDate comparisonDate = LocalDate.of(year, 12, 31);

        System.out.print("\nСписок студентів, які народились після заданого року:\n\n");

        for (Student student : students) {
            if (student.getDateOfBirth().isAfter(comparisonDate)) {
                System.out.println(student);
            }
        }
    }

    private static void StudentsThisGroup(Student[] students) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nВведіть назву групи: ");
        String group = scanner.nextLine();
        scanner.close(); // Закриття сканера

        System.out.print("\nСписок вказаної навчальної групи:\n\n");

        for (Student student : students) {
            if (student.getGroup().equals(group)) {
                System.out.println(student);
            }
        }
    }
}