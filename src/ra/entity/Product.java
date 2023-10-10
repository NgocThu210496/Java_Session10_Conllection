package ra.entity;

import java.util.List;
import java.util.Scanner;

public class Product implements IShop {
    private String productId;
    private String productName;
    private static int catalogId;
    private float ImportPrice; // Giá nhập sản phẩm, có giá trị lớn hơn 0
    private float ExportPrice; //Giá bán sản phẩm tính theo công thức
    private boolean productStatus; //True – Hoạt động, false – Không hoạt động)

    public Product() {
    }

    public Product(String productId, String productName, int catalogId, float importPrice, float exportPrice, boolean productStatus) {
        this.productId = productId;
        this.productName = productName;
        this.catalogId = catalogId;
        ImportPrice = importPrice;
        ExportPrice = exportPrice;
        this.productStatus = productStatus;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public int getCategoriId() {
        return catalogId;
    }


    public float getImportPrice() {
        return ImportPrice;
    }

    public float getExportPrice() {
        return ExportPrice;
    }

    public boolean getProductStatus() {
        return productStatus;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setCategories(int categories) {
        this.catalogId = categories;
    }

    public void setImportPrice(float importPrice) {
        ImportPrice = importPrice;
    }

    public void setExportPrice(float exportPrice) {
        ExportPrice = exportPrice;
    }

    public void setProductStatus(boolean productStatus) {
        this.productStatus = productStatus;
    }

    public void ExprtPrice() { //gia nhap
        this.ExportPrice = ImportPrice * RATE; //Giá bán sản phẩm tính theo công thức
    }

    @Override
    public void inputData(Scanner scanner, List<Categories> listCategories, List<Product> listProducts, int index) {
        System.out.println("Nhập thông tin của sản phẩm");
        /*gồm 4 ký tự bắt đầu là một trong 3 ký tự ,không được trùng lặp*/
        System.out.println("Nhập vào mã sản phẩm: ");
        do {

            this.productId = scanner.nextLine();
            boolean check = false;
            if (productId.length() == 4) {

                //không được trùng lặp
                for (int i = 0; i < listProducts.size(); i++) {
                    if (productId.equals(listProducts.get(i))) {
                        check = true;
                        break;
                    }
                }
                if (check) {
                    System.err.println("Đã tồn tại mã sản phẩm, vui lòng nhập lại!");

                } else {
                    //nếu thoả mãn thì vào đây
                    //check = true;
                    break;
                }

            } else
                System.err.println("Độ dài phải đủ 4 ký tự, mời nhập lại!");

        } while (true);

        System.out.println("Nhập tên sản phẩm: ");
        //Tên sản phẩm, không trùng lặp
        do {
            this.productName = scanner.nextLine();
            boolean check = false;
            for (int i = 0; i < listProducts.size(); i++) {
                if (listProducts.get(i).productName.equals(this.productName)) {
                    check = true;
                    break;
                }
            }
            if (check) {
                System.err.println("Nhập tên sản phẩm đã bị trùng lặp, vui lòng nhập lại");
            } else {
                break;
            }

        } while (true);

        //Mã danh mục của sản phẩm
        listCategoriIdDisplay(scanner, listCategories, listProducts, index);

        System.out.println("Nhập Giá sản phẩm: "); //có giá trị lớn hơn 0
        do {
            this.ImportPrice = Float.parseFloat(scanner.nextLine());
            for (int i = 0; i < listProducts.size(); i++) {
                if (!(this.ImportPrice > 0)) {
                    System.out.println("Giá sản phẩm có giá trị lớn hơn 0, mời nhập lại!");
                } else {

                    break;
                }
            }
            break;
        } while (true);
        ExprtPrice();
        System.out.println("Nhập vào trạng thái sản phẩm");
        this.productStatus = Boolean.parseBoolean(scanner.next());
    }

    public static void listCategoriIdDisplay(Scanner scanner, List<Categories> listCategories, List<Product> listProducts, int index) {
        System.out.println("Mã danh mục mà sản phẩm thuộc về");
        System.out.println("Chọn danh mục của sản phẩm ");
        //hiển thị ra các danh mục
        for (int i = 0; i < listCategories.size(); i++) {
            System.out.println(i + 1 + "." + listCategories.get(i).getCatalogName());
        }
        System.out.println("Lựa chọn của bạn");
        do {
            boolean check = true;
            //choice: chỉ số phần tử catalog đc chọn
            int choice = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < listCategories.size(); i++) {
                check = true;
                if (choice == listCategories.get(i).getCatalogId()) { // dung thi vao day
                    catalogId = choice;
                    break;
                } else {
                    check = false;
                }
            }
            if (!check) {
                System.out.println("Mã IdCategories sai, vui lòng nhập lại!");
            }

            break;
        } while (true);
    }

    @Override
    public void displayData() {
        System.out.printf("Mã sản phẩm: %s - Tên sản phẩm: %s - Mã danh mục của sản phẩm: %d\n", this.productId, this.productName, this.catalogId);
        System.out.printf("Giá nhập sản phẩm: %f - Giá bán sản phẩm: %f - Trạng thái sản phẩm: %s\n", this.ImportPrice, this.ExportPrice, this.productStatus ? "Hoạt động" : "Không hoạt động");
        System.out.println("----------------------------------------*---------------------------------------");
    }
}
