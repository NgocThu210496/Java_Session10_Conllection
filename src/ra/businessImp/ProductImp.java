package ra.businessImp;

import ra.business.IShop;
import ra.entity.Categories;
import ra.entity.Product;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ProductImp {
    public static void displayListProduct(Scanner scanner, List<Categories> listCategories, List<Product> listProducts) {
        for (IShop e : listProducts) {
            e.displayData();
        }
    }

    public static void inputListProduct(Scanner scanner, List<Categories> listCategories, List<Product> listProducts) {
        System.out.println("Nhập vào số danh mục cần nhập: ");
        int n = Integer.parseInt(scanner.next());
        for (int i = 0; i < n; i++) {
            //khoi tao doi tuong
            Product products = new Product();
            products.inputData(scanner, listCategories, listProducts);
            listProducts.add(products);
        }
    }

    public static void updateProduct(Scanner scanner, List<Categories> listCategories, List<Product> listProducts) {
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
            // Nếu sản phẩm không được tìm thấy (null)
            System.err.println("Mã sản phẩm không tồn tại.");
        }
    }

    public static void deleteProduct(Scanner scanner, List<Categories> listCategories, List<Product> listProducts) {
        boolean check = false;
        System.out.println("Nhập vào mã Id muốn xoá sản phẩm: ");
        scanner.nextLine();
        String deleteId = scanner.nextLine();
        for (int i = 0; i < listProducts.size(); i++) {
            if (listProducts.get(i).getProductId().equals(deleteId)) {
                listProducts.remove(i);
                check = true;
                break;

            }
        }
        if (!check) {
            System.err.println("Không tìm thấy mã cần xóa, vui lòng nhập lại");
        } else {
            System.out.println("Đã xoá thành công!");
        }
    }

    public static void sortProductExportPrice(Scanner scanner, List<Categories> listCategories, List<Product> listProducts) { //gia ban
        Collections.sort(listProducts, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return Float.compare(o1.getExportPrice(), o2.getExportPrice());
            }
        });
        System.out.println("Đã sắp xếp xong sản phẩm tăng dần!");
    }

    //Sắp xếp sản phẩm theo giá nhập giảm dần
    public static void sortProductImportPrice(Scanner scanner, List<Categories> listCategories, List<Product> listProducts) {
        Collections.sort(listProducts, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return Float.compare(o2.getImportPrice(), o1.getImportPrice());
            }
        });
        System.out.println("Đã sắp xếp xong giá nhập giảm dần!");

    }

    //Tìm kiếm sản phẩm theo tên sản phẩm
    public static void seacherProductListbyProductName(Scanner scanner, List<Categories> listCategories, List<Product> listProducts) {
        System.out.println("Nhập tên sản phẩm cần tìm: ");
        boolean test = true; //tim san pham co hay khong
        scanner.nextLine(); // Xóa bất kỳ dữ liệu thừa trong bộ đệm
        String searchName = scanner.nextLine();
        for (int i = 0; i < listProducts.size(); i++) {
            test = true;
            // String productName = listEmployees.size().g.toLowerCase(); // Chuyển tên sản phẩm về chữ thường để tìm kiếm không phân biệt hoa thường
            if (listProducts.get(i).getProductName().equals(searchName)) {
                listProducts.get(i).displayData(); // Hiển thị thông tin sản phẩm tìm thấy
                break;
            } else {
                test = false;
            }
        }
        if (!test) {
            System.err.println("Không tìm thấy sản phẩm nào có tên: " + searchName + " vui lòng nhập lại! ");
        }
    }

}
