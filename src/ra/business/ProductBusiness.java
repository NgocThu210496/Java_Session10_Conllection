package ra.business;

import ra.entity.Categories;
import ra.entity.IShop;
import ra.entity.Product;

import java.util.List;
import java.util.Scanner;

public class ProductBusiness {
    public static void displayListProduct(Scanner scanner,List<Categories> listCategories,List<Product> listProducts){
        for (IShop e: listProducts ) {
            e.displayData();
        }
    }
    public static void inputListProduct(Scanner scanner, List<Categories> listCategories, List<Product> listProducts){
        System.out.println("Nhập vào số danh mục cần nhập: ");
        int n=Integer.parseInt(scanner.next());
        for(int i=0; i<n; i++){
            //khoi tao doi tuong
            Product products = new Product();
            products.inputData(scanner,listCategories,listProducts,i);
            listProducts.add(products);
        }
    }
    public static void updateProduct(Scanner scanner, List<Categories> listCategories, List<Product> listProducts, int index) {
        System.out.println("Nhập vào mã sản phẩm cần cập nhật: ");
        scanner.nextLine();
        String productIdUpdate = scanner.nextLine();

        // Tìm sản phẩm trong danh sách sản phẩm dựa trên mã sản phẩm
        Product productToUpdate = null;
        for (Product product : listProducts) {
            if (product.getProductId().equals(productIdUpdate)) {
                productToUpdate = product;
                break;
            }
        }

        if (productToUpdate != null) {
            // Nếu sản phẩm được tìm thấy (không null), tiến hành cập nhật thông tin sản phẩm:
            System.out.println("Nhập tên sản phẩm:");
            String productName = scanner.nextLine();
            if (!productName.trim().isEmpty()) {
                productToUpdate.setProductName(productName);
            }

            // Hiển thị danh sách mã danh mục và yêu cầu người dùng nhập mã danh mục mới
            System.out.println("Danh sách mã danh mục:");
            for (Categories category : listCategories) {
                System.out.println("Mã: " + category.getCatalogId() + " - Tên: " + category.getCatalogName());
            }
            System.out.println("Nhập mã danh mục mới:");
            int productCatalogId = Integer.parseInt(scanner.nextLine());

            // Kiểm tra tính hợp lệ của mã danh mục
            boolean isValidCatalogId = false;
            for (Categories category : listCategories) {
                if (category.getCatalogId() == productCatalogId) {
                    isValidCatalogId = true;
                    break;
                }
            }

            if (isValidCatalogId) {
                productToUpdate.setCategories(productCatalogId);
            } else {
                System.err.println("Mã danh mục không hợp lệ.");
            }

            System.out.println("Nhập giá nhập sản phẩm:");
            float importPrice = Float.parseFloat(scanner.nextLine());
            if (importPrice > 0) {
                productToUpdate.setImportPrice(importPrice);
            } else {
                System.err.println("Giá nhập không hợp lệ.");
            }

            System.out.println("Nhập trạng thái sản phẩm (true - Hoạt động, false - Không hoạt động):");
            boolean productStatus = Boolean.parseBoolean(scanner.nextLine());
            productToUpdate.setProductStatus(productStatus);

            System.out.println("Thông tin sản phẩm đã được cập nhật.");
        } else {
            // Nếu sản phẩm không được tìm thấy (null), in thông báo lỗi cho người dùng
            System.err.println("Mã sản phẩm không tồn tại.");
        }
    }

}
