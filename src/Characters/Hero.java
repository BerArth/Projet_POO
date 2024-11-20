package Characters;

import Items.Bag;

public class Hero extends Character {

    private Bag bag;

    public Hero(String name, String speach){
        super(name, 100, 20, speach);
        this.bag = null;
    }

    public Bag getBag(){
        return this.bag;
    }

    public void setBag(Bag bag) {
        this.bag = bag;
    }


}
