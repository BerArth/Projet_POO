package Characters;

import Items.Bag;

public class Hero extends Character {

    private Bag bag;

    public Hero(String name){
        super(name, 100, 20);
        this.bag = null;
    }

    public Bag getBag(){
        return this.bag;
    }

    public void setBag(Bag bag) {
        this.bag = bag;
    }

    @Override
    public void speek() {
    }
}
