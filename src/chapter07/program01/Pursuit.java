package chapter07.program01;

public class Pursuit {
    SchoolGirl mm;

    public Pursuit(SchoolGirl mm) {
        this.mm = mm;
    }

    public void giveDolls(){
        System.out.println(mm.getName() + "送你洋娃娃");
    }

    public void giveFlowers(){
        System.out.println(mm.getName() + "送你鲜花");
    }

    public void giveChocolate(){
        System.out.println(mm.getName() + "送你巧克力");
    }
}
