package Controller;
import MaterialMain.CrispyFlour;
import MaterialMain.Material;
import MaterialMain.Meat;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

public class MaterialManager {
    public static ArrayList<Material>materials= new ArrayList<>();
    public void addMaterial(Material material){
        materials.add(material);
    }
    public void editMaterial(ArrayList<Material> material){
        System.out.print("Nhập id vật liệu cần sửa: ");
        Scanner scanner= new Scanner(System.in);
        int id= scanner.nextInt();
        for(int i=0; i<material.size();i++){
            int materId= material.get(i).getId();
            if(id== materId){
                if(material.get(i) instanceof CrispyFlour){
                    material.set(i, ClientView.addCrispyFlour());
                    material.get(i).setId(i+1);
                } else {
                    if(material.get(i) instanceof Meat){
                        material.set(i, ClientView.addMeat());
                        material.get(i).setId(i+1);
                    }
                }

            }
        }
    }
    public void deleteMaterial(ArrayList<Material> material){
        System.out.print("Nhập id vật liệu cần xóa: ");
        Scanner scanner= new Scanner(System.in);
        int id= scanner.nextInt();
        for(int i=0; i<material.size();i++){
            int materId= material.get(i).getId();
            if(id== materId){
                material.remove(i);
            }
        }
    }
    public TreeMap<String, Double> getDiscountDifferenceToday(ArrayList<Material> material){
        double realMoney;
        double costMoney;
        double discountDifference=0;
        TreeMap<String,Double> listDiscountDifferenceToday= new TreeMap<>();
        for(int i= 0; i<material.size(); i++){
            int materId= material.get(i).getId();
            String id= "id: "+materId;
            if(material.get(i) instanceof CrispyFlour){

                realMoney= ((CrispyFlour) material.get(i)).getRealMoney();
                costMoney= ((CrispyFlour) material.get(i)).getCost();
                discountDifference= costMoney - realMoney;
                listDiscountDifferenceToday.put(id,discountDifference);
            }
            if(material.get(i) instanceof Meat){
                realMoney=((Meat) material.get(i)).getRealMoney();
                costMoney= ((Meat) material.get(i)).getCost();
                discountDifference= costMoney- realMoney;
                listDiscountDifferenceToday.put(id,discountDifference);
            }
        }
        return listDiscountDifferenceToday;
    }
    public static void main(String[] args) {

        MaterialManager materialManager = new MaterialManager();
        Scanner scanner= new Scanner(System.in);
        int choice=-1;
        do {
            displayMenu();
            System.out.print("Nhập lựa chọn: ");
            choice= scanner.nextInt();
            switch (choice){
                case 1:
                    System.out.println(materials);
                    break;
                case 2:
                    System.out.println("Nhập thông tin sản phẩm CrispyFlour: ");
                    materialManager.addMaterial(addCrispyFlour());
                    break;
                case 3:
                    System.out.println("Nhập thông tin sản phẩm Meat: ");
                    materialManager.addMaterial(addMeat());
                    break;
                case 4:
                    materialManager.editMaterial(materials);
                    break;
                case 5:
                    materialManager.deleteMaterial(materials);
                    break;
                case 6:
                    System.out.println("Chênh lệch chiết khấu của sản phẩm ngày hôm nay: "+ LocalDate.now() +" theo Id là:");
                    System.out.println(materialManager.getDiscountDifferenceToday(materials));
                    break;

                case 7:
                    System.out.println("vui lòng nhập lại");
                    break;
                default:
                    System.out.println("Nhập sai rồi");

            }

        }while (choice != 7);

    }
    public static void displayMenu(){
        System.out.printf("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n","Menu",
                "1. In các sản phẩm hiện có",
                "2. Thêm sản phẩm CrispyFlour",
                "3. Thêm sản phẩm Meat",
                "4. Sửa sản phẩm theo Id",
                "5. Xóa sản phẩm theo id",
                "6. In ra chênh lệch chiết khấu sản phẩm",
                "7. Thoát");
    }

    public static CrispyFlour addCrispyFlour(){
        Scanner scanner = new Scanner(System.in);
        int id= MaterialManager.materials.size()+1;
        System.out.print("Enter name: ");
        Scanner inName= new Scanner(System.in);
        String name= inName.nextLine();
        System.out.print("Enter manufacturingDate (yyyy-MM-dd): ");
        Scanner inputmanufacturingDate= new Scanner(System.in);
        String manufacturingDate = inputmanufacturingDate.nextLine();
        System.out.print("Enter cost: ");
        int cost= scanner.nextInt();
        System.out.print("Enter quantity: ");
        int quantity= scanner.nextInt();
        CrispyFlour newCris= new CrispyFlour(id,name,manufacturingDate,cost,quantity);
        return newCris;
    }



    public static Meat addMeat(){

        Scanner scanner = new Scanner(System.in);
        int id= MaterialManager.materials.size()+1;
        System.out.print("Enter name: ");
        Scanner inName= new Scanner(System.in);
        String name= inName.nextLine();
        System.out.print("Enter manufacturingDate (yyyy-MM-dd): ");
        Scanner inputmanufacturingDate= new Scanner(System.in);
        String manufacturingDate = inputmanufacturingDate.nextLine();
        System.out.print("Enter cost: ");
        int cost= scanner.nextInt();
        System.out.print("Enter weight: ");
        double weight= scanner.nextDouble();
        Meat newMeat= new Meat(id,name,manufacturingDate,cost, (int) weight);

        return newMeat;
    }
}
