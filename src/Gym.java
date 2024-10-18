import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class Gym {
    public void generate(int songCount){
        String file = "src\\Spotify dataset_exported.csv";
        BufferedReader reader = null;
        String line = "";
        ArrayList<String> collection = new ArrayList<>();

        try{
            reader = new BufferedReader(new FileReader(file));
            while((line = reader.readLine()) != null){
                String[] trackData = line.split("\",\"");
                String energyStr = trackData[5];

                if(energyStr.length() > 1){
                    if(!energyStr.equals("Energy")){
                        double energy = Double.parseDouble(energyStr);

                        String artist = trackData[0];
                        String trackName = trackData[1];
                        String artistName = artist.substring(1);

                        if(energy >= 0.85){
                            collection.add(artistName + " - " + trackName);
                        }
                    }
                }

            }

            Random random = new Random();
                ArrayList<String> playlist = new ArrayList<>();
                for(int i = 0; i < songCount; i++){
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
