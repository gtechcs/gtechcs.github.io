import java.util.*;

public class UniqueIDGenerator{

    public static void main(String[] args){
        // Thread uUIDGenerator = new Thread(new UUIDGenerator());
        //uUIDGenerator.start();

        snowFlakeId();
    }

    /*
    * Snowflake id: 41 bits lsb of timestamp, 10 bits machine id, 12 bits sequence number
    */
    public static long snowFlakeId(){
        long id = 0;
        long top1sMask = 1152921504606846976l;
        long millis = System.currentTimeMillis();
        // System.out.println("millis  "+millis);
        millis = millis << 22;
        // System.out.println("millis  "+ millis);
        long top41bitsTime = millis^top1sMask;
        // 10111011100100111111101011011011100111011
        // 101110111001001111111010110110111001110110000000000000000000000
        // 100110111001001111111010110110111001110110000000000000000000000
        // 100110111001001111111100000101101010011010000000000000000000000
//        System.out.println("millis^topis  "+ (millis^top1sMask));
        long machineId = 687;// 10 bits, 1010101111 
//        System.out.println("machineId   "+ machineId);
        machineId = machineId << 12;
//        System.out.println("machineId   "+ machineId);

        long maxSequenceNumber = 4095;// 111111111111
        long snowFlake = machineId;
//        for(int i =0; i<= maxSequenceNumber; i++){
        for(int i =0; i<= 12; i++){
            snowFlake = machineId ^ i;
            // System.out.println("snowFlake   "+ snowFlake);// 1010101111-0000000000110
            snowFlake = snowFlake ^ top41bitsTime;
            System.out.println("snowFlakeID   "+ snowFlake);// 1010101111-0000000000110
        }
        return id;
    }

    public static class UUIDGenerator implements Runnable {
        public void run() {
            // do stuff here
            System.out.println("128 bit uuids:  " );
            while(true){
                UUID uuid = UUID.randomUUID();
                System.out.println(uuid);
 
                try{
                    Thread.sleep(1000);
                }catch(Exception e){}
            }
        }
    }

}