package ra.business;

import ra.entity.Categories;
import ra.entity.IShop;
import ra.entity.Product;

import java.util.List;
import java.util.Scanner;

public class CategoriesBusiness {
    public static void displayListCategories(List<Categories> listCategories) {
        for (IShop e : listCategories) {
            e.displayData();
        }
    }

    public static void inputListCategories(Scanner scanner, List<Categories> listCategories, List<Product> listProducts) {
        System.out.println("Nhập vào số danh mục cần nhập: ");
        int n = Integer.parseInt(scanner.next());
        for (int i = 0; i < n; i++) {
            //khoi tao doi tuong
            Categories categories = new Categories();
            categories.inputData(scanner, listCategories, listProducts, i);
            listCategories.add(categories);
        }
    }

    public static void updateCategories(Scanner scanner, List<Categories> listCategories, List<Product> listProducts, int index) {
        System.out.println("Nhập vào mã danh mục cần cập nhật: ");
        scanner.nextLine();
        int catalogIdUpdate = Integer.parseInt(scanner.nextLine());
        // Tìm danh mục theo mã
        Categories categoryToUpdate = null;
        for (Categories category : listCategories) {
            if (category.getCatalogId() == catalogIdUpdate) {
                categoryToUpdate = category;
                break;
            }
        }

        if (categoryToUpdate != null) {
            // Nếu danh mục được tìm thấy (không null), thực hiện cập nhật thông tin danh mục
            System.out.println("Nhập tên danh mục:");
            String catalogName = scanner.nextLine();
            if (!catalogName.trim().isEmpty()) {
                // Kiểm tra xem người dùng đã nhập tên danh mục mới hay không (không rỗng)
                categoryToUpdate.setCatalogName(catalogName);
            }

            System.out.println("Nhập vào mô tả danh mục:");
            String description = scanner.nextLine();
            if (!description.trim().isEmpty()) {
                // Kiểm tra xem người dùng đã nhập mô tả danh mục mới hay không (không rỗng)
                categoryToUpdate.setDescriptions(description);
            }

            System.out.println("Nhập vào trạng thái danh mục (true - Hoạt động, false - Không hoạt động):");
            String statusInput = scanner.nextLine();
            if (!statusInput.trim().isEmpty()) {
                boolean status = Boolean.parseBoolean(statusInput);
                categoryToUpdate.setCatalogStatus(status);
            }

            System.out.println("Thông tin danh mục đã được cập nhật.");
        } else {
            System.err.println("Mã danh mục không tồn tại.");
        }
    }

    public static void deleteCatalog(Scanner scanner, List<Categories> listCategories, List<Product> listProducts) {
        System.out.println("Nhập vào mã danh mục cần xóa:"); //Xóa danh mục (Chỉ cho phép xóa danh mục chưa có sản phẩm)
        int deleteId = Integer.parseInt(scanner.next());
        for (int i = 0; i < listProducts.size(); i++) {
            if (listProducts.get(i).getCategoriId() == deleteId) {
                System.out.println("Danh mục này đã có sản phẩm, không được phép xoá");
                return;
            }
        }
        boolean check = false;
        System.out.println("Nhập mã id cần xoá: ");
        for (int i = 0; i < listCategories.size(); i++) {
            if (listCategories.get(i).getCatalogId() == deleteId) {
                listCategories.remove(i);
                check = true;
                break;
            }
        }
        if (!check) {
            System.err.println("Không tìm thấy mã nhân viên cần xóa, vui lòng nhập lại");
        } else {
            System.out.println("Đã xoá thành công!");
        }

    }


}
