package ra.presentation;

import ra.business.ProductBusiness;
import ra.entity.Categories;
import ra.entity.Product;

import java.util.List;
import java.util.Scanner;

public class ProductManagement {
    public static void showProductMenu(Scanner scanner, List<Categories> listCategories, List<Product> listProducts, int index){
        boolean exitMenuProduct=true; //chỉ  thoát khỏi menuProduct thôi
        do {
            System.out.println("**************PRODUCT MENU**************");
            System.out.println("1. Danh sách sản phẩm");
            System.out.println("2. Thêm mới sản phẩm (Khi thêm mới cho phép chọn danh mục)");
            System.out.println("3. Cập nhật thông tin sản phẩm (Cập nhật theo mã)");
            System.out.println("4. Xóa sản phẩm");
            System.out.println("5. Sắp xếp sản phẩm theo giá bán tăng dần");
            System.out.println("6. Sắp xếp sản phẩm theo giá nhập giảm dần");
            System.out.println("7. Tìm kiếm sản phẩm theo tên sản phẩm");
            System.out.println("8. Thoát");

            System.out.println("Nhập lựa chọn của bạn: ");
            int choice=Integer.parseInt(scanner.next());
            switch (choice){
                case 1:
                    System.out.println("1. Danh sách sản phẩm");
                    ProductBusiness.displayListProduct(scanner,listCategories,listProducts);
                    break;
                case 2:
                    System.out.println("2. Thêm mới sản phẩm (Khi thêm mới cho phép chọn danh mục)");
                    ProductBusiness.inputListProduct(scanner,listCategories,listProducts);
                    break;
                case 3:
                    System.out.println("3. Cập nhật thông tin sản phẩm (Cập nhật theo mã)");
                    ProductBusiness.updateProduct(scanner, listCategories,listProducts,index);
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    exitMenuProduct=false;
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại!");

            }
        }while (exitMenuProduct);
    }
}
