/** Project: BioTek Game
 * Author: Lionel Pineda
 * Date: April 13, 2021
 * Time: 2:38 PM
 */

import java.util.Scanner;
public class BioTekGame {
    public static void main(String[] args) {

        //Instantiating a new game object
        BioTekHolder newGame = new BioTekHolder();

        //Game start welcome
        System.out.println("Welcome to BioTek!");
        System.out.println("Where dreams are only a DNA-splice away!");

        //Asterisk line
        for(int i=0; i < 25; i++){
            System.out.print("*");
        }

        //Game details
        System.out.println();
        System.out.printf("You have been hired on as a contracted scientist with a military background. " +
                "%nThe mission given to you was to find out what sort of work was being done at BioTek and " +
                "to investigate the disappearance of Darwin Slater. %nYou are given a white lab coat " +
                "and BioTek brand satchel. %nUpon entering the building, you are taken to a bright room that " +
                "smells of bleach and antiseptic. It is quiet here, with no one present aside from a single terminal");
        System.out.println();

        //Asterisk line
        for(int i=0; i < 25; i++){
            System.out.print("*");
        }

        //Game phase one - Name input
        System.out.println();
        System.out.println("Walking up to the terminal you can read: " +
                "\"Welcome to BioTek! We have been expecting your arrival __ERROR__. Please input your name for an ID card.\" ");
        System.out.println("Type your character name:");

        //Scanner input
        Scanner in = new Scanner(System.in);

        //Player answer
        String gameReplyOne = in.nextLine();

        //Setting character name
        newGame.setPlayerName(gameReplyOne);
        newGame.setPlayerHp(3);

        //Game Phase One Complete
        System.out.println("Once you hit return, a name tag is printed out on an ID card. " +
                "Your name is now: " + newGame.getPlayerName() + " for your ID");

        //Setting default weapon to fists
        newGame.setPlayerWeapon("fists");

        //adding item as ID card
        BioTekHolder.itemsCollected++;
        System.out.println("You have " + newGame.getPlayerHp() + " HP");
        System.out.println("The terminal let out a beep and printed another automated message: \"Please proceed through the main doors.\"");

        //Game Phase two - Starting room
        while(true) {

            System.out.println("You are presented with two choices - 1: Enter through the double doors. or 2: Stay and meddle with the terminal.");
            System.out.println("Please select your choice. (1 or 2)");

            //Player answer Two
            try {

            int gameReplyTwo = in.nextInt();

                if (gameReplyTwo == 1) {
                    System.out.println("You enter through the large double doors, leading into a dim-light hallway.");
                    break;
                } else if (gameReplyTwo == 2) {
                    System.out.println("You decide to try your luck and begin fiddling with the computer terminal's systems.");
                    System.out.println("The terminal returns your name in an odd fashion.");
                    newGame.wordJumble();
                    System.out.println();
                    System.out.println("After disabling out the terminal security, you decide it best to continue through the double doors that lead into a dim-light hallway.");
                    System.out.println();
                    break;
                } else {
                    System.out.println("Invalid Selection");
                }

            } catch (Exception e){
                System.out.println("Invalid response, closing application.");
                System.exit(0);
                break;
            }
        }

        //Asterisk line
        for(int i=0; i < 25; i++){
            System.out.print("*");
        }

        //Game phase 3 - Hallway
        System.out.println();
        System.out.println("The hallway leads towards another pair of large double doors with cracked windows. There is a" +
                " a flickering yellow light on the other side but no other movement. To your left there is a single door marked" +
                " \"Utility Closet\".");

        while(true) {
            System.out.println("What would you like to do? 1: Go through the double doors and investigate where everyone else is." +
                    " or 2: Check the utility closet. (Choose 1 or 2)");

            try {
                int gameReplyThree = in.nextInt();

                if (gameReplyThree == 1) {
                    System.out.println("The double doors are heavy and locked. There is a keypad with a scanner at the to the side of the door." +
                            " You apply your BioTek ID to the scanner and the machines whirl and click.");

                    //Checking for easter egg or cheat code
                    System.out.println(newGame.idScanner(newGame.getPlayerName()));
                    System.out.println("The doors unlock and you make your way into the next area.");
                    break;
                }
                else if (gameReplyThree == 2) {
                    System.out.println("The closet is unlocked. You begin searching through messy closet for anything of use.");
                    newGame.closetItem();
                    System.out.println("After collecting your item, you return to the hallway and meet with the double doors. There is a keypad with a scanner beside the door." +
                            " You apply your BioTek ID to the scanner and the machines whirl and click.");

                    //Checking for easter egg or cheat code
                    System.out.println(newGame.idScanner(newGame.getPlayerName()));
                    System.out.println("The doors unlock and you make your way into the next area.");
                    break;
                }
                else {
                    System.out.println("Please select a proper answer.");
                }
            }
            catch(Exception e){
                System.out.println("Invalid response, closing application.");
                System.exit(0);
                break;
            }
        }

        //Game phase 4 - The Fight

        for(int i=0; i < 25; i++){
            System.out.print("*");
        }

        System.out.println();
        System.out.printf("The double doors shut behind you with a metallic slam. The flickering light above was revealed to be a yellow warning light with a rotating holographic screen reading:" +
                " \"ASSET OUT OF CONTAINMENT\". %nThere were no scientists to be found or signs of life anywhere. %nThe cubicles and lab stations were all torn apart with broken glass and chemicals" +
                " left strewn about chaotically. Danger was nearby and a sharp jolt would shoot up your spine in fear. %nA large leathery figure would rise from a pile" +
                " of gathered prey. Its eyes were black and hungry as its head would crane forward much like a bird. It leapt up onto a lab table with powerful hind-legs and let" +
                " out a monstrous screech. %nThere was no other option than to fight as the monster flared its nostrils and bared its rows of sharp teeth caked in toxic saliva.%n");

        //Player turn one
        while(true) {

            System.out.println("Your instincts allow you to act first! What would you like to do? 1: Use whatever item you found against the dinosaur and attempt to knock it on the ground!" +
                    " or 2: Try to take cover behind a cubicle and search for an item.");
            System.out.println("Please select your choice. (1 or 2)");

            //Player Answer Four
            try {

                int gameReplyFour = in.nextInt();

                if (gameReplyFour == 1) {
                    System.out.println("You use your " + newGame.getPlayerWeapon() + " against the dinosaur!");
                    newGame.playerAttack();
                    break;
                } else if (gameReplyFour == 2) {
                    System.out.println("You run into the nearest cubicle for cover, taking the short time to quickly search for something of use");
                    System.out.println("You find a health pack! (+1 HP)");
                    newGame.setPlayerHp(4);
                    System.out.println("You feel stronger and more confident, but the monstrous creature continues to pursue you.");
                    break;
                } else {
                    System.out.println("Invalid Selection");
                }

            } catch (Exception e){
                System.out.println("Invalid response, closing application.");
                System.exit(0);
                break;
            }
        }

        //Dinosaur Turn
        for(int i=0; i < 25; i++){
            System.out.print("*");
        }
        System.out.println();

        if(BioTekHolder.lastHit){
            System.out.println("The dinosaur flails in pain and falls off of the table with a crash into the ground, taking some of the lab equipment on the counter with it.");
            newGame.dinosaurStatus();
            System.out.println("It then claws back up, its talons screeching across the tiled floor as it finally stood back up." +
                    " Once it caught your scent, the dinosaur tries to viciously bite you!");
            newGame.dinosaurAttack();
        }else if(!BioTekHolder.lastHit){
            newGame.dinosaurStatus();
            System.out.println("The dinosaur locked onto you and soon leapt through the air, trying attack you with gouging claws and razor sharp teeth!");
            newGame.dinosaurAttack();
        }
        System.out.println();

        //Player turn two
        while(true) {

            System.out.println(newGame.getPlayerName() + " status: " + newGame.getPlayerHp());
            System.out.println("The dinosaur was relentless and looked as if it was about to pounce again. The creature's mouth was open wide in a menacing manner.");

            //Player Answer Five
            try {
            System.out.println("What would you like to do? 1: Attack the dinosaur or 2: Try to escape the cubicle and evade the dinosaur's attack.");
            System.out.println("Please select your choice. (Choose 1 or 2)");

                int gameReplyFive = in.nextInt();

                if (gameReplyFive == 1) {
                    System.out.println("Once more you use your " + newGame.getPlayerWeapon() + " against the dinosaur!");
                    newGame.playerAttack();
                    break;
                } else if (gameReplyFive == 2) {
                    System.out.println("You attempt to escape the cubicle with the dinosaur hot on your trail");
                    System.out.println("Before you gain any leverage to pull yourself up and over, the dinosaur attacks you!");
                    BioTekHolder.lastHit = false;
                    newGame.dinosaurAttack();
                    break;
                } else {
                    System.out.println("Invalid Selection");
                }

            } catch (Exception e){
                System.out.println("Invalid response, closing application.");
                System.exit(0);
                break;
            }
        }

        //Dinosaur Turn Two
        for(int i=0; i < 25; i++){
            System.out.print("*");
        }
        System.out.println();

        if(BioTekHolder.lastHit){
            System.out.println("The dinosaur falters backwards and recoils, grabbing at its snout with clawed hands as it let out a cawing cry.");
            newGame.dinosaurStatus();
            System.out.println("Once it had a moment to recover, it leapt up into the air using its large hooked talons to try to latch onto you and claw you!");
            newGame.dinosaurAttack();
        }else if(!BioTekHolder.lastHit){
            newGame.dinosaurStatus();
            System.out.println("Without hesitation, the dinosaur attacked you again! It took large bites at you and swung its claws in a frenzy to land any strike.");
            newGame.dinosaurAttack();
        }
        System.out.println();

        //Win/lose Check
        if(newGame.getPlayerHp() == 0 || BioTekHolder.turnCount == 0){
            System.out.println(BioTekHolder.loseGame());
            BioTekHolder.totalItemsCollected();
            System.exit(0);
        }else if(newGame.getDinosaurHp() <= 0){
            System.out.println(BioTekHolder.winGame());
            BioTekHolder.totalItemsCollected();
            System.exit(0);
        }

        //Player turn three
        while(true) {

            System.out.println(newGame.getPlayerName() + " status: " + newGame.getPlayerHp());
            System.out.printf("The dinosaur let out a hooting cry in frustration. Its hot and rancid breath filling the room as it stood on its hind-legs, its eyes filled with primal anger." +
                    " %nYou meet its gaze with a determined look of your own, this time taking the initiative to move first.%n");

            //Player Answer Six
            try {
                System.out.println("What would you like to do? 1: Attack the dinosaur. or 2: Try to escape the room by making a run for the door!");
                System.out.println("Please select your choice. (Choose 1 or 2)");

                int gameReplySix = in.nextInt();

                if (gameReplySix == 1) {
                    System.out.println("You use your " + newGame.getPlayerWeapon() + " against the dinosaur!");
                    newGame.playerAttack();
                    break;
                } else if (gameReplySix == 2) {
                    System.out.println("Your boots hit the ground in a frenzy as you sprint towards the double doors.");
                    System.out.println("The dinosaur looks puzzled at first but soon lets out a ear-piercing screech and begins chasing after you.");
                    System.out.println("It lunges at you from the short distance and tries to latch onto your back with sharp talons.");
                    BioTekHolder.lastHit = false;
                    newGame.dinosaurAttack();
                    break;
                } else {
                    System.out.println("Invalid Selection");
                }

            } catch (Exception e){
                System.out.println("Invalid response, closing application.");
                System.exit(0);
                break;
            }
        }

        //Win/lose Check
        if(newGame.getPlayerHp() == 0 || BioTekHolder.turnCount == 0){
            System.out.println(BioTekHolder.loseGame());
            BioTekHolder.totalItemsCollected();
            System.exit(0);
        }else if(newGame.getDinosaurHp() <= 0){
            System.out.println(BioTekHolder.winGame());
            BioTekHolder.totalItemsCollected();
            System.exit(0);
        }

        //Dinosaur Turn Three
        for(int i=0; i < 25; i++){
            System.out.print("*");
        }
        System.out.println();

        if(BioTekHolder.lastHit){
            System.out.println("Doubles over in pain, nearly collapsing but manages to stand with a dazed expression.");
            newGame.dinosaurStatus();
        }else if(!BioTekHolder.lastHit){
            newGame.dinosaurStatus();
            System.out.println("The primal creature gave no mercy and it continued lashing towards you with tooth and claw!");
            newGame.dinosaurAttack();
        }
        System.out.println();

        //Win/lose Check
        if(newGame.getPlayerHp() == 0 || BioTekHolder.turnCount == 0){
            System.out.println(BioTekHolder.loseGame());
            BioTekHolder.totalItemsCollected();
            System.exit(0);
        }else if(newGame.getDinosaurHp() <= 0){
            System.out.println(BioTekHolder.winGame());
            BioTekHolder.totalItemsCollected();
            System.exit(0);
        }

        //Player turn four
        while(true) {

            System.out.println(newGame.getPlayerName() + " status: " + newGame.getPlayerHp());
            System.out.printf("The monstrous figure weaved across the lab counters in the room, trying to find a way to flank you." +
                    " %nIts loud snarls and chirps could be heard as it dashed about the area.%n");

            //Player Answer Seven
            try {
                System.out.println("What would you like to do? 1: Chase and attack the dinosaur. or 2: Make another attempt to escape the room by using your ID card on the keypad.");
                System.out.println("Please select your choice. (Choose 1 or 2)");

                int gameReplySix = in.nextInt();

                if (gameReplySix == 1) {
                    System.out.println("You counter the creature with your own pattern across the lab counters until you are close enough to use your " + newGame.getPlayerWeapon() + " against the dinosaur!");
                    newGame.playerAttack();
                    break;
                } else if (gameReplySix == 2) {
                    System.out.println("Using what spare time you have, you turn around and head for the door with ID card in hand.");
                    System.out.println("The monstrous figure bobs in from the side, low to the ground in a stalking fashion. It was poised to attack one more.");
                    newGame.labDoorUnlock();
                    break;
                } else {
                    System.out.println("Invalid Selection");
                }

            } catch (Exception e){
                System.out.println("Invalid response, closing application.");
                System.exit(0);
                break;
            }
        }

        //Win/lose Check
        if(newGame.getPlayerHp() == 0 || BioTekHolder.turnCount == 0){
            System.out.println(BioTekHolder.loseGame());
            BioTekHolder.totalItemsCollected();
            System.exit(0);
        }else if(newGame.getDinosaurHp() <= 0){
            System.out.println(BioTekHolder.winGame());
            BioTekHolder.totalItemsCollected();
            System.exit(0);
        }

    }
}
