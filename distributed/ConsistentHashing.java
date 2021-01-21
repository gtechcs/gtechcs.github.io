import java.util.*;
import java.io.File;

public class ConsistentHashing {


    public static void main(String[] args){
        ConsistentHashingServer(5);

    }

    public static List<String> words (){
        List<String> words = new ArrayList<>();
        try{
            Scanner sc = new Scanner(new File("words.txt"));
            while(sc.hasNext()){
                String line = sc.nextLine();
                words.add(line.trim());
            }
            return words;
        }catch(Exception e){
            return words;
        }
    }

    public static int getHash(String word, int modulus ){
        int hash = 0;
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            // System.out.println(c);
            hash = hash * 10 + c;
            if(hash >= modulus){
                hash = hash%modulus;
            }
        }
        return hash%modulus;
    }


    public static class Generator implements Runnable {
        List<String> words = words();
        Random r = new Random();
        int ringSize;
        int[] theRing;
        Generator(int ringSize, int[] theRing){
            this.ringSize = ringSize;
            this.theRing = theRing;
        }

        public void run() {
            // do stuff here
            while(true){
                int i = r.nextInt(words.size());
                int hash = getHash(words.get(i), ringSize);
                System.out.println("RandomWordfChosen:   "+ words.get(i));
                System.out.println("hash   "+ getHash(words.get(i), ringSize));
                int server = theRing[hash];
                System.out.println("Put in    Server"+ server);
                try{
                    Thread.sleep(1000);
                }catch(Exception e){
                }
            }
        }
    }

    public static void ConsistentHashingServer(int initialServers){
        int ringSize= 100;
        int replication = 3;

        List<String> servers = new ArrayList<>(initialServers);
        int[] theRing = new int[ringSize];

        Map<String, List<String>> serverData = new HashMap<>(initialServers);
        for(int i = 0; i< initialServers;  i++){
            servers.add("Server"+ i);
            serverData.put("Server"+ i, new ArrayList<>());
        }

        //Setting Up the virtualRing
        int segmentSize = initialServers * replication;
        int bucketSize = ringSize/segmentSize;
        for(int i = 0; i< ringSize; i++){
            int server = i / bucketSize;
            server = server % initialServers;
            theRing[i] = server;
            System.out.println(i + "    "+ server);
        }

        Thread generator = new Thread(new Generator(ringSize, theRing));
        generator.start();


    }

}