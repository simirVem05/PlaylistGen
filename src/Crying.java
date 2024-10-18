import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class Crying {
    public void generate(int songCount){
        String file = "src\\Spotify dataset_exported.csv";
        BufferedReader reader = null;
        String line = "";
        ArrayList<String> collection = new ArrayList<>();

        try{
            reader = new BufferedReader(new FileReader(file));
            while((line = reader.readLine()) != null){
                String[] trackData = line.split("\",\"");
                String valenceStr = trackData[11];

                if(valenceStr.length() > 1){
                    if(!valenceStr.equals("Valence")){
                        double valence = Double.parseDouble(valenceStr);

                        String artist = trackData[0];
                        String trackName = trackData[1];
                        String artistName = artist.substring(1);

                        if(valence <= .35){
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
