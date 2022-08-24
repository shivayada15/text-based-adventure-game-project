package TBAG;

import java.util.Random;
import java.util.Scanner;
public class Main{
	public static void main(String[] args) {
		// objects
		Scanner in =new Scanner(System.in);
		Random rand= new Random();
		
		//game variables
		String[] enemies= { "skeleton","zombie", "warrior","Assassin"};
		int maxEnemyHealth =75;
		int enemyAttackDamage =25;
		//player variables
		int health=100;
		int attackDamage= 50;
		int numHealthPotions =3;  
		int healthpotionHealAmount=30;
		int healthpotionDropChance=50;
		boolean running =true;
		System.out.println("Welcome too the Dungeon!");
		
		GAME:
		while(running) {
			System.out.println("--------------------------------------");
			int enemyHealth= rand.nextInt(maxEnemyHealth);
			String enemy =enemies[rand.nextInt(enemies.length)];
			System.out.println("\t# " +enemy + "appeared! #\n");
			while(enemyHealth >0) {
				System.out.println("\tYour Hp:" +health);
				System.out.println("\t" + enemy + "'s HP :" + enemyHealth);
				System.out.println("\n\tWHat would yoou like to do?");
				System.out.println("\t1. Attack");
				System.out.println("\t2. Drink health potion");
				System.out.println("\t3. Run!");
				String input= in.nextLine();
				if(input.equals("1")) {
					int damageDealt =rand.nextInt(attackDamage);
					int damageTaken =rand.nextInt(enemyAttackDamage);
					enemyHealth -= damageDealt;
					health -= damageTaken;
					System.out.println("\t> You strike the "+ enemy + "for" + damageDealt + "damage.");
					System.out.println("\t> You recieve  " + damageTaken + " in installation!");
					if(health <1) {
						System.out.println("\t> You have taken too much damage, you are too weak to go ");
					}
				}else if(input.equals("2")) {
					if(numHealthPotions > 0) {
						health += healthpotionHealAmount;
						numHealthPotions--;
						System.out.println("\t> YOu drink a health ppotion, healing yourself for" + healthpotionHealAmount +
								"\n\t> You now have "+ health+ "HP"+ "\n\t> You have " + numHealthPotions + "health posions left \n");
					}else {
						System.out.println("\t> You have no health potioons left : Defeat enemies for a chance to get one! \n");
					}
					
				}else if(input.equals("3")) { //run
					System.out.println("\t You run away from the" + enemy+ "!");
					continue GAME;
					
				}else {
					System.out.println("\tInvalid command! ");
					
				}
			}
			if(health< 1) {
				System.out.println("You limp out of the dunfeoon , weak from battle.");
				break;
				
			}
			System.out.println("--------------------------------");
			System.out.println("#" + enemy + " was  defeated! #");
			System.out.println("# You have " + health + "HP left. #");
			if(rand.nextInt(100) < healthpotionDropChance) {
				numHealthPotions++;
				System.out.println(" # The " + enemy + " dropped a health potion! #");
				System.out.println(" # You now have " + numHealthPotions + "health potion(s). #");
			}
			System.out.println("------------------------");
			System.out.println("What would you like to do now ?");
			System.out.println("1. Continue fighting");
			System.out.println("2. Exit dungen");
			String input= in.nextLine();
			while(!input.equals("1") && !input.equals("2")) {
				System.out.println("Invalid command!");
				input=in.nextLine();
			}
			if(input.equals("1")) {
				System.out.println("You continue oon your adventure!");
				
			}else if(input.equals("2")) {
				System.out.println("You exit the dungeon, successful frooom your adventures!");
				break;
			}
			
		}
		System.out.println("#####################################");
		System.out.println("THANKS FOR PLAYING");
		System.out.println("#####################################");
		
		
	}
}