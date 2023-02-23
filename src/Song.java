import java.util.Arrays;

/**
 * 
 * @author good0161
 * @version 4.0.1
 *
 */
public class Song {
	private String title;
	private String artist;
	private int[] time;
	
	public Song(String title, String artist, int[] time) {
		this.title = title;
		this.artist = artist;
		this.time = Arrays.copyOf(time, time.length);
	}
	
	public String getTitle() {
		return title;
	}
	public String getArtist() {
		return artist;
	}
	public int[] getTime() {
		int[] copy = Arrays.copyOf(time, time.length);
		return copy;
	}
}
