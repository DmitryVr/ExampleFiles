import java.io.*;

public class Start {

    public static void main(String[] args) {

        exampleFilesInDir();

        File file = exampleFile();

        try {
            exampleFileWriter(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            exampleFileReader(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    private static File exampleFile()  {
        File file = new File("temp.txt"); // этот файл в памяти, а не на винчестере

        if (!file.exists()) { // если не существует
            try {
                file.createNewFile(); // создать файл
                //file.mkdir(); // создать директорию
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("exist");
        }

        if (file.isDirectory()) {
            System.out.println("directory");
        }

        if (file.isFile()) {
            System.out.println("file");
        }

        return file;
    }


    private static void exampleFileWriter(File file) throws IOException {

        FileWriter fileWriter = new FileWriter(file);
//        fileWriter.write("str1\n");
//        fileWriter.write("str2\n");
//        fileWriter.flush(); // записать в файл
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write("str3");
        bufferedWriter.newLine();
        bufferedWriter.write("str4");
        bufferedWriter.flush();
        bufferedWriter.close();
        fileWriter.close(); // закрыть файл
    }


    private static void exampleFileReader(File file) throws IOException {

        FileReader fileReader = new FileReader(file);
//        char[] chars = new char[20];
//        fileReader.read(chars);
//        System.out.println(chars);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        while (bufferedReader.ready()) { // дошло ли до конца файла
            System.out.println(bufferedReader.readLine()); // считывание построчно
        }
        bufferedReader.close();
        fileReader.close();
    }

    private static void exampleFilesInDir() {
        // чтение списка файлов из папки
        File dir = new File("../ExampleFiles"); // указываем папку а не файл

        for (String fileName : dir.list()) { // перебор по найденным именам файлов
            System.out.println("File name in dir: " + fileName);
        }
    }


}
