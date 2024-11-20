package Characters;

import Items.*;

import java.util.List;

public class Retailer extends Character{

    private Item Possededitems;
    private Item  WantedItems;
    private int price;


    public Retailer(String name, String speach, Item wanteditems, Item possededitems, int price){
        super(name, 1, 0, speach);
        Possededitems = possededitems;
        WantedItems = wanteditems;
        this.price = price;
    }

//    public void exchange(Bag bag){
//        if(bag.containItem(WantedItems)){
//            bag.removeItem(WantedItems);
//            bag.addItem(Possededitems);
//        }else{
//            System.out.printf("I need " + this.price + this.WantedItems);
//        }
//    }

}
