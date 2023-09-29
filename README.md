# FmRequest
The Last.FM Intergration in Java

# UNDER CONSTRUCTION ⚠️
This library is still in under development

# How to use? 
Example for recentTrack:
```java
public class Main {


    public static void main(String[] args) {

        String API_KEY = "";
        FM fm = new FM();
        fm.setAPI_KEY(API_KEY);

        User user = new User("muraz_kysior");
        try {
            recentTrack recentTrack = new recentTrack(user, fm);
            String track_name = recentTrack.getTrackName();
            String artist_name = recentTrack.getArtistName();
            String album_name = recentTrack.getAlbumName();
            System.out.println(track_name + " - " + artist_name + " Album: " + album_name + " Image: " + recentTrack.getImage(ImageSize.EXTRA_LARGE));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

# How do I get an API?
You have to request for an API on **Last.FM**
URL: https://www.last.fm/api/account/create
**Remember follow ToS of Last.FM** ⚠️
