package ra.entity;

import java.util.List;
import java.util.Scanner;

public interface IShop {
    float RATE = 1.3F;

    void inputData(Scanner scanner, List<Categories> listCategories, List<Product> listProducts, int index);

    void displayData();

}
