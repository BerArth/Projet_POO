package Characters;

import Items.Bag;
import Items.Flacon;
import Items.Item;
import Items.Net;
import Locations.Room;


public class Hero extends Character {

    private Bag bag = null;
    private final int MAX_HP;

    public Hero(String name, String speach){
        super(name, 100, 5, speach);
        this.MAX_HP = 100;
    }

    public Bag getBag(){
        return this.bag;
    }

    public int getMAX_HP() {
        return MAX_HP;
    }

    public void setBag(Bag newBag) {
        if (this.bag != newBag) {  // Eviter boucle
            if (this.bag != null) {
                this.bag.unsetOwner();  // Retirer l'ancien sac
            }

            this.bag = newBag;  // Définir le nouveau sac

            if (newBag != null && newBag.getOwner() != this) {
                newBag.setOwner(this);  // Associer le sac au nouveau propriétaire
            }
            System.out.println("Great! Now you have a bag!");
        }
    }

    public void unsetBag() {
        if (this.bag != null) {
            this.bag.unsetOwner();  // Retirer la référence du sac
        }
        this.bag = null;  // Supprimer la référence du côté du sac
    }

    public void takeItemFromRoom(Room room, String nameItem) {
        Item item = room.getItem(nameItem);
        if (this.getBag() == null) {  // l'utilisateur n'a pas de sac
            if (nameItem.equals("Bag")) { // si l'item à ajouter est un sac
                this.setBag((Bag) item);
                room.removeItem(item);
            }
            else {  // l'item à ajouter n'est pas un sac et il n'a pas de sac
                System.out.println("You need a bag to add item.");
            }
        } else {  //l'utilisateur a un sac
            if(item != null){ // l'item est dans la pièce
                if(!nameItem.equals("Firefly") && !nameItem.equals("Gold")) {
                    if (!nameItem.equals("Bag")) {
                        if (this.getBag().addItem(item)) { // bool isAdd
                            System.out.println("You added item to the bag.");
                            room.removeItem(item);  // on supprime l'item de la pièce si ajout
                        }
                    }
                }else{  // l'item à prendre est une luciole
                    if(nameItem.equals("Firefly")){
                        if(this.getBag().haveItem("Net")){
                            Net net = (Net) this.getBag().getItem("Net");
                            net.Catch((Flacon) this.getBag().getItem("Flacon"));
                        }else{
                            System.out.println("You need a net to catch some fireflies.");
                        }
                    }else {
                        if(this.getBag().haveItem("Pickaxe")){
                            this.getBag().addItem(item);
                            room.removeItem(item);
                        }else{
                            System.out.println("You need a pickaxe.");
                        }
                    }
                }
            }else{  // l'item n'est pas dans la pièce
                System.out.println("This room don't have this item.");
            }
        }
    }

    public boolean haveWeaponInBag(){
        if(this.bag != null){
            return this.getBag().haveItem("Pickaxe");
        }
        return false;
    }

}
