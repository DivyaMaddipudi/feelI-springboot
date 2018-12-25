package org.tact.base.rest;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.tact.base.mybatis.mapper.SongMapper;

@RestController
@RequestMapping(value = "/feeli")
public class BaseController {
	
	@Autowired
    private SongMapper songMapper;
	
	/**
	 * 
	 * @return
	 * 
	 * Possible urls:
	 * 		http://localhost:1878/feeli/
	 */
    @GetMapping(value = "")
    public <T> T testBase() {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        map.put("one", "two");
        map.put("three", "four");
        map.put("five", "six");
        map.put("seven", "eight");
        
        return (T) map;
    }
    
    
    
    /**
     * 
     * @param youtube_link
     * @return
     * 
     * 
     * Possible urls:
	 * 		http://localhost:1878/feeli/by/youtubelink
	 * 
     */
    @GetMapping(value = "/by/youtubelink")
    public <T> T getSongByYoutubelink(
    		@RequestParam(value = "youtube_link")String youtube_link) {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        
        map.put("song", youtube_link);
        map.put("Song", songMapper.findBySong(youtube_link));
        
        return (T) map;
    }
    

    /**
     * 
     * @param username
     * @return
     * 
     * Possible urls:
	 * 		http://localhost:1878/feeli/by/username
     * 
     */
    @GetMapping(value = "/by/username")
    public <T> T getSongsByUsername(
    		@RequestParam(value = "username")String username) {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        
        map.put("username", username);
        map.put("songs", songMapper.findByUsername(username));
        
        return (T) map;
    }
    
    /**
     * 
     * @return
     * 
     * 
     * Possible urls:
	 * 		http://localhost:1878/feeli/find/all
     * 
     */
    @GetMapping(value = "/find/all")
    public <T> T findALL(
    		) {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        
       
        map.put("songs", songMapper.findAll());
        
        return (T) map;
    }
    
    /**
     * 
     * @param username
     * @param youtube_link
     * @param comments
     * @return
     * 
     * Possible urls:
	 * 		http://localhost:1878/feeli/add/song
     * 
     */
    @PostMapping(value = {"/add/song"})
   	public  <T> T addSong(
   		@RequestParam(value = "username")String username,
   		@RequestParam(value = "youtube_link")String youtube_link,
   		@RequestParam(value = "comments")String comments
   	)
   	{
       	Map<String, Object> params = new HashMap<String, Object>();
       	params.put("USERNAME", username);
       	params.put("YOUTUBE_LINK", youtube_link);
       	params.put("COMMENTS", comments);
       	
   		songMapper.addSong(params);
   		 
   	    Map<String, Object> map = new LinkedHashMap<String, Object>();
   	    map.put("apiresult", 0);
   	    map.put("apimessage", "ok");
   	
   	    return (T) map;
   	}
}
