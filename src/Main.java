import ra.entity.Categories;
import ra.entity.Product;
import ra.presentation.CategoriesManagement;
import ra.presentation.ProductManagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
   public static List<Categories> listCategories = new ArrayList<>();
    static {
        listCategories.add(new Categories(1,"Danh muc 1","No",true));
        listCategories.add(new Categories(2,"Danh muc 2","yes",false));
        listCategories.add(new Categories(3,"Danh muc 3","No",true));

    }
   public static List<Product> listProducts = new ArrayList<>();
    static {
        listProducts.add(new Product("Sp01","San pham 1",1, 2000,3000, true ));
        listProducts.add(new Product("Sp02","San pham 2",2, 2500,2400, false ));
        listProducts.add(new Product("Sp03","San pham 3",3, 1000,1400, true ));
    }
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        do {
            System.out.println("********************SHOP MENU*********************");
            System.out.println("1. Quản lý danh mục sản phẩm");
            System.out.println("2. Quản lý sản phẩm");
            System.out.println("3. Thoát");

            System.out.println("Nhập lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.next());
            switch (choice){
                case 1:
                    System.out.println("1. Quản lý danh mục sản phẩm");
                    CategoriesManagement.showCategoriesMenu(scanner,listCategories,listProducts,3);
                    break;
                case 2:
                    System.out.println("2. Quản lý sản phẩm");
                    ProductManagement.showProductMenu(scanner,listCategories,listProducts,3);
                    break;
                case 3:
                    System.exit(0);
            }
        } while (true);
    }
}
