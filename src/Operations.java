import java.io.*;

public class Operations {

    public Operations(){
        
    }
    
    public void implement(){
        String file = "src\\Spotify dataset_exported.csv";
        BufferedReader reader = null;
        String line = "";

        try{
            reader = new BufferedReader(new FileReader(file));
            while((line = reader.readLine()) != null){
                String[] row = line.split(",");

                for(String index : row){
                    System.out.print(index + " ");
                }
                System.out.println();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            try {
                reader.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public void isThereVideo(String targetTrack){
        String file = "src\\Spotify dataset_exported.csv";
        BufferedReader reader = null;
        String line = "";

        try{
            reader = new BufferedReader(new FileReader(file));
            boolean found = false;
            while((line = reader.readLine()) != null){
                String[] trackData = line.split(",");
                if(trackData[1].equals(targetTrack)){
                    found = true;
                    if(trackData[20].equals("\"true\"")){
                        System.out.println("Yes, this track has a music video.");
                    }
                    else{
                        System.out.println("No, this track does not have a music video.");
                    }
                }
            }
            if(!found){
                System.out.println("Track not found. Check your input for spelling errors.");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            try {
                reader.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public void isLicensed(String targetTrack){
        String file = "src\\Spotify dataset_exported.csv";
        BufferedReader reader = null;
        String line = "";

        try{
            reader = new BufferedReader(new FileReader(file));
            boolean found = false;
            while((line = reader.readLine()) != null){
                String[] trackData = line.split(",");
                if(trackData[1].equals(targetTrack)){
                    found = true;
                    if(trackData[19].equals("\"true\"")){
                        System.out.println("Yes, this track is licensed.");
                    }
                    else{
                        System.out.println("No, this track is not licensed.");
                    }
                }
            }
            if(!found){
                System.out.println("Track not found. Check your input for spelling errors.");
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
