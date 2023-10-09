package ra.entity;
import java.util.List;
import java.util.Scanner;

public interface IShop {
    float RATE=1.3F;
//
//    void inputData(Scanner scanner, ArrayList<Categories> categories, int curentCategories);

//    void inputData(Scanner scanner, ArrayList<Categories> categories, int currentCategories, ArrayList<Product> products);

  //  void inputDataProduct(Scanner scanner);//ArrayList<Categories> categories, int currentCategories, ArrayList<Product> products, String currentProduct

  //  void inputData(Scanner scanner, int curentCategories);
//
//    void inputData(Scanner scanner, Categories[] arrCategories, int curentCategories);

//    void inputData(Scanner scanner, ArrayList<Product> products, ArrayList<Categories> categories);
//
//    void inputData(Scanner scanner, ArrayList<Categories> categories, int currentCategories);
void inputData(Scanner scanner, List<Categories> listCategories,List<Product> listProducts,int index);
    void displayData();

}
