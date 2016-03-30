package codewars;

public class DubStep {
	public static void main(String[] args) {
		System.out.println(songDecoder("RWUBWUBWUBLWUB"));
	}
	  public static String songDecoder (String song)
	  {
	     // strip prefix WUBs 
	     while (song.startsWith("WUB")) {
	       song = song.substring(3);
	     }
	     
	     // strip suffix WUBs
	     
	     while (song.endsWith("WUB")) {
	       song = song.substring(0, song.length() -3);
	     }
	     //replace every other WUB with a space
	     song = song.replaceAll("WUB", " ");
	     //compress spaces
	     song = song.replaceAll(" +", " ");
	     
	     return song;
	   }
	}
