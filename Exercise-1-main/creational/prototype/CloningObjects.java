package creational.prototype;

interface Character extends Cloneable {
    Character clone();
}

class GameCharacter implements Character {
    private String name;
    private String weapon;
    private String armor;

    public GameCharacter(String name, String weapon, String armor) {
        this.name = name;
        this.weapon = weapon;
        this.armor = armor;
    }

    @Override
    public Character clone() {
        try {
            return (Character) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    @Override
    public String toString() {
        return "GameCharacter [name=" + name + ", weapon=" + weapon + ", armor=" + armor + "]";
    }
}

public class CloningObjects {
    public static void main(String[] args) {

        GameCharacter warrior = new GameCharacter("Warrior", "Sword", "Iron Armor");

        GameCharacter archer = (GameCharacter) warrior.clone();
        archer.setWeapon("Bow");

        GameCharacter mage = (GameCharacter) warrior.clone();
        mage.setWeapon("Magic Staff");

        System.out.println(warrior);
        System.out.println(archer);
        System.out.println(mage);
    }
}
