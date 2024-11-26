package Items;

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
}
