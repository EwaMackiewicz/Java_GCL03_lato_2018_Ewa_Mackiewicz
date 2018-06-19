import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.*;

public class FulfillmentCenterContainer {
    private Map<String, FulfillmentCenter> magazyny = new LinkedHashMap<String, FulfillmentCenter>();


    public void addCenter(String storageName, Double storageCapacity) {
        FulfillmentCenter magazyn = new FulfillmentCenter(storageName, storageCapacity);
        magazyny.put(storageName, magazyn);

    }
    public void removeCenter(String name){magazyny.remove(name);}

    //ZWRACAMY LISTE PUSTYCH MAGAZYNOW

    public Map<String, FulfillmentCenter> findEmpty()
    {
        Map<String, FulfillmentCenter> temp = new LinkedHashMap<>();
        for(Map.Entry<String, FulfillmentCenter> entry: magazyny.entrySet())
        {
            String key=entry.getKey();
            FulfillmentCenter value=entry.getValue();
            if(value.size()==0)
            {
                temp.put(key, value);
            }
            System.out.println(key);


        }
        return temp;
    }
    public FulfillmentCenter get(String key){return magazyny.get(key);}
    //-------------------------TAK GENERALNIE WYGLADA PRZECHODZENIE PO MAPIE PRZEZ FOR EACH
    //        for(Map.Entry<String, FulfillmentCenter> entry: magazyny.entrySet()) {
    public void summary() {
        for(Map.Entry<String, FulfillmentCenter> entry: magazyny.entrySet()) {
            String key=entry.getKey();
            FulfillmentCenter value=entry.getValue();
            System.out.println(key +" Zajete miejsce w magazynie: " + value.getStorageCap());

        }
    }
}


