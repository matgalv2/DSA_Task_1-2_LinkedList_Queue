import java.io.IOException;

public class Main
{
    public void addingStudent(){}

    public static void main(String[]args) throws IOException
    {
        Student aaa = new Student("Tom", "van Dame", "19.10.1997", "001", 2, 3.5);
        Student aab = new Student("Jerry", "Jacoby", "12.05.1975", "002", 3, 5.27);
        Student aac = new Student("Kobe", "Dawg", "31.03.1981", "003", 4, 4.79);
        Student aad = new Student("Steve", "Collins", "04.08.1996", "004", 1, 3.15);
        Student aae = new Student("Tom", "Pharell", "30.03.1991", "005", 5, 4.68);
        Student aaf = new Student("Kanye", "East","12.12.1994","006",2,4.17);
        Student aag = new Student("Kanye", "West","13.12.1993","007",3,4.64);
        Student aah = new Student("Kanye", "South","14.12.1995","008",1,4.57);
        Student aai = new Student("Kanye", "North","15.12.1991","009",5,4.23);

        TableOfStudents tab = new TableOfStudents();
        tab.add(aaa);
        tab.add(aab);
        tab.add(aac);
        tab.add(aad);
        tab.add(aae);
        tab.add(aaf);
        tab.add(aag);
        tab.add(aah);
        tab.add(aai);
//        tab.searchByName("Tom");
//        tab.showTab();
//        tab.saveFile("list");
//        tab.readFile();
//        tab.delete(aae);
//        tab.showTab();
//        tab.readFile();




// LISTA 2



        // Proszę spojrzeć na metody check w klasach QueueFIFO i QueueLIFO, bo to one obsługują kolejki.



        QueueFIFO queueFIFO = new QueueFIFO();
        queueFIFO.addChosenToQueue(tab);
        queueFIFO.addToQueue(aab);
        queueFIFO.addToQueue(aag);
        queueFIFO.addToQueue(aai);
        queueFIFO.addToQueue(aaa);
        queueFIFO.addToQueue(aah);
        queueFIFO.prioritizeStudents(4.40);
//        queueFIFO.sortQueueByGradesAverage();
//        queueFIFO.showQueue();
        queueFIFO.check();



        QueueLIFO queueLIFO = new QueueLIFO();
        queueFIFO.addChosenToQueue(tab);
        queueLIFO.addToQueue(aae);
        queueLIFO.addToQueue(aac);
        queueLIFO.addToQueue(aai);
        queueLIFO.addToQueue(aad);
        queueLIFO.addToQueue(aag);
        queueLIFO.prioritizeStudents(4.60);
//        queueLIFO.sortQueueByGradesAverage();
        queueLIFO.showQueue();
        queueLIFO.check();
    }
}
