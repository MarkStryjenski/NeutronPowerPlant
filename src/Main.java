import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // creates an object of Scanner
        Scanner sc = new Scanner(System.in);
        System.out.println("----------------------------POWER PLANT----------------------------");
        System.out.print("Welcome to the power plant!!!!! \n ");

        System.out.print("Choose an action: \n a) Add Material \n b) Upgrade PowerPlant \n");

        while (sc.hasNext()) {
            try {
                String input = sc.next().toLowerCase();
                if (input.equals("a")) {
                    System.out.print("Add Material: \n 1) IonParticle \n 2) ProtonParticle \n 3) Go back \n");
                    while (sc.hasNext()) {
                        int inpAddMaterial = sc.nextInt();
                        if (inpAddMaterial == 1) {
                            System.out.println("Added IonParticle");
                        } else if (inpAddMaterial == 2) {
                            System.out.println("Proton Particle");
                        } else if (inpAddMaterial == 3) {
                            break;
                        }  else {
                            System.out.println("Wrong command, try again");
                        }
                    }
                } else if (input.equals("b")) {
                    while (sc.hasNext()) {
                        //Check how much cash user has
//                    if (userCash != 0) {
                        System.out.print("You currently have (amount of money player has) that much cash!" +
                                "Those are available upgrades: \n A)  \n B)  \n");
//                    }else{
//                        System.out.println("No cash no upgrades");
//                    }
                    }

                } else {
                    System.out.println("Wrong command, try again");
                }
            } catch (InputMismatchException ex) {
                System.out.println("That is not a number");
//                System.out.print("Add Material: \n 1) IonParticle \n 2) ProtonParticle \n");
                sc.nextLine();
            }

        }

        sc.close();
    }
}
