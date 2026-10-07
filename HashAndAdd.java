import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class HashAndAdd {
    public static void main(String[] args) {
        
        try {
            String hash;
            hash = hashFile("hello.txt");
            File blobFile = new File("git/objects/" + hash + ".txt");
            FileWriter blobWriter = new FileWriter("git/objects/" + hash + ".txt");
            String content = new String(Files.readAllBytes(Paths.get("hello.txt")));
            blobWriter.write(content);//do file content;
            blobWriter.close();
            System.out.println(blobFile);
            System.out.println(content);

            writein("hello.txt");


        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }



  


        
        
    }
    public static void addToIndex(String filename){
        try {
            String hash = new String();
            hash = hashFile(filename);
            FileWriter indexWriter = new FileWriter("git/index.txt");
            indexWriter.write(hash + " " + filename);
            System.lineSeparator();
            indexWriter.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    

    public static String hashFile(String filePath) throws IOException {
        Path path = Path.of(filePath);
        if(!Files.isRegularFile(path)){
            throw new IOException("no files" + filePath);
        }
        byte[] fileBytes = Files.readAllBytes(path);

        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("SHA-1");
        } catch(NoSuchAlgorithmException e) {
            throw new IllegalStateException("sha1 not avalible", e);
        }
        byte[] hash = digest.digest(fileBytes);
        System.out.println();

        return HexFormat.of().formatHex(hash);
    }
    
}
