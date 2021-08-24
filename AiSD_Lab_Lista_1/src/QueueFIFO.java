import java.util.ArrayList;
import java.util.Scanner;

public class QueueFIFO
{
    public ArrayList<Student> queueList = new ArrayList<>();

    public QueueFIFO(){}

    public void showQueue()
    {
        int i =0;
        for(Student s : queueList)
        {
            System.out.println(i + ". " + s.toString());
            i++;
        }
    }

    public void addToQueue(Student student)
    {
        queueList.add(student);
    }

    public void addChosenToQueue(TableOfStudents table)
    {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < table.getList().length; i++)
        {
            System.out.println(i + ". " + table.getList()[i] );
        }
        System.out.print("Choose which student you would like to add to queue: ");
        Student student = table.getList()[scanner.nextInt()];
        queueList.add(student);
    }

    public void addChosenToQueueByAverage(TableOfStudents table)
    {
        Scanner scanner = new Scanner(System.in);

        int counter = 0;

        for (int i = 0; i < table.getList().length; i++)
        {
            System.out.println(i + "." + table.getList()[i] );
        }

        System.out.print("Choose which student you would like to add to queue: ");
        Student student = table.getList()[scanner.nextInt()];

        for (int i = 0; i < queueList.size(); i++)
        {
            if(student.getGrades_average()>queueList.get(i).getGrades_average() && counter == 0)
            {
                queueList.add(i, student);
                counter++;
            }
        }

        if (counter == 0)
        {
            queueList.add(student);
        }
    }

    public void remove(Student student)
    {
        queueList.remove(student);
    }

    public void sortQueueByGradesAverage()
    {
        ArrayList<Student>sortedList = new ArrayList<>();
        Student student = new Student();
        int queueListSize = queueList.size();
        double highestAverage = 0.0;

        for(int i = 0; i < queueListSize; i++)
        {
            for (Student s : queueList)
            {
                if (s.getGrades_average() >= highestAverage)
                {
                    highestAverage = s.getGrades_average();
                    student = s;
                }
            }
            sortedList.add(student);
            queueList.remove(student);
        }

        queueList = sortedList;
    }
// Ta metoda wyłącznie nadaje priorytet studentom, którzy mieli śrenią lub równą benchamrkowi, resztę pozostawia tak jak była.
    public void prioritizeStudents(double benchmark)
    {
        ArrayList<Student>prioritizedList = new ArrayList<>();
        Student student = new Student();
        int queueListSize = queueList.size();
        double highestAverage = 0.0;
        int counter = 0;

// Ten for przepisuje tych, którzy mieli wystarczającą średnią, ale w kolejności w jakiej byli wpisani do 1. listy.

        for(int i = 0; i < queueListSize; i++)
        {
            for (Student s : queueList)
            {
                if (s.getGrades_average() >= benchmark)
                {
                    highestAverage = s.getGrades_average();
                    student = s;
                    counter++;
                }
            }
            prioritizedList.add(student);
            queueList.remove(student);
        }

// Ten for uporządkowuje malejąco tych ze średnią powyżej benchmarka.
//
//        int prioritizedListSize = prioritizedList.size();
//        for (int i = 0; i < prioritizedListSize; i++)
//        {
//            for (int j = 1; j < prioritizedListSize; j++)
//            {
//                if (prioritizedList.get(j - 1).getGrades_average() < prioritizedList.get(j).getGrades_average())
//                {
//                    Student temp = prioritizedList.get(j - 1);
//                    prioritizedList.remove(j-1);
//                    prioritizedList.add(j,temp);
//                }
//            }
//        }

// Ten for przepisuje po prostu ludzi, którzy nie mieli wystarczającej średniej.

        for (int i = 0; i < queueListSize-counter; i++)
        {
            prioritizedList.add(queueList.get(i));
        }

        queueList = prioritizedList;
    }

// Obiekty klasy Student mają domyślnie przypisaną wartość false w polu checkedFIFO.
    public void check()
    {
        int queueListSize = queueList.size();
        long startTime = System.nanoTime();
        for (int i = 0; i < queueListSize; i++)
        {
            queueList.get(0).setCheckedFIFO(true);
            queueList.remove(0);
        }
        long stopTime = System.nanoTime();
        System.out.println("FCFS time: " + (stopTime-startTime) + " ns");
    }

}