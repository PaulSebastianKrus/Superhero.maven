import java.util.Scanner;

public class Superhero {
    private String name;
    private String realName;
    private String superPower;
    private int yearCreated;
    private String isHuman;
    private int strength;


    public String getName() {
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getRealName() {
        return realName;
    }
    public void setRealName(String realName){
        this.realName = realName;
    }

    public String getSuperPower() {
        return superPower;
    }
    public void setSuperPower(String superPower){
        this.superPower = superPower;
    }

    public int getYearCreated() {
        return yearCreated;
    }

    public void setYearCreated(int yearCreated) {
        this.yearCreated = yearCreated;
    }

    public String getIsHuman() {
        return isHuman;
    }

    public void setIsHuman(String isHuman) {
        this.isHuman = isHuman;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public Superhero(String name, String realName, String superPower, int yearCreated, String isHuman, int strength) {
        this.name = name;
        this.realName = realName;
        this.superPower = superPower;
        this.yearCreated = yearCreated;
        this.isHuman = isHuman;
        this.strength = strength;
    }


    public String toString() {
        return "Name: " + name + "\nAlias: " + realName + "\nPower: " + superPower + "\nYear: " + yearCreated + "\nHuman?: " + isHuman + "\nStrength: " + strength;
    }


    public static void displaySuperheroDetails(Superhero superhero) {
        System.out.println("Superhelt Information:");
        System.out.println("------------------------------");
        System.out.println("Navn: " + superhero.getName());
        System.out.println("Real Name: " + superhero.getRealName());
        System.out.println("Super Power: " + superhero.getSuperPower());
        System.out.println("Year Created: " + superhero.getYearCreated());
        System.out.println("Is Human: " + superhero.getIsHuman());
        System.out.println("Strength: " + superhero.getStrength());
        System.out.println("------------------------------");
    }
}











