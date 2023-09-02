package Application.chapter6;

import Application.chapter4.Dish;
import Application.chapter5.Trader;
import Application.chapter5.Transaction;
import lombok.val;

import java.util.*;
import java.util.stream.Collectors;

import static Application.chapter4.Dish.menu;
import static java.util.stream.Collectors.*;

public class Chapter6 {
    public static void main(String[] args) {

         List<Transaction> transactions = Arrays.asList(
                new Transaction(Currency.EUR, 1500.0),
                new Transaction(Currency.USD, 2300.0),
                new Transaction(Currency.GBP, 9900.0),
                new Transaction(Currency.EUR, 1100.0),
                new Transaction(Currency.JPY, 7800.0),
                new Transaction(Currency.CHF, 6700.0),
                new Transaction(Currency.EUR, 5600.0),
                new Transaction(Currency.USD, 4500.0),
                new Transaction(Currency.CHF, 3400.0),
                new Transaction(Currency.GBP, 3200.0),
                new Transaction(Currency.USD, 4600.0),
                new Transaction(Currency.JPY, 5700.0),
                new Transaction(Currency.EUR, 6800.0)
        );

        Map<Currency,List<Transaction>> transactionCurrency=new HashMap<>();
        for (Transaction tran:transactions){
            Currency currency = tran.getCurrency();
            List<Transaction> transactionList = transactionCurrency.computeIfAbsent(currency, k -> new ArrayList<>());
            transactionList.add(tran);
        }

        transactionCurrency.forEach((k,v)-> System.out.println(k+"   "+v));

        Map<Currency, List<Transaction>> collect = transactions.stream().collect(groupingBy(Transaction::getCurrency));


      menu.get().stream().max(Comparator.comparing(Dish::getCalories));

      menu.get().stream().map(Dish::getCalories).reduce(Integer::sum);

        Map<CaloricLevel, List<Dish>> map = menu.get().stream().collect(groupingBy(s ->
        {
            if (s.getCalories() <= 400) {
                return CaloricLevel.DIET;
            } else if (s.getCalories() <= 700) {
                return CaloricLevel.NORMAL;
            } else {
                return CaloricLevel.FAT;
            }
        }));

        Map<Dish.Type, Map<CaloricLevel, List<Dish>>> typeMapMap = menu.get().stream().collect(groupingBy(Dish::getType, groupingBy(s ->
        {
            if (s.getCalories() <= 400) {
                return CaloricLevel.DIET;
            } else if (s.getCalories() <= 700) {
                return CaloricLevel.NORMAL;
            } else {
                return CaloricLevel.FAT;
            }
        })));

        Map<Dish.Type, Optional<Dish>> collect1 = menu.get().stream().collect(groupingBy(Dish::getType, maxBy(Comparator.comparing(Dish::getCalories))));


        Map<Dish.Type, Long> longMap = menu.get().stream().collect(groupingBy(Dish::getType, counting()));

        System.out.println(longMap);


    }


    public static class Transaction {

        private final Currency currency;
        private final double value;

        public Transaction(Currency currency, double value) {
            this.currency = currency;
            this.value = value;
        }

        public Currency getCurrency() {
            return currency;
        }
        @Override
        public String toString() {
            return currency + " " + value;
        }

    }

    public enum Currency {
        EUR, USD, JPY, GBP, CHF
    }
}
