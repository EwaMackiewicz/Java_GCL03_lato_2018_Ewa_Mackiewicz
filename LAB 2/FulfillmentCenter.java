import java.util.*;
import java.util.Collections;


import static java.lang.String.valueOf;

public class FulfillmentCenter {

    Scanner wpisz = new Scanner(System.in);

    private String StorageName;
    private int StorageCapacity;
    private double StorageMaxCapacity;
    String nazwa;



    List<Item> products = new ArrayList<Item>();
    int maks;
    Item i = new Item();

    public FulfillmentCenter(String storageName, double StorageMaxCapacity) {
        this.StorageName=StorageName;
        this.StorageMaxCapacity=StorageMaxCapacity;
        this.StorageCapacity=StorageCapacity;
    }

    public void addProduct(Item o) {
        int licznik = 0;
        Iterator<Item> i = products.iterator();
        while(i.hasNext())
            licznik++;

        try
        {
            if(licznik < maks)
            {
                for(Item l : products)
                {
                    if(l.compareTo(o) != 0)
                        products.add(o);
                    else
                        l.ilosc++;
                }
            }
            else throw new Przepelnienie("Przepelnienie");
        }
        catch(Przepelnienie ex) {
            System.out.println(ex.getMessage());
        }
    }
}

    public int size(){return this.products.size();}

public String getItem(Item i) {
        for (Item x : products) {
        if (x.getName() == i.getName()) {
        if (x.getQuantity() == 1) {
        products.remove(i);
        return "To byla ostatnia sztuka tego prodyktu, pozycja usunieta z magazynu";
        } else {
        x.setQuantity(-1);
        return "Zmiejszono ilosc o 1";
        }

        }
        }
        return "Produkt nie istnieje xD";
        }

public List<Item> searchPartial(String productName)
        {
        Item tmp=new Item(nazwa,ItemCondition.NEW,0,0);
        List<Item> tmpList = new ArrayList<Item>();

        for(Item x : products) {

        if (x.getName().startsWith(productName))
        {

        Item tmp1=x;
        tmpList.add(tmp1);

        }
        }
        return  tmpList;
        }

public String removeProduct(Item i) {
        products.remove(i);
        return "Product was removed";
        }

        void summary() {
        System.out.println("W magazynie o nazwie" + StorageName + " znajduja sie przedmioty ");
        for (int i = 0; i < products.size(); i++) {
        products.get(i).print();
        System.out.println(" ");
        }
        }

public int search(String nazwa)
        {
        for(Item x: products)
        {
        if(x.nazwa.compareTo(nazwa)==0) return products.indexOf(x);
        }
        return -1;

        }

        int countByContidion(ItemCondition condition)
        {
        int counter=0;

        for(Item x:products)
        {
        if(x.stan==condition)
        {
        counter+=x.ilosc;
        }
        }
        return counter;
        }
        String max()
        {
        return Collections.max(products,new CompareAmmount()).nazwa;
        }

public double zapelnienie(){return 100-((StorageMaxCapacity/StorageCapacity)*100);}




public void sortByName(){Collections.sort(products);}
public int getStorageCap(){return StorageCapacity;}

        void sortByAmmount()
        {
        Collections.sort(products,new CompareAmmount());
        }


class CompareAmmount implements Comparator<Item>
{
    @Override
    public int compare(Item item, Item t1) {

        return item.ilosc<t1.ilosc?-1:item.ilosc==t1.ilosc?0:1;
    }
}





