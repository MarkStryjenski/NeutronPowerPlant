package com;

import java.util.Scanner;

import com.Decorator.EnergyFactory;
import com.Materials.Material;
import com.setup;

public class Main {

    private static Scanner sc = new Scanner(System.in);
    private static boolean continueRunning = true;

    public static void main(String[] args) {
        // creates an object of Scanner


        System.out.println("----------------------------POWER PLANT----------------------------");
        System.out.print("Welcome to the Chernobyl power plant!!!!! \n ");
        System.out.println("You are in charge of running the performance test of nuclear power plant at Chernobyl!!! (What can go wrong?) " +
                "\n Your task is to add materials into the reactor, using this console application. " +
                "\n You choose how much material you can throw in to reactor, but WATCH OUT adding too much material will cause an meltdown" +
                "\n Warning systems are there to inform you if you should be careful or if meltdown is immanent" +
                "\n Finally you can also decide to upgrade your facility which will give you bonuses and will make your job easier" +
                "\n GOOD LUCK COMRADE");

        while (continueRunning)
        {
            System.out.print("Choose an action: \n a) Add Material \n b) Upgrade PowerPlant  \n e) Exit app \n");

            String chosenOption = sc.nextLine();

            evaluateInput(chosenOption);
        }
    }

    private static void evaluateInput(String input)
    {
        switch (input) {
            case "a":
                harvestEnergy();
                break;
            case "b":
                System.out.println("Upgrade in progress...");
                upgradePlant();
                break;
            case "e":
                System.exit(0);
                break;
            default:
                System.out.println("Invalid input");
                break;
        }
    }

    private static void harvestEnergy()
    {
        System.out.println("Choose the input material: \n a) Neutron particle \n b) Proton particle \n c) Ion particle");
        String chosenMaterial = sc.nextLine();
        Core selectedMaterial = getCoreFromInput(chosenMaterial);
        setup.basePowerPlant.setCore(selectedMaterial);
        System.out.println("Input amount: ");
        int amount = sc.nextInt();
        setup.basePowerPlant.harvestEnergyNew(amount);
    }

    private static Core getCoreFromInput(String input)
    {
        switch (input) {
            case "a":
                return setup.getNeutronCore();
            case "b":
                return setup.getProtonCore();
            case "c":
                return setup.getIonCore();
            default:
                System.out.println("Invalid input");
                break;
        }
        return null;
    }

    private static void upgradePlant()
    {
        int currentLevel = setup.basePowerPlant.getPlantLevel();
        switch (currentLevel) {
            case 0:
                setup.applyCoreUpgrade1();
                setup.basePowerPlant.setPlantLevel(1);
                break;
            case 1:
                setup.applyCoreUpgrade2();
                setup.basePowerPlant.setPlantLevel(2);
                break;
            case 2:
                setup.applyEarlyWarningSystem();
                setup.basePowerPlant.setPlantLevel(3);
                break;
            default:
                System.out.println("No further upgrades possible! Your plant is fully equipped.");
                break;
        }
        System.out.println("Power plant upgraded!");
    }
}
