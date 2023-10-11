package ra.presentation;

import ra.businessImp.CategoriesImp;
import ra.entity.Categories;
import ra.entity.Product;

import java.util.List;
import java.util.Scanner;

public class CategoriesManagement {
    public static void showCategoriesMenu(Scanner scanner, List<Categories> listCategories, List<Product> listProducts) {
        boolean exitMenuCatalog = true; //chỉ  thoát khỏi menuCategories thôi
        do {
            System.out.println("|************************CATEGORIES MENU*****************************|");
            System.out.println("| 1. Danh sách danh mục                                              |");
            System.out.println("| 2. Thêm mới danh mục                                               |");
            System.out.println("| 3. Cập nhật thông tin danh mục (Cập nhật theo mã)                  |");
            System.out.println("| 4. Xóa danh mục (Chỉ cho phép xóa danh mục chưa có sản phẩm)       |");
            System.out.println("| 5. Thoát                                                           |");
            System.out.println("|********************************************************************|");

            System.out.println("Nhập lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.next());
            switch (choice) {
                case 1:
                    System.out.println("1. Danh sách danh mục");
                    CategoriesImp.displayListCategories(listCategories);
                    break;
                case 2:
                    System.out.println("2. Thêm mới danh mục");
                    CategoriesImp.inputListCategories(scanner, listCategories, listProducts);
                    break;
                case 3:
                    System.out.println("3. Cập nhật thông tin danh mục (Cập nhật theo mã)");
                    CategoriesImp.updateCategories(scanner, listCategories, listProducts);
                    break;
                case 4:
                    System.out.println("4. Xóa danh mục (Chỉ cho phép xóa danh mục chưa có sản phẩm)");
                    CategoriesImp.deleteCatalog(scanner, listCategories, listProducts);
                    break;
                case 5:
                    exitMenuCatalog = false;
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại!");

            }
        } while (exitMenuCatalog);
    }
}
