package com;

import com.Alarm.AlarmSystem;
import com.Decorator.EnergyFactory;
import com.Decorator.FactoryDecorator;
import com.Decorator.Upgrades.CoreUpgrade1;
import com.Decorator.Upgrades.EarlyWarningSystem;
import com.Materials.Material;
import com.Materials.ProtonParticle;
import com.Materials.neutronParticle;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // creates an object of Scanner
//        Scanner sc = new Scanner(System.in);
//        System.out.println("----------------------------POWER PLANT----------------------------");
//        System.out.print("Welcome to the power plant!!!!! \n ");

//        System.out.print("Choose an action: \n a) Add Material \n b) Upgrade com.PowerPlant \n");

//        while (sc.hasNext()) {
//            try {
//                String input = sc.next().toLowerCase();
//                if (input.equals("a")) {
//                    System.out.print("Add Material: \n 1) IonParticle \n 2) ProtonParticle \n 3) Go back \n");
//                    while (sc.hasNext()) {
//                        int inpAddMaterial = sc.nextInt();
//                        if (inpAddMaterial == 1) {
//                            System.out.println("Added IonParticle");
//                        } else if (inpAddMaterial == 2) {
//                            System.out.println("Proton Particle");
//                        } else if (inpAddMaterial == 3) {
//                            break;
//                        }  else {
//                            System.out.println("Wrong command, try again");
//                        }
//                    }
//                } else if (input.equals("b")) {
//                    while (sc.hasNext()) {
//                        //Check how much cash user has
////                    if (userCash != 0) {
//                        System.out.print("You currently have (amount of money player has) that much cash!" +
//                                "Those are available upgrades: \n A)  \n B)  \n");
////                    }else{
////                        System.out.println("No cash no upgrades");
////                    }
//                    }
//
//                } else {
//                    System.out.println("Wrong command, try again");
//                }
//            } catch (InputMismatchException ex) {
//                System.out.println("That is not a number");
////                System.out.print("Add Material: \n 1) IonParticle \n 2) ProtonParticle \n");
//                sc.nextLine();
//            }
//
//        }
//        sc.close();

        EnergyFactory energyFactory = new EnergyFactory() {
            @Override
            public EnergyPackage harvestEnergy(int amount, Core core) {
                return null;
            }

            @Override
            public void activateAlert() {

            }

            @Override
            public void storeEnergy() {

            }

            @Override
            public void sllStoredEnergy() {

            }

            @Override
            public void checkState() {

            }

            @Override
            public void checkTemperature() {

            }

            @Override
            public void releasePressure() {

            }

            @Override
            public void increaseProduction() {

            }

            @Override
            public boolean explodePowerPlant() {
                return true;
            }
        };
        Material material = new neutronParticle();
        Material material2 = new ProtonParticle();
        Core core = new Core(material);
        Core core2 = new Core(material2);
        AlarmSystem  alarmSystem = new AlarmSystem("meltdown", "warning", "workingProperly");

        PowerPlant basePowerPlant = new PowerPlant(core, 21.0, energyFactory, alarmSystem);
        EnergyFactory newBasePowerPlant = new PowerPlant(core2, 21.0, energyFactory, alarmSystem);

        //FactoryDecorator decorator = new FactoryDecorator(pp.getEnergyFactory());
        //System.out.println(basePowerPlant.harvestEnergy(1, basePowerPlant.getBuildInCore()).getEnergyUnits()); //output 10


        //System.out.println(newBasePowerPlant.harvestEnergy(1, core2).getEnergyUnits());
        newBasePowerPlant = new CoreUpgrade1(newBasePowerPlant);

//        Object[] i = new Object[20];
//        i = newBasePowerPlant.getClass().getMethods();
//
//        System.out.println(Arrays.toString(i));
         //System.out.println(newBasePowerPlant.harvestEnergy(1, core2).getEnergyUnits());// output changes now doesnt allow not allowed things

        newBasePowerPlant = new CoreUpgrade1(new EarlyWarningSystem(newBasePowerPlant, alarmSystem));

        System.out.println(newBasePowerPlant.harvestEnergy(1, core2).getEnergyUnits());


         //EnergyFactory source = power.getEnergyFactory();
//        System.out.println(source.produceEnergy());


//        source = new CoreUpgrade1(source);
//        System.out.println(power.harvestEnergy());
//
//        CoreUpgrade1 cu1 = new CoreUpgrade1(source);
//
//        cu1.activateAlert();
//
//        AlarmSystem alarmSystem=new AlarmSystem();
//
////        System.out.println(cu1.harvestEnergy());
//
//        FactoryDecorator ews = new EarlyWarningSystem(cu1, alarmSystem);
//
////        System.out.println(ews.harvestEnergy());
//        ews.activateAlert();

//        AlarmSystem alarmSystem=new AlarmSystem();
//
//        source=new CoreUpgrade1(new EarlyWarningSystem(source,alarmSystem));
//
//        source=new CoreUpgrade1(new EarlyWarningSystem(source,alarmSystem));
//
//        System.out.println(source.produceEnergy());

//        source=new CoreUpgrade1(new EarlyWarningSystem((new FacilitySafetyUpgrade(source)),alarmSystem));
//
//
//        System.out.println(
//                source.explodePowerPlant());

//        source = new CoreUpgrade1();
    }
}
