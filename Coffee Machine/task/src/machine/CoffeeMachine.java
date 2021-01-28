package machine;

import machine.cofee_ingredients.*;
import org.w3c.dom.ls.LSOutput;

import javax.crypto.spec.PSource;
import java.util.*;

public class CoffeeMachine {
    private static int money = 0;
    private static int cups = 0;

    private final static Map<String, Integer> store = new HashMap<>();
    static {
        store.put("water", 0);
        store.put("milk", 0);
        store.put("bean", 0);
    }



    public static void main(String[] args) {

        ingredientsLoader("water", 400);
        ingredientsLoader("milk", 540);
        ingredientsLoader("bean", 120);
        moneyLoader(550);
        cupsLoader(9);
//        coffeeMachineState();
//        System.out.println();
        System.out.println("Write action (buy, fill, take, remaining, exit):");


        Scanner scanner = new Scanner(System.in);
        String line = "";
        while (!line.equals("exit")) {
            line = scanner.next();
            if ((line.equals(Commands.BUY.getKey()))) {
                System.out.println();
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                if ((line = scanner.next()).equals("1")) {
                    if (ingredientChecker("espresso")) {
                        System.out.println("I have enough resources, making you a coffee!");
                        espressoCreator();
                    } else {
                        //TODO
                        System.out.println("Sorry, not enough water!");

                    }
                }
                if ((line.equals("2"))) {
                    if (ingredientChecker("latte")) {
                        System.out.println("I have enough resources, making you a coffee!");
                        latteCreator();
                    } else {
                        //TODO
                        System.out.println("Sorry, not enough water!");

                    }
                    System.out.println();
                    System.out.println("Write action (buy, fill, take, remaining, exit):");
                    continue;
                }
                if ((line.equals("3"))) {
                    if (ingredientChecker("cappuccino")) {
                        cappuccinoCreator();
                    } else {
                        //TODO
                        System.out.println("Sorry, not enough water!");

                    }
                    System.out.println("I have enough resources, making you a coffee!");

                    System.out.println();
                    System.out.println("Write action (buy, fill, take, remaining, exit):");
                    continue;
                }
            }
            if ((line.equals(Commands.FILL.getKey()))) {
                System.out.println("Write how many ml of water do you want to add: ");
                int waterAmount = scanner.nextInt();
                ingredientsLoader("water", waterAmount);
                System.out.println("Write how many ml of milk do you want to add: ");
                int milkAmount = scanner.nextInt();
                ingredientsLoader("milk", milkAmount);
                System.out.println("Write how many grams of coffee beans do you want to add:");
                int beanAmount = scanner.nextInt();
                ingredientsLoader("bean", beanAmount);
                System.out.println("Write how many disposable cups of coffee do you want to add:");
                int cupAmount = scanner.nextInt();
                cupsLoader(cupAmount);
//                cups +=cupAmount;
                System.out.println();
                System.out.println("Write action (buy, fill, take, remaining, exit):");
            }
            if ((line.equals(Commands.TAKE.getKey()))) {
                System.out.println("I gave you $" + money);
                money -= money;
                System.out.println();
                System.out.println("Write action (buy, fill, take, remaining, exit):");
            }
            if ((line.equals(Commands.REMAINING.getKey()))) {
                System.out.println();
                coffeeMachineState();
                System.out.println();
                System.out.println("Write action (buy, fill, take, remaining, exit):");
                continue;
            }
        }
//        System.out.println();
//        coffeeMachineState();



    }




    public static void espressoCreator() {
        int water = 250;
        int bean = 16;
        store.put("water", (store.get("water") - water));
        store.put("bean", (store.get("bean") - bean));
        cups--;
        money += 4;
    }
    public static void latteCreator() {
        int water = 350;
        int milk = 75;
        int bean = 20;
        store.put("water", (store.get("water") - water));
        store.put("milk", (store.get("milk") - milk));
        store.put("bean", (store.get("bean") - bean));
        cups--;
        money +=7;
    }
    public static void cappuccinoCreator() {
        int water = 200;
        int milk = 100;
        int bean = 12;
        store.put("water", (store.get("water") - water));
        store.put("milk", (store.get("milk") - milk));
        store.put("bean", (store.get("bean") - bean));
        cups--;
        money += 6;
    }

    public static Map<String, Integer> ingredientInformer (String coffeName) {
        Map<String, Integer> tempMap = new HashMap<>();

        if (coffeName.equals("espresso")) {
           tempMap.put("water", store.get("water") - 250);
           tempMap.put("bean", store.get("bean") - 16);
            tempMap.put("cups", cups - 1);
        }
        if (coffeName.equals("latte")) {
            tempMap.put("water", store.get("water") - 350);
            tempMap.put("milk", store.get("milk") - 75);
            tempMap.put("bean", store.get("bean") - 20);
            tempMap.put("cups", cups - 1);
        }
        if (coffeName.equals("cappuccino")) {
            tempMap.put("water", store.get("water") - 200);
            tempMap.put("milk", store.get("milk") - 100);
            tempMap.put("bean", store.get("bean") - 12);
            tempMap.put("cups", cups - 1);
        }
        return tempMap;
    }


    public static boolean ingredientChecker(String coffeName) {
        if (coffeName.equals("espresso")) {
            return (store.get("water") >= 250) & (store.get("bean") >= 16) & cups > 0;
        }
        if (coffeName.equals("latte")) {
            return (store.get("water") >= 350) & (store.get("milk") >= 75)
                    & (store.get("bean") >= 20) & cups > 0;
            }
        if (coffeName.equals("cappuccino")) {
            return (store.get("water") >= 200) & (store.get("milk") >= 100)
                    & (store.get("bean") >= 12) & cups > 0;
        }
        return false;
    }

    public static void coffeeMachineState() {
        System.out.println("The coffee machine has:");
        System.out.println(store.get("water") + " of water");
        System.out.println(store.get("milk") + " of milk");
        System.out.println(store.get("bean") + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println("$" + money + " of money");
    }

    public static void moneyLoader(int cash) {
        money += cash;
    }
    public static void cupsLoader (int countOfCups) {
        cups += countOfCups;
    }

    public static void ingredientsLoader(String ingredient, int amount) {
        if (store.containsKey(ingredient)) {
            int temp = store.get(ingredient);
            store.put(ingredient, amount + temp);
        }
    }

    public static String answerGenerator(int howCoupNeed, int howCoupCanMake) {
        StringBuilder stringBuilder = new StringBuilder("");
        if (howCoupCanMake == 0 && howCoupNeed == 1) {
            stringBuilder.append("No, I can make only ")
                    .append(howCoupCanMake).append("  cup(s) of coffee");
            return stringBuilder.toString();
        }
        if (howCoupCanMake == 0 && howCoupNeed == 0) {
            stringBuilder.append("Yes, I can make that amount of coffee");
            return stringBuilder.toString();
        }
        if (howCoupNeed == howCoupCanMake) {
            stringBuilder.append("Yes, I can make that amount of coffee");
            return stringBuilder.toString();
        }
        if (howCoupNeed > howCoupCanMake) {
            stringBuilder.append("No, I can make only ")
                    .append(howCoupCanMake).append("  cup(s) of coffee");
            return stringBuilder.toString();
        }
        if (howCoupCanMake > howCoupNeed) {
            stringBuilder.append("Yes, I can make that amount of coffee (and even ")
                    .append(howCoupCanMake-howCoupNeed).append(" more than that)");
            return stringBuilder.toString();
        }
        return stringBuilder.toString();
    }

}
