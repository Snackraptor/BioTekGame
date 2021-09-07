/** Project: BioTek Game - Class 2
 * Author: Lionel Pineda
 * Date: April 13, 2021
 * Time: 2:39 PM
 */

import java.util.Random;
public class BioTekHolder {

    //Instance Variables
    private String playerName;
    private int playerHp;
    private String playerWeapon;
    private int dinosaurHp = 2;
    public static int turnCount = 4;
    public static int itemsCollected;
    public static boolean lastHit = false;
    int[] diceRoll = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
    String[] itemArray = {"Rusty Combat Knife", "Mop", "Pistol", "Can of Pepper Spray"};

    //Random Item
    Random ranNum = new Random();

    //Default constructor
    public BioTekHolder(){

    }

    //Setters and getters
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setDinosaurHp(int dinosaurHp) {
        this.dinosaurHp = dinosaurHp;
    }

    public int getDinosaurHp() {
        return dinosaurHp;
    }

    public void setPlayerHp(int playerHp) {
        this.playerHp = playerHp;
    }

    public int getPlayerHp() {
        return playerHp;
    }

    public void setPlayerWeapon(String playerWeapon) {
        this.playerWeapon = playerWeapon;
    }

    public String getPlayerWeapon() {
        return playerWeapon;
    }

    //Methods

    //Method to print out player name backwards to user
    public void wordJumble(){
        for(int cycle = playerName.length()-1; cycle >= 0; cycle --){
            System.out.printf("%c ", playerName.charAt(cycle));
        }
    }

    //Closet item method
    public void closetItem(){
        itemsCollected++;
        playerWeapon = itemArray[ranNum.nextInt(4)];
        System.out.println("You have gained a: ");
        System.out.print(playerWeapon);
        System.out.println();
    }


    //Total item tally STATIC method
    public static void totalItemsCollected(){
        System.out.println("Total items collected: " + itemsCollected);
    }

    //Cheat code and easter egg method
    public String idScanner(String scanName){
        String scanAnswer;
        String nameScan = scanName.toLowerCase();

        switch (nameScan){
            case "darwin slater":
                scanAnswer = "***WELCOME BACK, DR. SLATER. COMMENCING ASSET CONTAINMENT AND ELIMINATION.***";
                dinosaurHp = 1;
                break;
            case "lionel pineda":
                scanAnswer = "***Hello Creator. This game was created by you in the year 2021!***";
                break;
            default:
                scanAnswer = "Keypad: \"ID validated. Please proceed.\"";
                break;
        }
        return scanAnswer;
    }

    //Alternate ending
    public void labDoorUnlock(){
        turnCount--;
        int skillRoll = diceRoll[ranNum.nextInt(20)];
        if(skillRoll > 8){
            System.out.printf("Before the dinosaur could lunge, you manage to open the door in time and escape through. " +
                    " %nLetting it shut behind you instantly with a loud thud.");
            System.out.printf("You decide it best to leave the creature in the confines of the laboratory." +
                    " %nThe disappearance of Darwin Slater was made quite clear that it was the result of an experiment gone wrong." +
                    " %nIt was time to head back to base and inform your company of the devastation that took place in BioTek.%n");
            System.out.println(winGame());
            System.exit(0);
        }else{
            System.out.println("In a panic, you drop your ID card and fail to open the doors in time.");
            System.out.println("The dinosaur instantly leapt up from close proximity and attacked you with tooth and claw!");
            System.out.println(loseGame());
            System.exit(0);
        }
    }

    //Method to print the status of the dinosaur as a number -
    // however will not be calling it to return the actual number to the player
    public void dinosaurStatus(){

        switch (dinosaurHp){
            case 1:
                System.out.println("The dinosaur is hobbling and breathing heavily, nearing exhaustion as if on death's door.");
                break;
            case 0:
                System.out.println("The dinosaur has been slain!");
                System.out.println(winGame());
                System.exit(0);
                break;
            default:
                System.out.println("The dinosaur has a lot of fight left in it and appears to be fiercely healthy.");
                break;
        }
    }

    //Player attack roll method
    public void playerAttack(){
        turnCount--;
        int hitRoll = diceRoll[ranNum.nextInt(20)];
        if(hitRoll > 5) {
            System.out.println("The attack hits!");
            dinosaurHp--;
            lastHit = true;
        }
        else{
            System.out.println("The attack missed!");
            lastHit = false;
        }
    }

    //Dinosaur attack roll method
    public void dinosaurAttack(){
        int hitRoll = diceRoll[ranNum.nextInt(20)];
        if(hitRoll > 4) {
            System.out.println("The dinosaur's attack hits you!");
            playerHp--;
        }else{
            System.out.println("The dinosaur's attack misses!");
        }
    }

    //Lose game static method
    public static String loseGame() {
            return "The dinosaur ended up eating you! You have lost the game! Try again!";
    }

    //Win game static method
    public static String winGame(){
        return "Congratulations! You have won the game!";
    }
}
