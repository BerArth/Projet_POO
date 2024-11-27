package Items;

import java.util.Objects;

public abstract class Item {

    protected String name;
    protected String description;
    //protected int price;
    protected int weight;

    public Item(String name, int weight, String description) {
        this.name = name;
        this.weight = weight;
        this.description = description;
    }

    public String getName(){
        return this.name;
    }

    public String getDescription(){
        return this.description;
    }

    public void printName(){
        System.out.println(this.name);
    }

    public int getWeight(){
        return this.weight;
    }

    public void printDescription(){
        System.out.println(this.description);
    }


    //mandatory for the retailer otherwise the haveitem will not work
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Item item = (Item) obj;
        return name.equals(item.name);
    }

}
