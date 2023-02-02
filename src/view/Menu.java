package view;

import controller.MaterialManager;
import model.CrispyFlour;
import model.Meat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    public static void addTest(){
        MaterialManager.list.add(new CrispyFlour("C1", "bột mặn", LocalDate.now().minusMonths(5), 10000, 100));
        MaterialManager.list.add(new CrispyFlour("C2", "bột ngọt", LocalDate.now().minusMonths(9), 13000, 130));
        MaterialManager.list.add(new CrispyFlour("C3", "bột bắp", LocalDate.now().minusMonths(8), 17500, 200));
        MaterialManager.list.add(new CrispyFlour("C4", "bột năng", LocalDate.now().plusMonths(5), 17500, 220));
        MaterialManager.list.add(new CrispyFlour("C5", "bột gạo", LocalDate.now().plusMonths(6), 17500, 270));
        MaterialManager.list.add(new Meat("C6", "thịt bò", LocalDate.now().plusDays(5), 20000, 1));
        MaterialManager.list.add(new Meat("C7", "thịt gà", LocalDate.now().plusDays(3), 8000, 2));
        MaterialManager.list.add(new Meat("C8", "thịt lợn", LocalDate.now().plusDays(2), 15000, 3));
        MaterialManager.list.add(new Meat("C9", "thịt trâu", LocalDate.now().plusDays(1), 17000, 4));
        MaterialManager.list.add(new Meat("C10", "thịt ngan", LocalDate.now().plusDays(5), 35000, 5));
    }

    public static void main(String[] args) {
        addTest();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Mời bạn nhập lựa chọn");
            System.out.println("1.Hiển thị danh sách sản phẩm");
            System.out.println("2.Thêm sản phẩm");
            System.out.println("3.Sửa sản phẩm");
            System.out.println("4.Xóa sản phẩm");
            System.out.println("5.Tính giá chênh lệch sản phẩm thực tế ");
            System.out.println("6.Thoát");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    MaterialManager.displaylist();
                    break;
                case 2:
                    MaterialManager.addMaterial(scanner);
                    break;
                case 3:
                    MaterialManager.fixById(scanner);
                    break;
                case 4:
                    MaterialManager.deleteById(scanner);
                    break;
                case 5:
                    MaterialManager.getDifference();
            }
        } while (choice != 6);
    }

}
