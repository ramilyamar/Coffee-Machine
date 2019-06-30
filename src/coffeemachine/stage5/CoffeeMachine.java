package coffeemachine.stage5;

import java.util.Scanner;

public class CoffeeMachine {

    static int waterHas = 400;
    static int milkHas = 540;
    static int beansHas = 120;
    static int cupsHas = 9;
    static int moneyHas = 550;

    static int waterNeed;
    static int milkNeed;
    static int beansNeed;
    static int price;

    static boolean program = true;

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (program) {
            System.out.println("\nWrite action (buy, fill, take, remaining, exit):");
            String action = scanner.next();
            switch (action) {
                case "buy":
                    buy();
                    break;
                case "fill":
                    fill();
                    break;
                case "take":
                    take();
                    break;
                case "remaining":
                    System.out.println("Write action (buy, fill, take, remaining, exit): remaining");
                    stage(waterHas, milkHas, beansHas, cupsHas, moneyHas);
                    break;
                case "exit":
                    exit();
                    break;
                default:
                    System.out.println("This action don't exist.");
            }
        }
    }

    static void stage(int water, int milk, int beans, int cups, int money) {
        System.out.println("\nThe coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(beans + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println(money + "$ of money");
    }

    static void exit() {
        program = false;
    }

    static void buy() {
        System.out.println("\nWrite action (buy, fill, take, remaining, exit): buy");

        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        String choice = scanner.next();
        if (choice.equals("back")) {
            return;
        } else {
            int coffeeNum = Integer.parseInt(choice);
            switch (coffeeNum) {
                case 1:
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: 1");
                    price = 4;
                    waterNeed = 250;
                    beansNeed = 16;
                    break;
                case 2:
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: 2");
                    price = 7;
                    waterNeed = 350;
                    milkNeed = 75;
                    beansNeed = 20;
                    break;
                case 3:
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: 3");
                    price = 6;
                    waterNeed = 200;
                    milkNeed = 100;
                    beansNeed = 12;
                    break;
                default:
                    System.out.println("Wrong number. What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
                    break;
            }
        }

        if (waterNeed <= waterHas && milkNeed <= milkHas && beansNeed <= beansHas && cupsHas >= 1) {
            System.out.println("I have enough resources, making you a coffee!");
            waterHas -= waterNeed;
            milkHas -= milkNeed;
            beansHas -= beansNeed;
            cupsHas--;
            moneyHas += price;
        } else {
            if (waterNeed > waterHas) {
                System.out.println("Sorry, not enough water!");
            }
            if (milkNeed > milkHas) {
                System.out.println("Sorry, not enough milk!");
            }
            if (beansNeed > beansHas) {
                System.out.println("Sorry, not enough beans!");
            }
            if (cupsHas < 1) {
                System.out.println("Sorry, not enough cups!");
            }
        }
    }

    static void fill() {
        System.out.println("\nWrite action (buy, fill, take, remaining, exit): fill");

        System.out.println("Write how many ml of water do you want to add: ");
        int waterAdd = scanner.nextInt();
        System.out.println("Write how many ml of water do you want to add: " + waterAdd);
        waterHas += waterAdd;

        System.out.println("Write how many ml of milk do you want to add: ");
        int milkAdd = scanner.nextInt();
        System.out.println("Write how many ml of milk do you want to add: " + milkAdd);
        milkHas += milkAdd;

        System.out.println("Write how many grams of coffee beans do you want to add: ");
        int beansAdd = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add: " + beansAdd);
        beansHas += beansAdd;

        System.out.println("Write how many disposable cups of coffee do you want to add: ");
        int cupsAdd = scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add: " + cupsAdd + "\n");
        cupsHas += cupsAdd;
    }

    static void take() {
        System.out.println("\nWrite action (buy, fill, take, remaining, exit): take");
        System.out.println("I gave you $" + moneyHas);
        moneyHas = 0;
    }
}
