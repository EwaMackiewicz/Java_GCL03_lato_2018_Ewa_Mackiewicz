import java.util.Scanner;
import java.util.Comparator;
public class Item implements Comparable<Item> {
    Scanner wpisz = new Scanner(System.in);
    String nazwa;
    ItemCondition stan;
    double masa;
    int ilosc;


    Item() {


        this.nazwa = nazwa;
        this.stan = stan;
        this.ilosc = ilosc;
        this.masa = masa;

    }

    Item(String n, ItemCondition s, int i, double m) {
        this.nazwa = n;
        this.stan = s;
        this.ilosc = i;
        this.masa = m;
    }
/*
    void typeIn() {
        System.out.println("Wpisz nazwe, stan, mase, ilosc: ");
        nazwa = wpisz.nextLine();
        stan = stan.valueOf(wpisz.next());
        masa = wpisz.nextDouble();
        ilosc = wpisz.nextInt();


    }
*/

    public void print() {
        System.out.println("Przedmiot o nazwie " + nazwa + " " + " w stanie " + stan + " o masie " + masa + " w liczbie " + ilosc);

    }

    public double getMass() {
        return masa;
    }

    public String getName() {
        return nazwa;
    }
    public Integer getQuantity()
    {
        return ilosc;
    }
    public void setQuantity(int change)
    {
        ilosc+=change;
    }



    @Override
    public int compareTo(Item it)
    {
        int name_comparison = nazwa.compareTo(it.nazwa);

        if (name_comparison == 0)
        {
            return nazwa.compareTo(it.nazwa);
        }
        else
        {
            return name_comparison;
        }
    }


}










