package hw;

public class FileDir {

    public void test(){
        File f = new File("file1.txt");
        System.out.println(f.getFileName());
        f.rename("NewFileName.txt");
    }
    
    abstract class DiskUnit{
        public boolean create(){ return false;}
        public boolean rename(String args){ return false;}
        public boolean append(String args){ return false;}
        public boolean delete(){ return false;}
        public void output(){ }
    }

    public class File extends DiskUnit{
        String name;

        File(String nm){
            this.name = nm;
        }

        String getFileName(){
            return name;
        }

        public boolean create(){
            try{
                // create file with name
            } catch (Exception e){
                return false;
            }
            return true;
        }

        public boolean rename(String newName){
            try{
                System.out.printf("Rename file <%s> to <%s>\n", name, newName);
            } catch (Exception e){
                return false;
            }
            return true;
        }

        public boolean append(String contents){
            // append file
            return true;
        }

        public boolean delete(){
            // try > delete file
            return true;
        }

        public void output(){
            // open file, print contents
            String fileContent="";
            System.out.println(fileContent);
        }
    }

    public class Directory extends DiskUnit{
        public boolean create(){ return false;}
        public boolean rename(String args){ return false;}
        public boolean delete(){ return false;}
    }

}
