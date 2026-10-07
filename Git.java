import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

public class Git{
        public static void main(String[] args) {
            initiate();
            HashAndAdd.main(args);

    }
    public static void initiate(){
    

            int counter = 0;
            
            File git = new File("git/");
            if (!git.exists()) {
                git.mkdir();
                System.out.println("make git directory");
                
            }else{
                counter+=1;
            }
            

            File objectsDir = new File("git/objects/");
            if (!objectsDir.exists()) {
                objectsDir.mkdir();
                System.out.println("make object directory");

            }else{
                counter+=1;
            }

            File index = new File("git/index.txt");
            try {
                index.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            if(!index.exists()){
                counter+=1;
            }
            System.out.println("make index file");
            
            File HEAD = new File("git/HEAD.txt");
            try {
                HEAD.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            if(!HEAD.exists()){
                counter+=1;
            }
            System.out.println("make HEAD file");
            if(counter == 4){
                System.out.println("Git Repository Already Exists");

            }
            else{
                System.out.println("Git Repository Created\n" + //
                                        "");
            }

        

    }

       


}