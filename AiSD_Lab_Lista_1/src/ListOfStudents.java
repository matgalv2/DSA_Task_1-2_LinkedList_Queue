import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ListOfStudents implements Iterator<Student>
{
    private ArrayList<Student> list;
    private Iterator<Student> it;
    private Student empty = new Student("empty");

    public ListOfStudents()
    {
        this.list = new ArrayList<>();
//        this.it = list.iterator();
    }

    public ArrayList<Student> getList()
    {
        return this.list;
    }

    public void setList(ArrayList<Student> list)
    {
        this.list = list;
    }

    public void add(Student s)
    {
       list.add(s);
       it = list.iterator();
    }

    public void addByIndex(Student s, int index)
    {
        if(index < list.size())
        {
            list.add(index,s);
        }
        else
        {
            for(int i = 0; i<index - list.size(); i++)
            {
                list.add(empty);
            }
            list.add(s);
        }
        it = list.iterator();
    }
    public void deleteOne(Student s)
    {
        Scanner sc = new Scanner(System.in);
        int n = 0;

        for(Student x : list)
        {
            if(x==s)
            {
                n++;
            }
        }

        if(n==1)
        {
            deleteEvery(s);
        }

        else if(n!=0)
            {
                System.out.println("Choose position you want to delete: ");
                for(int i=0; i < list.size(); i++)
                {
                    if (list.get(i) == s);
                    System.out.println(i);
                }
                int id = sc.nextInt();

                if(list.get(id)==s)
                {
                    list.remove(id);
                    it = list.iterator();

                }
                else
                {
                    System.out.println("Invalid data input");
                }
            }
    }

    public void deleteEvery(Student s)
    {
        int n = 0;
        for(Student x : list)
        {
            if(x == s);
            list.remove(s);
        }
        it = list.iterator();
    }

//////////////////////////////////////////////////////
//      Iterator

//    private Iterator it = list.iterator();

    public boolean hasNext()
    {
            return false;
    }

    public Student next()
    {
        return null;
    }

    public void searchByName(String name)
    {
        Student s;
        while(it.hasNext())
        {
            s = it.next();
            if(s.getName().equals(name))
            {
                System.out.println(s);
            }
        }
    }

    public void searchBySurname(String surname)
        {
            Student s;
        while(it.hasNext())
        {
            s = it.next();
            if(s.getSurname().equals(surname))
            {
                System.out.println(s);
            }
        }
    }

    public void searchByBirthDate(String birth_date)
    {
        Student s;
        while(it.hasNext())
        {
            s = it.next();
            if(s.getBirth_date().equals(birth_date))
            {
                System.out.println(s);
            }
        }
    }

    public void searchBySeriesNumber(String series_number)
    {
        Student s;
        while(it.hasNext())
        {
            s = it.next();
            if(s.getSeries_number().equals(series_number))
            {
                System.out.println(s);
            }
        }
    }

    public void searchByYearOfStudying(int year_of_studying)
    {
        Student s;
        while(it.hasNext())
        {
            s = it.next();
            if(s.getYear_of_studying() == year_of_studying)
            {
                System.out.println(s);
            }
        }
    }

    public void searchByGradesAverage(double grades_average)
    {
        Student s;
        while(it.hasNext())
        {
            s = it.next();
            if(s.getGrades_average() >= grades_average)
            {
                System.out.println(s);
            }
        }
    }

    public void show()
    {
        Student s;
        while(it.hasNext())
        {
            s = it.next();
            System.out.println(s);
        }
    }
//////////////////////////////////////////////////////
//      Save/Load csv

}