import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class Party {
    public void generate(int count){
        String file = "src\\Spotify dataset_exported.csv";
        BufferedReader reader = null;
        String line = "";
        ArrayList<String> collection = new ArrayList<>();
        
        try{
            reader = new BufferedReader(new FileReader(file));
            while((line = reader.readLine()) != null){
                String[] trackData = line.split("\",\"");
                String danceStr = trackData[4];
                String energyStr = trackData[5];
                if(energyStr.length() > 1 && danceStr.length() > 1){
                    if(!trackData[5].equals("Energy") && !trackData[5].equals("Danceability")){
                        double energy = Double.parseDouble(energyStr);
                        double dance = Double.parseDouble(danceStr);
                        
                        String artist = trackData[0];
                        String trackName = trackData[1];
                        String artistName = artist.substring(1);
                        
                        if(energy >= .7){
                            if(dance >= .7){
                                collection.add(artistName + " - " + trackName);
                            }
                        }
                        
                    }
                }
            }

            Random random = new Random();
            ArrayList<String> playlist = new ArrayList<>();
            for(int i = 0; i < count; i++){
                int index = random.nextInt(collection.size());
                String rand = collection.get(index);
                playlist.add(rand);
            }

            for(int i = 0; i < playlist.size(); i++){
                System.out.println(playlist.get(i));
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            try{
                reader.close();
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }

    }
}
