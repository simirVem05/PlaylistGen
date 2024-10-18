import java.io.*;
import java.util.*;

public class Music{
    public static void main(String[] args) throws IOException{
        int playlistPref;
        int songCount;
        Scanner scan;
        scan = new Scanner(System.in);
    
        
        System.out.println("Hi! Welcome to Playlist Generator 2024! What kind of playlist do you want to generate today?"
        +"\n"
        +"\n1. Party Playlist"
        +"\n-Positive songs with high energy to suit a party environment."
        +"\n2. Study Playlist"
        +"\n-Calm and mellow songs which are perfect for studying."
        +"\n3. Crying Playlist"
        +"\n-Somber tunes for a broken heart."
        +"\n4. Gym Playlist"
        +"\n-A high energy playlist for a workout."
        );
        playlistPref = scan.nextInt();

        System.out.println(
        "\n"
        +"\n"
        +"\n"
        +"How many songs would you like in the playlist?"
        +"\n1. 20" 
        +"\n2. 50"
        +"\n3. 100"
        );
        songCount = scan.nextInt();
        
        if(songCount == 1){
            songCount = 20;
        }
        else if(songCount == 2){
            songCount = 50;
        }
        else{
            songCount = 100;
        }

        if(playlistPref == 1){
            scan = new Scanner(System.in);
            
            File text = new File("playlist.txt");
            PrintStream output = new PrintStream(text);
            System.setOut(output);

            Party party = new Party();
            party.generate(songCount);
            
        
        }
        else if(playlistPref == 2){
            scan = new Scanner(System.in);

            File text = new File("playlist.txt");
            PrintStream output = new PrintStream(text);
            System.setOut(output);

            Study study = new Study();
            study.generate(songCount);


        }
        else if(playlistPref == 3){
            scan = new Scanner(System.in);

            File text = new File("playlist.txt");
            PrintStream output = new PrintStream(text);
            System.setOut(output);

            Crying cryingSesh = new Crying();
            cryingSesh.generate(songCount);
        }
        else if(playlistPref == 4){
            scan = new Scanner(System.in);

            File text = new File("playlist.txt");
            PrintStream output = new PrintStream(text);
            System.setOut(output);

            Gym gym = new Gym();
            gym.generate(songCount);
        }
            
    }

}