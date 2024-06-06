public class Arbitre extends AbstractPerson implements GameParticipant {
    private int experience;

    public Arbitre(String name, int age, int experience) {
        super(name, age);
        this.experience = experience;
    }

    @Override
    public void displayDetails() {
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Experience: " + experience + " years");
    }

}
