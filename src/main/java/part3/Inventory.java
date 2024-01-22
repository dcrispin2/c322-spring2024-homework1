package part3;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Inventory {
    ArrayList<Guitar> guitars;
    Path path = FileSystems.getDefault().getPath("database", "guitars_database.txt");

    public Inventory(ArrayList<Guitar> guitars) throws IOException {
        List<String> lines = Files.readAllLines(path);
        String[] arr = lines.toArray(new String[lines.size()]);

        for (String gtr : arr){
            String s;
            String[] words = toString().split("\\W+");

            String serial = words[0];
            String builder = words[1];
            String model = words[2];
            String type = words[3];
            String backwood = words[4];
            String topwood = words[5];
            double price = Double.parseDouble(gtr);

            this.guitars.add(new Guitar(serial, price, builder, model, type, backwood, topwood));
        }
    }

    public void addGuitar(String serialNumber, double price, String builder, String model, String type, String backWood, String topWood) throws FileNotFoundException {
        Guitar gtr = new Guitar(serialNumber, price, builder, model, type, backWood, topWood);
        guitars.add(gtr);
        PrintWriter out = new PrintWriter("guitars_database.txt");
        out.println(gtr.getSerialNumber() + ", " + gtr.getPrice() + ", " + gtr.getBuilder() + ", " + gtr.getModel() + ", " + gtr.getType() + ", " + gtr.getBackWood() + ", " + gtr.getTopWood());
        out.close();
    }

    public Guitar getGuitar(String serialNumber){
        for (Guitar gtr : guitars){
            if (serialNumber.equals(gtr.getSerialNumber())){
                return gtr;
            }
        }
        return null;
    }

    public Guitar search(Guitar gtr){
        for (Guitar list : guitars){
            if (list.equals(gtr)){
                return list;
            }
        }
        return null;
    }
}
