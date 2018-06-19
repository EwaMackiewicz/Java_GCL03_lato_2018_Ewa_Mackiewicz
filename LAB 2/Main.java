public class Main {
    public static void main(String args[])
    {
        FulfillmentCenter object=new FulfillmentCenter("Eurocash", 2000.00);


        Item it2=new Item("Zmywarka", ItemCondition.USED,50, 50);
        //object.addProduct(it2);


        Item it=new Item("Pralka", ItemCondition.NEW,40,40 );


        Item probny=new Item("Probny", ItemCondition.REFURBRISHED,20,20);
        object.addProduct(probny);
        object.summary();



        FulfillmentCenterContainer magazyn = new FulfillmentCenterContainer();
        magazyn.addCenter("Eurocash", 300.00);
        magazyn.get("Eurocash").addProduct(it2);
        magazyn.get("Eurocash").addProduct(it2);
        magazyn.get("Eurocash").addProduct(it2);
        magazyn.addCenter("PowinienBycPusty", 10.00);
// magazyn.findEmpty();
        magazyn.summary();
        magazyn.removeCenter("PowinienBycPusty");
        System.out.println("Po usunieciu magazynu");
        magazyn.summary();



    }

}
