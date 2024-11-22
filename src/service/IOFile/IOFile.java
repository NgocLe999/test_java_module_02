package service.IOFile;

import model.entity.People;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


    public class IOFile {

        public static final String PATH_FILE = "src/data/contacts.csv";

        public static List<People> readFile() {
            List<People> peopleArrayList = new ArrayList<>();
            try {
                FileReader fileReader = new FileReader(PATH_FILE);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    String[] temp = line.split(",");
                    People people = new People(Integer.parseInt(temp[0]), temp[1], temp[2], Double.parseDouble(temp[3]), temp[4]);
                    peopleArrayList.add(people);
                }
                bufferedReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("Không tìm thấy file");
            } catch (IOException e) {
                System.out.println("Lỗi đọc file");
            }
            return peopleArrayList;
        }

        public void writeFile(List<People> Peoples, boolean append) {
            File file = new File(PATH_FILE);
            FileWriter fileWriter = null;
            BufferedWriter bufferedWriter = null;

            try {
                fileWriter = new FileWriter(file, append);
                bufferedWriter = new BufferedWriter(fileWriter);
                for (People temp : Peoples) {
                    bufferedWriter.write(toString(temp));
                    bufferedWriter.newLine();
                }

            } catch (IOException e) {
                System.out.println("Lỗi ghi file");
            } finally {
                if (bufferedWriter != null) {
                    try {
                        bufferedWriter.close();
                    } catch (IOException e) {
                        System.out.println("Lỗi đóng file");
                    }
                }
            }
        }

        private static String toString(People s) {
            return s.getPhone() + "," + s.getName() + "," + s.getEmail() + "," + s.getAddress() + "," + s.getGender() + "," + s.getBirthday() + "," + s.getGroup() ;
        }




    }

