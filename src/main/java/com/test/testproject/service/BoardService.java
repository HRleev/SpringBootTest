package com.test.testproject.service;

import com.test.testproject.dto.BoardDTO;
import com.test.testproject.entity.BoardEntity;
import com.test.testproject.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    public Long save(BoardDTO boardDTO) {
        BoardEntity boardEntity=BoardEntity.toSaveEntity(boardDTO);
        return boardRepository.save(boardEntity).getBoard_id();
    }

    public List<BoardDTO> findAll() {
        List<BoardEntity> boardEntityList=boardRepository.findAll();
        List<BoardDTO>boardDTOList=new ArrayList<>();
        for(BoardEntity list:boardEntityList){
            boardDTOList.add(BoardDTO.toDTO(list));
        }return boardDTOList;
    }
    public BoardDTO findById(Long board_id) {
        Optional<BoardEntity> optionalBoardEntity=boardRepository.findById(board_id);
        if(optionalBoardEntity.isPresent()){
            BoardEntity boardEntity=optionalBoardEntity.get();
            return BoardDTO.toDTO(boardEntity);
        }else{
            return null;
        }
}
    }
