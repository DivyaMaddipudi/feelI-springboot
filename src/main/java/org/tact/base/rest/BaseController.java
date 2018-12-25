package org.tact.base.rest;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
     * @param song
     * @return
     * 
     * 
     * Possible urls:
	 * 		http://localhost:1878/feeli/song
	 * 
     */
    @GetMapping(value = "/song")
    public <T> T getSongByState(
    		@RequestParam(value = "song")String song) {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        
        map.put("state", song);
        map.put("Song", songMapper.findBySong(song));
        
        return (T) map;
    }
    
    /**
     * 
     * @param country
     * @return
     * 
     * Possible urls:
	 * 		http://localhost:1878/base/song/by/country
     *
     */
    @GetMapping(value = "/song/by/country")
    public <T> T getSongByCountry(
    @RequestParam(value = "country")String country) {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        
        map.put("country", country);
        map.put("song", songMapper.findByCountry(country));
        return (T) map;
    }
    /**
     * 
     * @param state
     * @return
     * 
     * Possible urls:
	 * 		http://localhost:1878/base/cities
     */
    @GetMapping(value = "/cities")
    public <T> T getCitiesByState(
    		@RequestParam(value = "state")String state) {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        
        map.put("state", state);
        map.put("cities", songMapper.findMultipleSongsByUsername(state));
        
        return (T) map;
    }
    
    
    /**
     * 
     * @param country
     * @return
     * 
     * Possible urls:
	 * 		http://localhost:1878/base/cities/by/country
     */
    @GetMapping(value = "/cities/by/country")
    public <T> T getCitiesByCountry(
    		@RequestParam(value = "country")String country) {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        
        map.put("state", country);
        map.put("cities", songMapper.findMultipleSongsByUsername(country));
        
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
}
