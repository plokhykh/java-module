package multithreading.semaphore;

import java.util.Random;

public class AudioChannel {
    private int channelId;

    public AudioChannel(int id) {
        this.channelId = id;
    }

    public int getChannelId() {
        return channelId;
    }

    public void setChannelId(int id) {
        this.channelId = id;
    }

    public void using(){
        try {
            //code using Audio channel
            Thread.sleep(new Random().nextInt(500));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
