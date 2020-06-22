package com.madang.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.madang.vo.Boardreply;

@Mapper
public interface BoardreplyMapper {

	Boardreply insertBoardreply(Boardreply boardreply);

	List<Boardreply> selectBoardreplylist(int boardid);

	
}
