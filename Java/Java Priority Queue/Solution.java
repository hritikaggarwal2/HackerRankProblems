import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java.util.PriorityQueue;
/*
 * Create the Student and Priorities classes here.
 */

class Student implements Comparable<Student> {
    private int id;
    private String name;
    private double cgpa;

    Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCGPA() {
        return cgpa;
    }

    @Override
    public int compareTo(Student s2) {
        if (Double.compare(this.getCGPA(), s2.getCGPA()) == 0) {
            if (this.getName().equals(s2.getName())) {
                return this.getID() - s2.getID();
            } else {
                return this.getName().compareTo(s2.getName());
            }
        } else {
            return Double.compare(s2.getCGPA(), this.getCGPA());
        }
    }
}

class Priorities {
    private PriorityQueue<Student> q = new PriorityQueue<>();

    public List<Student> getStudents(List<String> events) {
        for (String event : events) {
            if (event.equalsIgnoreCase("SERVED")) {
                q.poll();
            } else {
                String[] student = event.split(" ");
                q.add(new Student(Integer.parseInt(student[3]), student[1], Double.parseDouble(student[2])));
            }
        }

        List<Student> returnList = new ArrayList<>();

        while (!q.isEmpty()) {
            returnList.add(q.poll());
        }

        return returnList;
    }
}

public class Solution {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st : students) {
                System.out.println(st.getName());
            }
        }
    }
}