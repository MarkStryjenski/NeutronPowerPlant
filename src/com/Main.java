package com;

import com.Alarm.AlarmSystem;
import com.Alarm.state.State;
import com.Decorator.EnergyFactory;
import com.Decorator.Upgrades.CoreUpgrade1;
import com.Decorator.Upgrades.CoreUpgrade2;
import com.Decorator.Upgrades.EarlyWarningSystem;
import com.Decorator.Upgrades.FacilitySafetyUpgrade;
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


        int count = 0;

        AlarmSystem alarmSystem = new AlarmSystem("meltdown", "warning", "workingProperly");

        PowerPlant powerPlant = new PowerPlant(core1, 21.0, energyFactory, alarmSystem);

        EnergyFactory newBasePowerPlant = new PowerPlant(core1, 21.0, energyFactory, alarmSystem);
        newBasePowerPlant.getAlarmSystem().subscribe("meltdown",newBasePowerPlant);
        newBasePowerPlant.getAlarmSystem().subscribe("warning",newBasePowerPlant);

        System.out.println("----------------------------POWER PLANT----------------------------");
        System.out.print("Welcome to the power plant!!!!! \n ");
        System.out.print("Choose an action: \n a) Add Material \n b) Upgrade PowerPlant  \n");

        while (sc.hasNext()) {
            try {
                String input = sc.next().toLowerCase();
                if (input.equals("a")) {
                    System.out.print("Add Material: \n 1) IonParticle \n 2) ProtonParticle \n 3) NeutronParticle \n 4) Go back \n");
                    while (sc.hasNext()) {
                        int inpAddMaterial = sc.nextInt();
                        System.out.println("How much material you want to add:");
                        if (inpAddMaterial == 1) {
                            int amountInserted = sc.nextInt();
                            newBasePowerPlant.setCore(core3);
                            EnergyPackage result = newBasePowerPlant.harvestEnergy(amountInserted, newBasePowerPlant.getCore());
//                            core.setInputMaterial(ionParticle);
                            if (result == null) {
                                System.out.println("You are not allowed to use Ion Particle");
                            } else {
                                powerPlant.setTotalUnits(result);
                                System.out.println("Added IonParticle");
                            }
                        } else if (inpAddMaterial == 2) {
                            int amountInserted = sc.nextInt();
                            newBasePowerPlant.setCore(core2);
                            EnergyPackage result = newBasePowerPlant.harvestEnergy(amountInserted, newBasePowerPlant.getCore());
//                            core.setInputMaterial(protonParticle);
                            if (result == null) {
                                System.out.println("You are not allowed to use Proton Particle");
                            } else {
                                newBasePowerPlant.setTotalUnits(result);
                                System.out.println("Added Proton");
                            }
                        } else if (inpAddMaterial == 3) {
                            int amountInserted = sc.nextInt();
                            newBasePowerPlant.setCore(core1);
//                            core.setInputMaterial(neutronParticle);
                            EnergyPackage result = newBasePowerPlant.harvestEnergy(amountInserted, newBasePowerPlant.getCore());
                            if(result != null){
                                newBasePowerPlant.setTotalUnits(result);
                                System.out.println("Added Neutron");
                            }
                        } else if (inpAddMaterial == 4) {
                            break;
                        } else {
                            System.out.println("Wrong command, try again");
                        }
                        break;
                    }
                } else if (input.equals("b")) {
                    System.out.print("Do you want to upgrade facility?" +
                            " \n y)yes  \n n)no \n");
                    while (sc.hasNext()) {
                        String inputUpgrade = sc.next().toLowerCase();
                        if (inputUpgrade.equals("y")) {
                            if (count == 0) {
                                newBasePowerPlant = new CoreUpgrade1(newBasePowerPlant);
                                count++;
                            } else if (count == 1) {
                                newBasePowerPlant = new EarlyWarningSystem(newBasePowerPlant, alarmSystem);
                                count++;
                            } else if (count == 2) {
                                newBasePowerPlant = new CoreUpgrade2(newBasePowerPlant);
                                count++;
                            } else if (count == 3) {
                                newBasePowerPlant = new FacilitySafetyUpgrade(newBasePowerPlant);
                                count++;
                            } else {
                                System.out.println("No upgrades available");
                            }
                        } else if (inputUpgrade.equals("n")) {
                            break;
                        } else {
                            throw new InputMismatchException();
                        }
                        System.out.print("Choose an action: \n a) Add Material \n b) Upgrade PowerPlant  \n");
                        break;
                    }
//                    System.out.print("Do you want to upgrade facility?" +
//                            " \n y)yes  \n n)no \n");
//                    while (sc.hasNext()) {
//                        String inputUpgrade = sc.next().toLowerCase();
//                        if (inputUpgrade.equals("y")) {
//                            if (count == 0) {
//                                newBasePowerPlant = new CoreUpgrade1(newBasePowerPlant);
//                                count++;
//                            } else if (count == 1) {
//                                newBasePowerPlant = new EarlyWarningSystem(new CoreUpgrade1(newBasePowerPlant), alarmSystem);
//                                count++;
//                            } else if (count == 2) {
//                                newBasePowerPlant = new CoreUpgrade2(new EarlyWarningSystem(new CoreUpgrade1(newBasePowerPlant), alarmSystem));
//                                count++;
//                            } else if (count == 3) {
//                                newBasePowerPlant = new FacilitySafetyUpgrade(new CoreUpgrade2(new EarlyWarningSystem(new CoreUpgrade1(newBasePowerPlant), alarmSystem)));
//                                count++;
//                            } else {
//                                System.out.println("No upgrades available");
//                            }
//                        } else if (inputUpgrade.equals("n")) {
//                            break;
//                        } else {
//                            throw new InputMismatchException();
//                        }
//                        System.out.print("Choose an action: \n a) Add Material \n b) Upgrade PowerPlant  \n");
//                        break;
//                    }
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


        //FactoryDecorator decorator = new FactoryDecorator(pp.getEnergyFactory());
        //System.out.println(basePowerPlant.harvestEnergy(1, basePowerPlant.getBuildInCore()).getEnergyUnits()); //output 10


        //System.out.println(newBasePowerPlant.harvestEnergy(1, core2).getEnergyUnits());
//        newBasePowerPlant = new CoreUpgrade1(newBasePowerPlant);
//
////        Object[] i = new Object[20];
////        i = newBasePowerPlant.getClass().getMethods();
////
////        System.out.println(Arrays.toString(i));
//         //System.out.println(newBasePowerPlant.harvestEnergy(1, core2).getEnergyUnits());// output changes now doesnt allow not allowed things
//
//        newBasePowerPlant = new CoreUpgrade1(new EarlyWarningSystem(newBasePowerPlant, alarmSystem));
//
//        newBasePowerPlant=new CoreUpgrade2(new CoreUpgrade1(new EarlyWarningSystem(newBasePowerPlant, alarmSystem)));
//
//        System.out.println(newBasePowerPlant.harvestEnergy(1, core2).getEnergyUnits());
//
//        newBasePowerPlant=new EarlyWarningSystem(new CoreUpgrade2(new CoreUpgrade1(new EarlyWarningSystem(newBasePowerPlant, alarmSystem))),alarmSystem);
//
//        basePowerPlant.alarmSystem.subscribe("warning",basePowerPlant);
//        basePowerPlant.alarmSystem.subscribe("meltdown",basePowerPlant);
//        newBasePowerPlant.toWarning();
//        basePowerPlant.toMeltdown();
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
