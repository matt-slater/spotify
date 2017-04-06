import java.util.*;
import java.util.concurrent.atomic.AtomicLong;


public class ZipfsSong {

    public static void main(String[] args) {

        Kattio in = new Kattio(System.in);

        long m = in.getLong();
        long n = in.getLong();

        ArrayList<Song> songArrayList = new ArrayList<Song>();

        //add first song

        long plays = in.getLong();
        String firstTitle = in.getWord();
        songArrayList.add(new Song(firstTitle, plays));

        //add rest of songs

        for (long i = 0; i < m - 1; i++) {
            long numPlays = in.getLong();
            String title = in.getWord();
            songArrayList.add(new Song(title, (numPlays * (i+2))));
        }

        Collections.sort(songArrayList);

        for (int i = 0; i < n; i++) {
            System.out.println(songArrayList.get(i).getTitle());
        }

    }
}

class Song implements Comparable<Song> {

    private double quality;
    private String title;

    public Song(String title, double quality) {
        this.title = title;
        this.quality = quality;
    }

    @Override
    public int compareTo(Song o2) {
        if (this.quality < o2.getQuality()) {
            return 1;
        } else if (this.quality > o2.getQuality()) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Song{" +
                ", quality=" + quality +
                ", title='" + title + '\'' +
                '}';
    }

    public double getQuality() {
        return quality;
    }

    public void setQuality(double quality) {
        this.quality = quality;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
