package org.tact.base.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.tact.base.mybatis.domain.Song;

@Mapper
public interface SongMapper {

	Song findBySong(@Param("song") String song);
	
	List<Song> findMultipleSongsByUsername(@Param("username") String username);
	
	Song findByCountry(@Param("country") String country);
	
	List<Song> findAll();

}
