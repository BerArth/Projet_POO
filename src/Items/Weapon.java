package Items;
public class Weapon extends Item {

    private int Damage;

    public Weapon(String name, int damage) {
        super(name);
        this.Damage = damage;
    }

    public int getDamage() {
        return this.Damage;
    }
    public void setDamage(int damage) {
        this.Damage = damage;
    }


}
