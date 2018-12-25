package org.tact.base.mybatis.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.tact.base.mybatis.domain.Song;

@Mapper
public interface SongMapper {

	List<Song> findBySong(@Param("youtube_link") String youtube_link);
	
	List<Song> findByUsername(@Param("username") String username);
	
	Song findByCountry(@Param("country") String country);
	
	List<Song> findAll();
	
	void addSong(Map<String, Object> params);

}
