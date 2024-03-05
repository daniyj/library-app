//package com.group.libraryapp.z_self_study.Day6.repository;
//
//import com.group.libraryapp.z_self_study.Day6.domain.Fruit;
//import com.group.libraryapp.z_self_study.Day6.dto.GetSalesAmountResponse;
//import org.springframework.stereotype.Repository;
//
//import java.time.LocalDate;
//import java.util.List;
//
//
//@Repository
//public class FruitMemoryRepository implements FruitRepository_Day6 {
//    private List<Fruit> fruits;
//    private long id = 1;
//
//    public FruitMemoryRepository(List<Fruit> fruits) {
//        this.fruits = fruits;
//    }
//    public void saveFruit(String name, LocalDate warehousingDate, long price){
//        Fruit fruit = new Fruit(id++,name, warehousingDate, price);
//        fruits.add(fruit);
//        System.out.println("fruit = " + fruit);
//    }
//    public void updateFruit(long id){
//        for (Fruit fruit : fruits) {
//            if(fruit.getId()==id)
//                fruit.setIsSold(true);
//        }
//    }
//    public GetSalesAmountResponse getSalesAmount(String name){
//
//        long soldPrice = 0;
//        long notSoldPrice = 0;
//
//        for (Fruit fruit : fruits) {
//            if (fruit.getName().equals(name)) {
//                if(fruit.isSold())
//                    soldPrice += fruit.getPrice();
//                else
//                    notSoldPrice += fruit.getPrice();
//            }
//        }
//        return new GetSalesAmountResponse(soldPrice,notSoldPrice);
//    }
//}
