package Items;

public abstract class Item {

    protected String name;
    protected String description;
    //protected int price;
    protected int weight;

    public Item(String name, int weight) {
        this.name = name;
        this.weight = weight;
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

    public void printDescription(){
        System.out.println(this.description);
    }
}
