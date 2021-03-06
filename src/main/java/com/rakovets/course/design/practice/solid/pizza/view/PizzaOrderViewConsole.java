package com.rakovets.course.design.practice.solid.pizza.view;

import com.rakovets.course.design.practice.solid.pizza.model.Pizza;
import com.rakovets.course.design.practice.solid.pizza.service.*;

import java.time.LocalDateTime;

public class PizzaOrderViewConsole implements PizzaOrderView {
    private static final CashPaymentService cashPaymentService;
    private static final CardPaymentService cardPaymentService;
    private static final OnlinePaymentService onlinePaymentService;

    static {

        cashPaymentService = new CashPaymentService();
        cardPaymentService = new CardPaymentService();
        onlinePaymentService = new OnlinePaymentService();

    }

    public void greeting() {
        System.out.println("\nWELCOME TO PIZZERIA!");
        System.out.println("Choose what pizza you would like to order:");
    }

    public void pizzaMenu() {
        System.out.println("1. Four Cheese");
        System.out.println("2. Margherita");
        System.out.println("3. Meat Delight");
        System.out.println("4. Pepperoni");
        System.out.println("5. Vegetarian");
    }

    public void orderPizzaFourCheese() {
        System.out.println(DateFormatService.localDatePattern(LocalDateTime.now()) + "\t" + Pizza.FOUR_CHEESE +
                "\t" + RoundUpService.roundUp(ProfitService.profitPercentage(
                        PizzaCostService.getCostFourCheese())) + "$");
    }

    public void orderPizzaMargherita() {
        System.out.println(DateFormatService.localDatePattern(LocalDateTime.now()) + "\t" + Pizza.MARGHERITA +
                "\t" + RoundUpService.roundUp(ProfitService.profitPercentage(
                        PizzaCostService.getCostMargherita())) + "$");
    }

    public void orderPizzaMeatDelight() {
        System.out.println(DateFormatService.localDatePattern(LocalDateTime.now()) + "\t" + Pizza.MEAT_DELIGHT +
                "\t" + RoundUpService.roundUp(ProfitService.profitPercentage(
                        PizzaCostService.getCostMeatDelight())) + "$");
    }

    public void orderPizzaPepperoni() {
        System.out.println(DateFormatService.localDatePattern(LocalDateTime.now()) + "\t" + Pizza.PEPPERONI +
                "\t" + RoundUpService.roundUp(ProfitService.profitPercentage(
                        PizzaCostService.getCostPepperoni())) + "$");
    }

    public void orderPizzaVegetarian() {
        System.out.println(DateFormatService.localDatePattern(LocalDateTime.now()) + "\t" + Pizza.VEGETARIAN +
                "\t" + RoundUpService.roundUp(ProfitService.profitPercentage(
                        PizzaCostService.getCostVegetarian())) + "$");
    }

    public void totalOrder(double totalOrder, int size) {
        System.out.println("Order is " + RoundUpService.roundUp(totalOrder) + "$\nNumber of pizzas: " + size);
    }

    public void discountFor2Pizzas(double totalOrder) {
        System.out.println("Discount for ordering 2 pizzas: "
                + RoundUpService.roundUp(totalOrder -
                DiscountService.discountForTwoItems(totalOrder)) + "$");
    }

    public void discountFor3AndMorePizzas(double totalOrder) {
        System.out.println("Discount for ordering 3 & more pizzas: "
                + RoundUpService.roundUp(totalOrder -
                DiscountService.discountForThreeAndMoreItems(totalOrder)) + "$");
    }

    public void discountForOrderOnSpecificDay(double totalOrder) {
        System.out.println("Discount for ordering on Discount Day: "
                + RoundUpService.roundUp(totalOrder -
                DiscountService.discountForOrderOnSpecificDay(totalOrder)) + "$");
    }

    public void amountToPay(double totalOrder) {
        System.out.println("Amount to pay: " + RoundUpService.roundUp(totalOrder) + "$");
    }

    public void addPizzaQuestion() {
        System.out.println("\nDo you want to order anything else (Type y or n)");
    }

    public void paymentChoice() {
        System.out.println("How would you like to pay:");
        System.out.println("1. Cash");
        System.out.println("2. Credit card");
        System.out.println("3. Online");
    }

    public void cashPayment() {
        System.out.println(cashPaymentService.toString());
    }

    public void cardPayment() {
        System.out.println(cardPaymentService.toString());
    }

    public void onlinePayment() {
        System.out.println(onlinePaymentService.toString());
    }
}
