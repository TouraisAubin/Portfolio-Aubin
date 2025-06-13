import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;


public class SaveManager {
    public static int NUMBER_OF_SAVE = 4;
    public static String SAVE_DIRECTORY = "../ProgrammeDemineur";
    private String[] listOfFile = new String[NUMBER_OF_SAVE];
    
    public SaveManager(){
        Arrays.fill(this.listOfFile, "empty");
        this.listSaves();
    }
    
    /**
     * créé un SaveManager et change son répertoire utilisé
     * @param saveDirectory 
     */
    public SaveManager(String saveDirectory){
        Arrays.fill(this.listOfFile, "empty");
        this.listSaves();
        SAVE_DIRECTORY = saveDirectory;
    }
    
    /**
     * liste toutes les sauvegardes existantes et les stockent dans un tableau
     */
    public final void listSaves(){
        File f = new File(SAVE_DIRECTORY);
        String[] tempListOfFile = f.list();
        for(int i = 0; i < tempListOfFile.length; i++){
            for(int j = 0; j < NUMBER_OF_SAVE; j++){
                if(tempListOfFile[i].equals((j+1)+".txt")){
                    this.listOfFile[j] = (j+1)+".txt";
                }
            }
        }
    }
    
    /**
     * permet de supprimer une sauvegarde
     * @param fileName nom du fichier à supprimer
     */
    public void delete(String fileName){
        File f = new File(SAVE_DIRECTORY+"/"+fileName);
        f.delete();
    }
    
    /**
     * renvoie la liste des sauvegardes
     * @return liste des sauvegardes
     */
    public String[] getlistOfFile(){
        return this.listOfFile;
    }
    
    /**
     * sauvegarde un objet au chemin indiqué
     * @param obj objet à sauvegarder
     * @param path chemin où sauvegarder le fichier
     * @throws IOException exception lever si il est impossible de sauvegarder le fichier
     */
    public static void save(Object obj, String path) throws IOException{
        try{
            FileOutputStream f = new FileOutputStream(new File(path));
            ObjectOutputStream o = new ObjectOutputStream(f);
            
            o.writeObject(obj);
            
            o.close();
            f.close();
        } catch(IOException e){
            System.out.println("Error initializing stream");
        }
    }
    
    /**
     * sauvegarde l'objet indiqué dans la case de sauvegarde indiqué
     * @param obj objet à sauvegarder
     * @param position numéro de la case où sauvegarder le fichier
     * @throws IOException
     * @throws IllegalArgumentException 
     */
    public void save(Object obj, int position) throws IOException, IllegalArgumentException{
        try{
            if(position > NUMBER_OF_SAVE || position < 1){
                throw new IllegalArgumentException();
            }
            FileOutputStream f = new FileOutputStream(new File(SAVE_DIRECTORY+"/"+position+".txt"));
            ObjectOutputStream o = new ObjectOutputStream(f);
            
            o.writeObject(obj);
            
            o.close();
            f.close();
            
            this.listSaves();
                        
        } catch(IOException e){
            System.out.println("Error initializing stream");
        } catch(IllegalArgumentException e){
            System.out.println("Wrong argument in method call");
        }
    }
    
    /**
     * charge l'objet indiqué
     * @param fileName nom du fichier à charger
     * @return fichier chargé
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    public Object load(String fileName) throws IOException, ClassNotFoundException{
        try{
            FileInputStream fi = new FileInputStream(new File(SAVE_DIRECTORY+"/"+fileName));
            ObjectInputStream oi = new ObjectInputStream(fi);
            
            SavableGrid loadedGrid = (SavableGrid)oi.readObject();
            
            oi.close();
            fi.close();
            
            this.listSaves();
            
            return loadedGrid;
            
        } catch(IOException e){
            System.out.println("File not found");
            return null;
            
        } catch(ClassNotFoundException e){
            System.out.println("Class not found");
            return null;
        }
    }
    
}
