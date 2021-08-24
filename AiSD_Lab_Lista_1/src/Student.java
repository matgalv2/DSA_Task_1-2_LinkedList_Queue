import java.sql.Date;

public class Student
{
    private String name;
    private String surname;
    private String birth_date;
    private String series_number;
    private int year_of_studying;
    private double grades_average;
    private boolean checkedFIFO;
    private boolean checkedLIFO;


    public Student(){
        this.checkedFIFO = false;
        this.checkedLIFO = false;
    }

    public Student(String name)
    {
        this.name = name;
        this.checkedFIFO = false;
        this.checkedLIFO = false;
    }

    public Student(String name, String surname, String birth_date, String series_number, int year_of_studying,
                   double grades_average)
    {
        this.name = name;
        this.surname = surname;
        this.birth_date = birth_date;
        this.series_number = series_number;
        this.year_of_studying = year_of_studying;
        this.grades_average = grades_average;
        this.checkedFIFO = false;
        this.checkedLIFO = false;
    }

    public String toString()
    {
        return "Name: " + name + " Surname: " + surname + " Birth date: " + birth_date + " Series number: "
                + series_number + " Year of studying: " + year_of_studying + " Grade's average: " + grades_average;
    }

//////////////////////////////////////////////////////
//      Getters

    public String getName()
    {
        return this.name;
    }
    public String getSurname()
    {
        return this.surname;
    }
    public String getBirth_date()
    {
        return this.birth_date;
    }
    public String getSeries_number()
    {
        return this.series_number;
    }
    public int getYear_of_studying()
    {
        return this.year_of_studying;
    }
    public double getGrades_average()
    {
        return this.grades_average;
    }
    public boolean getCheckedFIFO() {
        return this.checkedFIFO;
    }
    public boolean getCheckedLIFO() {
        return this.checkedLIFO;
    }

//////////////////////////////////////////////////////
//      Setters
    public void setName(String name)
    {
        this.name = name;
    }
    public void setSurname(String surname)
    {
        this.surname = surname;
    }
    public void setBirth_date(String birth_date)
    {
        this.birth_date = birth_date;
    }
    public void setSeries_number(String series_number)
    {
        this.series_number = series_number;
    }
    public void setYear_of_studying(int year_of_studying)
    {
        this.year_of_studying = year_of_studying;
    }
    public void setGrades_average(double grades_average)
    {
        this.grades_average = grades_average;
    }
    public void setCheckedFIFO(boolean checkedFIFO) {
        this.checkedFIFO = checkedFIFO;
    }
    public void setCheckedLIFO(boolean checkedLIFO) {
        this.checkedLIFO = checkedLIFO;
    }

}