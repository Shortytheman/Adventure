import java.util.ArrayList;
import java.util.Random;

public class MeleeWeapon extends Weapon{
    int durability = 200;
    int damage = 20;
    public MeleeWeapon(String name, int damage) {
        this.name = name;
        this.damage = damage;
        this.prefix = nonConsumablePrefix();
        this.suffix = nonConsumableSuffix();
    }
    public MeleeWeapon() {
        this.name = nonConsumableName();
        this.prefix = nonConsumablePrefix();
        this.suffix = nonConsumableSuffix();
    }
    public String nonConsumableName() {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("axe");
        strings.add("hammer");
        strings.add("sword");
        strings.add("dagger");
        Random rand = new Random();
        int random = rand.nextInt(strings.size());
        return strings.get(random);
    }

    public String nonConsumablePrefix() {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("dirty old");
        strings.add("shiny");
        strings.add("damn good looking");
        strings.add("worn out");
        strings.add("giddi'up looking");
        Random rand = new Random();
        int random = rand.nextInt(strings.size());
        return strings.get(random);
    }

    public String nonConsumableSuffix() {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("with some dust on it");
        strings.add("that has seen better days");
        strings.add("that looks good to me");
        strings.add("i wonder what i can use this for");
        strings.add("what a strange thing to find");
        Random rand = new Random();
        int random = rand.nextInt(strings.size());
        return strings.get(random);
    }
}
