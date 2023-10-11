package ra.entity;

import ra.business.IShop;

import java.util.List;
import java.util.Scanner;

public class Categories implements IShop {

    private static int newCatalogId = 4;
    private int catalogId;
    private String catalogName;
    private String descriptions; //mô tả danh mục
    private boolean catalogStatus; //true – hoạt động, false – không hoạt động

    public Categories() {
        this.catalogId = newCatalogId++;
    }

    public Categories(int catalogId, String catalogName, String descriptions, boolean catalogStatus) {
        this.catalogId = catalogId;
        this.catalogName = catalogName;
        this.descriptions = descriptions;
        this.catalogStatus = catalogStatus;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public boolean isCatalogStatus() {
        return catalogStatus;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public void setCatalogStatus(boolean catalogStatus) {
        this.catalogStatus = catalogStatus;
    }

    //@Override
    public void inputData(Scanner scanner, List<Categories> listCategories, List<Product> listProducts) {
        // Tiêu diệt ký tự newline sau khi đọc số nguyên
        scanner.nextLine();
        //2. Nhập tên danh mục
        boolean isExit = true;
        System.out.println("Nhập vào tên danh mục:");
        do {
            this.catalogName = scanner.nextLine();
            //Check độ dài < 50
            if (this.catalogName.length() < 50) {
                //Không trùng lặp
                boolean isExist = false;//Không trùng
                for (int i = 0; i < listCategories.size(); i++) {
                    if (listCategories.get(i).getCatalogName().toLowerCase().equals(this.catalogName.toLowerCase())) {
                        isExist = true;//Bị trùng lặp - đã tồn tại rồi
                        break;
                    }
                }
                if (isExist) {
                    System.err.println("Tên danh mục đã tồn tại, vui lòng nhập lại");
                } else {
                    break;
                }
            } else {
                System.err.println("Tên danh mục có độ dài nhỏ hơn 50 ký tự, vui lòng nhập lại");
            }
        } while (isExit);

        //3. Nhập mô tả danh mục
        System.out.println("Nhập vào mô tả danh mục:");
        this.descriptions = scanner.nextLine();
        //4. Nhập trạng thái danh mục
        System.out.println("Nhập vào trạng thái danh mục:");
        do {
            String status = scanner.nextLine();
            if (status.equals("true") || status.equals("false")) {
                this.catalogStatus = Boolean.parseBoolean(status);
                break;
            } else {
                System.err.println("Trạng thái danh mục chỉ nhận giá trị true hoặc false, vui lòng nhập lại");
            }
        } while (isExit);
    }

    @Override
    public void displayData() {
        System.out.printf("Mã danh mục: %d - Tên danh mục: %s\n", this.catalogId, this.catalogName);
        System.out.printf("Mô tả: %s - Trạng thái: %s\n", this.descriptions, this.isCatalogStatus() ? "Hoạt động" : "Không hoạt động");
        System.out.println("-----------------------------*-------------------------------");
    }

}
