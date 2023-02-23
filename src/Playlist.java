import java.util.Arrays;

/**
 * 
 * @author good0161
 * @version 4.0.2
 *
 */
public class Playlist {
	private Song[] songs;
	private int numSongs;
	private static final int MIN_CAPACITY = 3;
	
	public Playlist() {
		this.songs = new Song[MIN_CAPACITY];
		this.numSongs = 0;
	}
	public Playlist(int capacity) {
		if(capacity >= MIN_CAPACITY)
			this.songs = new Song[capacity];
		else
			this.songs = new Song[MIN_CAPACITY];
		this.numSongs = 0;
	}
	
	public int getCapacity() {
		return songs.length;
	}
	public int getNumSongs() {
		return numSongs;
	}
	public Song getSong(int index) {
		if(index > -1 && index < numSongs)
			return songs[index];
		else
			return null;
	}
	public Song[] getSongs() {
		return Arrays.copyOf(songs, numSongs);
	}
	
	public boolean addSong(Song song) {
		return addSong(numSongs, song);
	}
	public boolean addSong(int index, Song song) {
		if(index > -1 && index <= numSongs && song != null && numSongs != songs.length) {
			for(int i = numSongs - 1; i >= index; i--)
				songs[i+1] = songs[i];
			songs[index] = song;
			numSongs++;
			return true;
		}
		else
			return false;
	}
	public int addSongs(Playlist playlist) {
		if (playlist == null)
			return 0;
		int y = playlist.numSongs;
		int count = 0;
		if ((count < y) && getCapacity() > numSongs ) 
			for (int i = 0; (count < y) && (getCapacity() > getNumSongs()); ++i) {
				addSong(playlist.getSong(i));
				count++;
			}
		return count;
	}
	public Song removeSong() {
		return removeSong(numSongs - 1);
	}
	public Song removeSong(int index) {
		if (songs == null || index > numSongs - 1 || index < 0 || numSongs == 0) 
			return null;
		Song rtn = songs[index];
		for (int i = index; i < numSongs -1; ++i) 
			songs[i] = songs[i + 1];
		numSongs--;
		return rtn;
	}
}
