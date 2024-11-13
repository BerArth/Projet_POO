public abstract class Item {

    protected String name;

    public Item(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void printName(){
        System.out.println(this.name);
    }
}
