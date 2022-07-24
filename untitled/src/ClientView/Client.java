package ClientView;

import Controller.MaterialManager;
import MaterialMain.CrispyFlour;
import MaterialMain.Material;
import MaterialMain.Meat;

import java.util.ArrayList;

public class Client {
    private static ArrayList<Material>materials= MaterialManager.materials;
    static {
        CrispyFlour cr1= new CrispyFlour(1,"bột chiên1","2022-07-20",100,10);
        CrispyFlour cr2= new CrispyFlour(2,"bột chiên2","2022-07-21",110,11);
        CrispyFlour cr3= new CrispyFlour(3,"bột chiên3","2022-07-22",120,12);
        CrispyFlour cr4= new CrispyFlour(4,"bột chiên4","2022-07-23",130,13);
        CrispyFlour cr5= new CrispyFlour(5,"bột chiên5","2022-07-24",140,14);
        materials.add(cr1);
        materials.add(cr2);
        materials.add(cr3);
        materials.add(cr4);
        materials.add(cr5);
        Meat pork = new Meat(6,"thit lon ","2022-07-15",110,2);
        Meat pork1 = new Meat(7,"thit ga","2022-07-16",120,3);
        Meat pork2= new Meat(8,"thit trau","2022-07-17",130,4);
        Meat pork3 = new Meat(9,"thit bo","2022-07-18",140,5);
        Meat pork4 = new Meat(10,"thit vit","2022-07-19",150,6);
        materials.add(pork);
        materials.add(pork1);
        materials.add(pork2);
        materials.add(pork3);
        materials.add(pork4);
    }
}
