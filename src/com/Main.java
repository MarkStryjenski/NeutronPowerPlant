package com;

import java.util.Scanner;

public class Main {

    private static final Scanner sc = new Scanner(System.in);
    private static boolean continueRunning = true;

    public static void main(String[] args) {
        // creates an object of Scanner

        SetUp.subscribe();

        introduction();

        while (continueRunning)
        {
            System.out.print("Choose an action: \n a) Add Material \n b) Upgrade PowerPlant  \n e) Exit app \n");

            String chosenOption = sc.next();

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
        String chosenMaterial = sc.next();
        Core selectedMaterial = getCoreFromInput(chosenMaterial);
        SetUp.basePowerPlant.setCore(selectedMaterial);
        System.out.println("Input amount: ");
        int amount = sc.nextInt();
        SetUp.basePowerPlant.harvestEnergyNew(amount);
    }

    private static Core getCoreFromInput(String input)
    {
        switch (input) {
            case "a":
                return SetUp.getNeutronCore();
            case "b":
                return SetUp.getProtonCore();
            case "c":
                return SetUp.getIonCore();
            default:
                System.out.println("Invalid input");
                break;
        }
        return null;
    }

    private static void upgradePlant()
    {
        int currentLevel = SetUp.basePowerPlant.getPlantLevel();
        switch (currentLevel) {
            case 0:
                SetUp.applyCoreUpgrade1();
                SetUp.basePowerPlant.setPlantLevel(1);
                System.out.println("Power plant upgraded!");
                break;
            case 1:
                SetUp.applyCoreUpgrade2();
                SetUp.basePowerPlant.setPlantLevel(2);
                System.out.println("Power plant upgraded!");
                break;
            case 2:
                SetUp.applyEarlyWarningSystem();
                SetUp.basePowerPlant.setPlantLevel(3);
                System.out.println("Power plant upgraded!");
                break;
            default:
                System.out.println("No further upgrades possible! Your plant is fully equipped.");
                break;
        }
    }

    public static void introduction(){
        System.out.println("----------------------------POWER PLANT----------------------------");
        System.out.print("Welcome to the Chernobyl power plant!!!!! \n ");
        System.out.println("You are in charge of running the performance test of nuclear power plant at Chernobyl!!! (What can go wrong?) " +
                "\n Your task is to add materials into the reactor, using this console application. " +
                "\n You choose how much material you can throw in to reactor, but WATCH OUT adding too much material will cause an meltdown" +
                "\n Warning systems are there to inform you if you should be careful or if meltdown is immanent" +
                "\n Finally you can also decide to upgrade your facility which will give you bonuses and will make your job easier" +
                "\n GOOD LUCK COMRADE");
    }
}
