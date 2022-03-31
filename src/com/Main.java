package com;

import com.Alarm.AlarmSystem;
import com.Alarm.state.State;
import com.Decorator.EnergyFactory;
import com.Decorator.Upgrades.CoreUpgrade1;
import com.Decorator.Upgrades.CoreUpgrade2;
import com.Decorator.Upgrades.EarlyWarningSystem;
import com.Materials.IonParticle;
import com.Materials.Material;
import com.Materials.ProtonParticle;
import com.Materials.NeutronParticle;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // creates an object of Scanner
        Scanner sc = new Scanner(System.in);

        EnergyFactory energyFactory = new EnergyFactory() {
            @Override
            public void update(String eventType, State state)
            {

            }

            @Override
            public EnergyPackage harvestEnergy(int amount, Core core) {
                return null;
            }

            @Override
            public void activateAlert() {

            }

            @Override
            public void toWarning() {

            }

            @Override
            public void setTotalUnits(EnergyPackage energyPackage)
            {

            }

            @Override
            public void setCore(Core core)
            {

            }

            @Override
            public Core getCore()
            {
                return null;
            }

            @Override
            public AlarmSystem getAlarmSystem()
            {
                return null;
            }
        };
        Material neutronParticle = new NeutronParticle();
        Material protonParticle = new ProtonParticle();
        Material ionParticle = new IonParticle();
        Core core1 = new Core(neutronParticle);
        Core core2 = new Core(protonParticle);
        Core core3 = new Core(ionParticle);

        AlarmSystem alarmSystem = new AlarmSystem("meltdown", "warning", "workingProperly");

        PowerPlant powerPlant = new PowerPlant(core1, 21.0, energyFactory, alarmSystem);

        EnergyFactory newBasePowerPlant = new PowerPlant(core1, 21.0, energyFactory, alarmSystem);
        newBasePowerPlant.getAlarmSystem().subscribe("meltdown",newBasePowerPlant);
        newBasePowerPlant.getAlarmSystem().subscribe("warning",newBasePowerPlant);

        System.out.println("----------------------------POWER PLANT----------------------------");
        System.out.print("Welcome to the Chernobyl power plant!!!!! \n ");
        System.out.println("You are in charge of running the performance test of nuclear power plant at Chernobyl!!! (What can go wrong?) " +
                "\n Your task is to add materials into the reactor, using this console application. " +
                "\n You choose how much material you can throw in to reactor, but WATCH OUT adding too much material will cause an meltdown" +
                "\n Warning systems are there to inform you if you should be careful or if meltdown is immanent" +
                "\n Finally you can also decide to upgrade your facility which will give you bonuses and will make your job easier" +
                "\n GOOD LUCK COMRADE");
        System.out.print("Choose an action: \n a) Add Material \n b) Upgrade PowerPlant  \n");

        while (sc.hasNext()) {
            try {
                String input = sc.next().toLowerCase();
                if (input.equals("a")) {
                    if(powerPlant.getCoreLvl()==0){
                        System.out.print("Add Material: \n 1) NeutronParticle \n 4) Go back \n");
                    }else if(powerPlant.getCoreLvl()==1 || powerPlant.getCoreLvl()==2){
                        System.out.print("Add Material: \n 1) NeutronParticle \n 2) ProtonParticle  \n 4) Go back \n");
                    }else if(powerPlant.getCoreLvl()==3){
                        System.out.print("Add Material: \n 1) NeutronParticle \n 2) ProtonParticle \n 3) IonParticle \n 4) Go back \n");
                    }
                    while (sc.hasNext()) {
                        int inpAddMaterial = sc.nextInt();
                        if (inpAddMaterial == 1) {
                            System.out.println("How much material you want to add:");
                            int amountInserted = sc.nextInt();
                            newBasePowerPlant.setCore(core1);
                            EnergyPackage result = newBasePowerPlant.harvestEnergy(amountInserted, newBasePowerPlant.getCore());
                            if(result != null){
                                newBasePowerPlant.setTotalUnits(result);
                                System.out.println("Added Neutron");
                            }
                        } else if (inpAddMaterial == 2) {
                            System.out.println("How much material you want to add:");
                            int amountInserted = sc.nextInt();
                            newBasePowerPlant.setCore(core2);
                            EnergyPackage result = newBasePowerPlant.harvestEnergy(amountInserted, newBasePowerPlant.getCore());
                            if (result == null) {
                                System.out.println("You are not allowed to use Proton Particle");
                            } else {
                                newBasePowerPlant.setTotalUnits(result);
                                System.out.println("Added Proton");
                            }
                        } else if (inpAddMaterial == 3) {
                            System.out.println("How much material you want to add:");
                            int amountInserted = sc.nextInt();
                            newBasePowerPlant.setCore(core3);
                            EnergyPackage result = newBasePowerPlant.harvestEnergy(amountInserted, newBasePowerPlant.getCore());
                            if (result == null) {
                                System.out.println("You are not allowed to use Ion Particle");
                            } else {
                                powerPlant.setTotalUnits(result);
                                System.out.println("Added IonParticle");
                            }
                        } else if (inpAddMaterial == 4) {
                            System.out.print("\nChoose an action: \n a) Add Material \n b) Upgrade PowerPlant  \n");
                            break;
                        } else {
                            System.out.println("Wrong command, try again");
                        }
                        System.out.print("\nChoose an action: \n a) Add Material \n b) Upgrade PowerPlant  \n");
                        break;
                    }
                } else if (input.equals("b")) {
                    System.out.print("Do you want to upgrade facility?" +
                            " \n y)yes  \n n)no \n");
                    while (sc.hasNext()) {
                        String inputUpgrade = sc.next().toLowerCase();
                        if (inputUpgrade.equals("y")) {
                            if (powerPlant.getCoreLvl() == 0) {
                                newBasePowerPlant = new CoreUpgrade1(newBasePowerPlant);
                                powerPlant.setCoreLvl(1);
                            } else if (powerPlant.getCoreLvl() == 1) {
                                newBasePowerPlant = new EarlyWarningSystem(newBasePowerPlant, alarmSystem);
                                powerPlant.setCoreLvl(2);
                            } else if (powerPlant.getCoreLvl() == 2) {
                                newBasePowerPlant = new CoreUpgrade2(newBasePowerPlant);
                                powerPlant.setCoreLvl(3);
                            } else {
                                System.out.println("No more upgrades available");
                            }
                        } else if (inputUpgrade.equals("n")) {
                            break;
                        } else {
                            throw new InputMismatchException();
                        }
                        System.out.print("Choose an action: \n a) Add Material \n b) Upgrade PowerPlant  \n");
                        break;
                    }
                } else {
                    throw new InputMismatchException();
                }
            } catch (InputMismatchException ex) {
                System.out.println("Make sure your input type is in accordance with the options");
                System.out.print("Choose an action: \n a) Add Material \n b) Upgrade PowerPlant  \n");
                sc.nextLine();
            }

        }
        sc.close();
    }
}
