/* GOod work
 * Total score 10
 */
package com.ruchengxiao.assignment8;


import jdk.nashorn.internal.parser.JSONParser;

import java.io.*;
import java.util.ArrayList;
//3rd question
public class MyJson {
    private static ArrayList<Vehicle> readAndGetVehicles(File file) throws IOException  {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        boolean isFirst = true;
        while (true) {
            String line = reader.readLine();
            //System.out.println(line);
            if (line == null) {
                break;
            }
            if (!isFirst) {
                String[] vehicle = line.split("~");
                vehicles.add(new Vehicle(vehicle));
            }

            isFirst = false;
        }

        reader.close();
        return vehicles;
    }

    public static String getJsonString(ArrayList<Vehicle> vehicles) {
        String json = "{\n\"" + vehicles.get(0).webId + "\" : [\n";
        for (Vehicle vehicle : vehicles) {
            json += "{\n";
            json += "\"id\" : \"" + vehicle.id + "\"\n";
            json += "\"category\" : \"" + vehicle.category + "\"\n";
            json += "\"year\" : \"" + vehicle.year + "\"\n";
            json += "\"make\" : \"" + vehicle.make + "\"\n";
            json += "\"model\" : \"" + vehicle.model + "\"\n";
            json += "\"trim\" : \"" + vehicle.trim + "\"\n";
            json += "\"type\" : \"" + vehicle.type + "\"\n";
            json += "\"price\" : \"" + vehicle.price + "\"\n";
            json += "\"photo\" : \"" + vehicle.photo + "\"\n";
            json += "},\n";
        }

        json += "]\n}";
        return json;
    }

    public static void writeToFile(String inputToWrite, String filePath) throws IOException {
        filePath +="/Question3_output.txt";
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File(filePath)));
        writer.write(inputToWrite);
        writer.close();
    }

    //Extra credits
    public static void writeToTextFromJson(File file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = reader.readLine();
            if (line == null) {
                break;
            }
            sb.append(line);
        }
        reader.close();
        String[] record = sb.toString().split("\"");
        String id = record[1];
        String text = "id~webId~category~year~make~model~trim~type~price~photo\n";
        for (int i = 5, j = 1; i < record.length; i += 4, j = j % 9 + 1) {
            if (j == 9)
                text += record[i] + "\n";
            else if (j == 2)
                // attach webId & make category to uppercase
                text += id +  "~" + record[i].toLowerCase() + "~";
            else
                text += record[i] + "~";
        }

        System.out.println(text);
        File output = new File(file.getParent() + "/JsonToText.txt");
        System.out.println(output);
        BufferedWriter writer = new BufferedWriter(new FileWriter(output));
        writer.write(text);
        writer.close();
    }

    public static void main(String[] args) throws IOException {
        File file = new File("/Users/ruchengxiao/MyDocuments/neu-sep17-assignments/src/com/ruchengxiao/assignment8/Question3_camino.txt");
        ArrayList<Vehicle> vehicles = readAndGetVehicles(file);
        System.out.println(file.getParent());
        String s = getJsonString(vehicles);
        writeToFile(s, file.getParent());
        writeToTextFromJson(new File("/Users/ruchengxiao/MyDocuments/neu-sep17-assignments/src/com/ruchengxiao/assignment8/Question3_output.txt"));
        //System.out.println(s);
    }
}
