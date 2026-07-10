import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class ScoreManager {

    private static final String FILE_NAME = "bestscore.txt";


    public static void saveScore(int score){

        ArrayList<Integer> scores = loadScores();

        scores.add(score);

        Collections.sort(scores, Collections.reverseOrder());


        if(scores.size() > 5){

            scores.remove(5);

        }


        try{

            BufferedWriter bw =
                    new BufferedWriter(
                            new FileWriter(FILE_NAME)
                    );


            for(int s : scores){

                bw.write(String.valueOf(s));
                bw.newLine();

            }


            bw.close();


        }catch(IOException e){

            e.printStackTrace();

        }

    }



    public static ArrayList<Integer> loadScores(){

        ArrayList<Integer> scores = new ArrayList<>();


        try{

            File file = new File(FILE_NAME);


            if(!file.exists()){

                file.createNewFile();

                return scores;

            }


            BufferedReader br =
                    new BufferedReader(
                            new FileReader(file)
                    );


            String line;


            while((line = br.readLine()) != null){

                scores.add(Integer.parseInt(line));

            }


            br.close();


        }catch(IOException e){

            e.printStackTrace();

        }


        return scores;

    }

}