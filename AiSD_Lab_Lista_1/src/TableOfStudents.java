import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class TableOfStudents implements Iterator
{
    private Student [] list;
    private Scanner scanner;
    private Student x = new Student("No one");

    public TableOfStudents() throws FileNotFoundException
    {
        this.list = new Student[0];
        scanner = new Scanner(new File("list.csv"));
    }

    public Student [] getList()
    {
        return this.list;
    }

    public void setList(Student[] list)
    {
        this.list = list;
    }

    public void showTab()
    {
        for (int i = 0; i < list.length; i++)
        {
            System.out.println(list[i]);
        }
    }

    public void add(Student s)
    {
        Student [] list1 = new Student[list.length+1];
        int n = 0;
        for(int i = 0; i<list.length; i++)
        {    n++;
            list1[i] = list [i];
        }
            list1[n] = s;
            this.list = list1;
        }

    public void addByIndex(Student s, int index)
    {

        if(index <= list.length)
        {
            Student[] list3 = new Student[list.length + 1];
            int n = 0;
            for (int i = 0; i < list3.length; i++)
            {
                if (i != index) {
                    list3[i] = list[n];
                    n++;
                } else {
                    list3[i] = s;
                }
            }
            this.list = list3;
        }
        else
        {
            Student [] list3 = new Student[index];
            int m = 0;
            for (int i = 0; i < index; i++)
            {
                if(i<list.length)
                {
                    list3[i] = list[m];
                    m++;
                }
                else if (i == index-1)
                {
                    list3[i] = s;
                }
                else
                    {
                        list3[i] = x;
                    }
            }
                this.list = list3;
        }
    }
// null better
        public void delete(Student s)
        {
            int n = 0;
            int m = 0;


            for(int i=0; i<list.length; i++)
            {
                if(list[i].equals(s))
                {
                    list[i] = x;
                }
            }

            for(int i = 0; i < list.length; i++)
            {
                if(list[i]== x)
                {
                    m++;
                }
            }

            Student [] list2 = new Student[list.length-m];

            for(int i=0; i<list.length; i++)
            {
                if(list[i] != x )
                {
                    list2[n] = list[i];
                    n++;
                }
            }
            this.list = list2;
        }
//////////////////////////////////////////////////////
//      Iterator

     private int i = 0;

    public void next()
    {
        i++;
    }

    public boolean isDone()
    {
        if(i == list.length )
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public Student current()
    {
        return list[i];
    }

    public void reset()
    {
        i = 0;
    }

    public void searchByName(String name)
    {
        int n = 0;
        while(!isDone())
        {
            if(current().getName().equals(name))
            {
                System.out.println(list[i]);
                n++;
            }
            next();
        }
        if(n == 0)
        {
            System.out.println("There is no student with that name.");
        }
        reset();
    }

    public void searchBySurname(String surname)
    {
        int n = 0;
        while(!isDone())
        {
            if(current().getSurname().equals(surname))
            {
                System.out.println(list[i]);
                n++;
            }
            next();
        }
        if(n == 0)
        {
            System.out.println("There is no student with that surname.");
        }
        reset();
    }

    public void searchByBirthDate(String birth_date)
    {
        int n = 0;
        while(!isDone())
        {
            if(current().getBirth_date().equals(birth_date))
            {
                System.out.println(list[i]);
                n++;
            }
            next();
        }
        if(n == 0)
        {
            System.out.println("There is no student born on that date.");
        }
        reset();
    }

    public void searchBySeriesNumber(String series_number)
    {
        int n = 0;
        while(!isDone())
        {
            if(current().getSeries_number().equals(series_number))
            {
                System.out.println(list[i]);
                n++;
            }
            next();
        }
        if(n == 0)
        {
            System.out.println("There is no student with that series number.");
        }
        reset();
    }

    public void searchByYearOfStudying(int year_of_studying)
    {
        int n = 0;
        while(!isDone())
        {
            if(current().getYear_of_studying()==(year_of_studying))
            {
                System.out.println(list[i]);
                n++;
            }
            next();
        }
        if(n == 0)
        {
            System.out.println("There is x`no student at this year.");
        }
        reset();
    }

    public void searchByGradesAverage(double grades_average)
    {
        int n = 0;
        while(!isDone())
        {
            if(current().getGrades_average() >= grades_average)
            {
                System.out.println(list[i]);
                n++;
            }
            next();
        }
        if(n == 0)
        {
            System.out.println("There is no student with higher or equal grades average.");
        }
        reset();
    }

//////////////////////////////////////////////////////
//      Save/Load csv
// Has to be done with different approach
    public void saveFile(String File_name) throws IOException
    {
        PrintWriter printWriter = new PrintWriter(new File(File_name+".csv"));
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("List length"+": " + list.length);
            stringBuilder.append("\n");
        while(!isDone())
        {
            stringBuilder.append(list[i].getName());
            stringBuilder.append(", ");
            stringBuilder.append(list[i].getSurname());
            stringBuilder.append(", ");
            stringBuilder.append(list[i].getBirth_date());
            stringBuilder.append(", ");
            stringBuilder.append(list[i].getSeries_number());
            stringBuilder.append(", ");
            stringBuilder.append(list[i].getYear_of_studying());
            stringBuilder.append(", ");
            stringBuilder.append(list[i].getGrades_average());
            stringBuilder.append("\n");


            next();
        }
        printWriter.write(stringBuilder.toString());
        printWriter.close();
        reset();
    }

    public int readCapacity()
    {
        int capcity = -1;
        String line;
        line = scanner.nextLine();
        String parts [] = line.split(" ");
        int capacity = Integer.parseInt(parts[2]);
        return capacity;
    }

    public Student[] readFile() throws FileNotFoundException
    {
        String line;
        Student s;
        String parts[];
        int capacity = readCapacity();
        Student [] tab = new Student[capacity];
        String name, surname, birth_date, series_number;
        int years_of_studying;
        double grades_average;
        for (int i = 0; i <capacity; i++)
        {
            line = scanner.nextLine();
//            System.out.println(line);
            parts = line.split(", ");
            name = parts[0];
            surname = parts[1];
            birth_date = parts[2];
            series_number = parts[3];
            years_of_studying = Integer.parseInt(parts[4]);
            grades_average = Double.parseDouble(parts[5]);
            s = new Student(name, surname, birth_date, series_number,
                    years_of_studying, grades_average);
            tab[i] = s;
        }

        for (int i = 0; i < tab.length; i++)
        {
            System.out.println(tab[i]);
        }

        scanner.close();

        return tab;
    }
}