package videoteka;

import exception.NotFoundException;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class VideoTeka implements Serializable{
    private Map<String, Video> videoMap = new HashMap<>();
    private Map<String, OktatoVideo> oktatoVideoMap = new HashMap<>();

    public VideoTeka() {
    }

    public void add(Video video){
        if (video instanceof OktatoVideo){
            this.oktatoVideoMap.put(video.getFilmCime(), (OktatoVideo) video);
        } else {
            this.videoMap.put(video.getFilmCime(), video);
        }
    }

    public Video keres(String videocime, Boolean oktatoVideoE) throws NotFoundException{
        if (oktatoVideoE){
            return keres(videocime, videoMap);
        } else {
            return keres(videocime, oktatoVideoMap);
        }
    }

    private <E extends Video>Video keres(String videocime, Map<String, E> videoMap) throws NotFoundException{
        if (videoMap.containsKey(videocime)){
            return videoMap.get(videocime);
        } else {
            throw new NotFoundException ("Nincs a tékában!");
        }
    }
}
