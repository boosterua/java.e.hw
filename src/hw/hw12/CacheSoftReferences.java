package hw.hw12;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.nio.file.*;
import java.nio.file.Paths;
import java.util.*;

/**
 * Created by tonchief on 12/18/2016.
 */


    class CachedFile {
        String filename;
        private SoftReference<String> softData = new SoftReference<>(null);
        int counterFile;
        int counterCache;

        CachedFile(String filename) {
            this.filename = filename;
        }

        public String getData() throws IOException {
            String data = softData.get();
            if (data != null)
                counterCache++;
            else {
                data = readData();
                softData = new SoftReference<>(data);
            }
            return data;
        }

        private String readData() throws IOException {
            byte[] encoded = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(filename));
            counterFile++;
            return new String(encoded);
        }

    }


    /*Реализовать собственный кеш для доступа к файлу с использованием SoftReference.*/
    public class CacheSoftReferences {
        static Map<String, CachedFile> fileCaches = new HashMap<>();
        static List<String> listOfFiles = new ArrayList<>();
        static Random random =  new Random();

        static void addFile(Path path) {
            fileCaches.put(path.toString(), new CachedFile(path.toString()));
            listOfFiles.add(path.toString());
        }

        static void testFolder(String folder, int tries) {
            try {
                Files.walk(Paths.get(folder))
                        .filter(Files::isRegularFile)
                        .forEach(CacheSoftReferences::addFile);
            } catch (IOException e) {
                e.printStackTrace();
            }

            for (int i=0;i<tries;i++){
                System.out.print("\r"+i);
                try {
                    fileCaches.get(listOfFiles.get(random.nextInt(listOfFiles.size()))).getData();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("\r");

        }

        public static void main(String[] args) {
            testFolder("D:\\Sessions\\ToDo\\2016\\2016-09-17-18 Чернігів\\2016-09-18", 600);
            for (CachedFile cached:fileCaches.values()) {
                System.out.println(cached.filename +":"+cached.counterFile +"-"+ cached.counterCache);
            }
        }


}
