package controller;

import model.CrispyFlour;
import model.Material;
import model.Meat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class MaterialManager {
    public static ArrayList<Material> list = new ArrayList<>();
    public static void displaylist() {
        for (Material p : list) {
            System.out.println(p);
        }
    }

    public static void addMaterial(Scanner scanner) {
        int choice;
        String id;
        String name;
        LocalDate time = null;
        int cost;
        int quantity;
        int weight;
        int month;
        do {
            System.out.println("Mời bạn nhập loại sản phẩm muốn thêm");
            System.out.println("1.Thêm Bột");
            System.out.println("2.Thêm thịt");
            System.out.println("3.Thoát");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Mời bạn nhập ID của sản phẩm ");
                    id = scanner.nextLine();
                    System.out.println("Mời bạn nhập tên của sản phẩm");
                    name = scanner.nextLine();
                    System.out.println("Mời bạn nhập thời gian hết hạn của sản phẩm ");
                    month = Integer.parseInt(scanner.nextLine());
                    System.out.println("Mời bạn nhập giá của sản phẩm");
                    cost = Integer.parseInt(scanner.nextLine());
                    System.out.println("Mời bạn nhập số lượng của sản phẩm");
                    quantity = Integer.parseInt(scanner.nextLine());
                    list.add(new CrispyFlour(id, name, time.now().minusMonths(month), cost, quantity));
                    break;
                case 2:
                    System.out.println("Mời bạn nhập ID của sản phẩm ");
                    id = scanner.nextLine();
                    System.out.println("Mời bạn nhập tên của sản phẩm");
                    name = scanner.nextLine();
                    System.out.println("Mời bạn nhập thời gian hết hạn của sản phẩm ");
                    month = Integer.parseInt(scanner.nextLine());
                    System.out.println("Mời bạn nhập giá của sản phẩm");
                    cost = Integer.parseInt(scanner.nextLine());
                    System.out.println("Mời bạn nhâp cân nặng của sản phẩm");
                    weight = Integer.parseInt(scanner.nextLine());
                    list.add(new Meat(id, name, time.now().plusDays(month), cost, weight));
                    break;
            }
        } while (choice != 3);
    }

    public static void fixById(Scanner scanner) {
        String id2;
        String name;
        LocalDate time = null;
        int cost;
        int quantity;
        int weight;
        int month;
        String id;
        System.out.println("Mời bạn nhập ID sản phẩm bạn muốn sửa");
        id = scanner.nextLine();
        for (Material p : list) {
            if (id.equals(p.getId())) {
                if (p instanceof CrispyFlour) {
                    System.out.println("Mời bạn nhập ID của sản phẩm sửa thành ");
                    id2 = scanner.nextLine();
                    System.out.println("Mời bạn nhập tên của sản phẩm sửa thành");
                    name = scanner.nextLine();
                    System.out.println("Mời bạn nhập thời gian hết hạn của sản phẩm sửa thành ");
                    month = Integer.parseInt(scanner.nextLine());
                    System.out.println("Mời bạn nhập giá của sản phẩm sửa thành");
                    cost = Integer.parseInt(scanner.nextLine());
                    System.out.println("Mời bạn nhập số lượng của sản phẩm sửa thành");
                    quantity = Integer.parseInt(scanner.nextLine());
                    p.setId(id2);
                    p.setName(name);
                    p.setManufacturingDate(time.now().minusMonths(month));
                    p.setCost(cost);
                    ((CrispyFlour) p).setQuantity(quantity);
                } else if (p instanceof Meat) {
                    System.out.println("Mời bạn nhập ID của sản phẩm ");
                    id2 = scanner.nextLine();
                    System.out.println("Mời bạn nhập tên của sản phẩm");
                    name = scanner.nextLine();
                    System.out.println("Mời bạn nhập thời gian hết hạn của sản phẩm ");
                    month = Integer.parseInt(scanner.nextLine());
                    System.out.println("Mời bạn nhập giá của sản phẩm");
                    cost = Integer.parseInt(scanner.nextLine());
                    System.out.println("Mời bạn nhâp cân nặng của sản phẩm");
                    weight = Integer.parseInt(scanner.nextLine());
                    p.setId(id2);
                    p.setName(name);
                    p.setManufacturingDate(time.now().plusDays(month));
                    p.setCost(cost);
                    ((Meat) p).setWeight(weight);
                }
            }
        }
    }

    public static void deleteById(Scanner scanner) {
        String id;
        System.out.println("Mời bạn nhập id sản phẩm muốn xóa");
        id = scanner.nextLine();
        for (Material p : list) {
            if (id.equals(p.getId())) {
                list.remove(p);
                break;
            }
        }
    }

    public static double getDifference() {
        double total = 0;
        for (Material p:list) {
            total+=p.getCost() - p.getRealMoney();
            System.out.println( "giá chênh lệch của sản phẩm là"+ total);
        }
        return total;
    }
}
