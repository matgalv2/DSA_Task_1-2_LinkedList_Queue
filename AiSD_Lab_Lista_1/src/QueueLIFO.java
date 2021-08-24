import java.util.ArrayList;
import java.util.Scanner;

public class QueueLIFO
{
    public ArrayList<Student> queueList = new ArrayList<>();


    public QueueLIFO(){}


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


// Ta metoda służy do dodawania do kolejki, która jest już shierarchizowana w myśli LIFO
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

        for (int i = queueList.size()-1; i < 0; i++)
        {
            if(student.getGrades_average()>queueList.get(i).getGrades_average() && counter == 0)
            {
                queueList.add((i+1), student);
                counter++;
            }
        }
        if (counter == 0)
        {
            queueList.add(0, student);
        }
    }


    public void remove(Student student)
    {
        queueList.remove(student);
    }


// Ta metoda wyłącznie nadaje priorytet studentom, którzy mieli śrenią lub równą benchamrkowi, resztę pozostawia tak jak była.
    public void prioritizeStudents(double benchmark)
    {
        ArrayList<Student>prioritizedList = new ArrayList<>();
        Student student = new Student();
        int queueListSize = queueList.size();
        int counter = 0;

// Ten for przepisuje tych, którzy mieli wystarczającą średnią, ale w kolejności w jakiej byli wpisani do 1. listy.

        for(int i = 0; i < queueListSize; i++)
        {
            for (Student s : queueList)
            {
                if (s.getGrades_average() >= benchmark)
                {
                    student = s;

                }
            }
            prioritizedList.add(student);
            queueList.remove(student);
        }
        counter = prioritizedList.size();

// Tu ma być for, który teraz uporządkuje tych ze średnią powyżej benchmarka.

//        int prioritizedListSize = prioritizedList.size();
//        for (int i = 0; i < prioritizedListSize; i++)
//        {
//            for (int j = 1; j < prioritizedListSize-1; j++)
//            {
//                if (prioritizedList.get(j - 1).getGrades_average() > prioritizedList.get(j).getGrades_average())
//                {
//                    Student temp = prioritizedList.get(j - 1);
//                    prioritizedList.remove(j-1);
//                    prioritizedList.add(j,temp);
//                }
//            }
//        }
        ArrayList<Student> sortedList = new ArrayList<>();
        for(int i = 0; i < prioritizedList.size(); i++)
        {
            sortedList.add(0 ,prioritizedList.get(i));
        }

        prioritizedList = sortedList;


// Ten for przepisuje po prostu ludzi, którzy nie mieli wystarczającej średniej.

        for (int i = 0; i < queueListSize-counter; i++)
        {
            prioritizedList.add(0, queueList.get(i));
        }

        queueList = prioritizedList;
    }


    public void sortQueueByGradesAverage()
    {
        ArrayList<Student>sortedList = new ArrayList<>();
        Student student = new Student();
        int queueListSize = queueList.size();
        double lowestAverage = 6.0;

        for(int i = 0; i < queueListSize; i++)
        {
            for (Student s : queueList)
            {
                if (s.getGrades_average() <= lowestAverage)
                {
                    lowestAverage = s.getGrades_average();
                    student = s;
                }
            }
            sortedList.add(student);
            queueList.remove(student);
        }
        queueList = sortedList;
    }

// Obiekty klasy Student mają domyślnie przypisaną wartość false w polu checkedLIFO
    public void check()
    {
        long startTime = System.nanoTime();
        for (int i = queueList.size()-1; i > 0; i--)
        {
            queueList.get(i).setCheckedLIFO(true);
            queueList.remove(i);
        }
        long stopTime = System.nanoTime();
        System.out.println("LIFO time: " + (stopTime-startTime) + " ns");
    }
}