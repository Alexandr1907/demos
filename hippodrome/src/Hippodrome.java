
import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    private List<Horse> horses;
    static Hippodrome game;


    public Hippodrome (List<Horse> horses){
        this.horses=horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public void run (){
        for (int i = 1; i <= 100; i++) {
            move();
            print();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    public void move() {
        for(Horse horse : horses){
            horse.move();
        }
    }
    public void print(){
        for(Horse horse : horses){
            horse.print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }
    public Horse getWinner(){
        Horse winner = null;
        for (Horse horse : horses){
            if (winner==null)winner=horse;
            else if (winner.getDistance()<horse.getDistance()) winner = horse;
        }
        return winner;
    }
    public void printWinner(){
        System.out.println("Winner is "+getWinner().getName()+"!");
    }
    public static void main(String[] args) {
        game = new Hippodrome(new ArrayList<>());
        Horse horse1=new Horse("Mustang", 3, 0);
        Horse horse2=new Horse("Plotva", 3, 0);
        Horse horse3=new Horse("Chado", 3, 0);
        game.getHorses().add(horse1);
        game.getHorses().add(horse2);
        game.getHorses().add(horse3);
        game.run();
        game.printWinner();
    }
}
