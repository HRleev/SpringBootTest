package com.test.testproject.dto;

import com.test.testproject.entity.BoardEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardDTO {
    private Long board_id;
    private String board_writer;
    private String board_title;
    private String board_contents;
    private int board_hits;
    private LocalDateTime board_created_time;

    public BoardDTO(String board_writer, String board_title, String board_contents) {
        this.board_writer = board_writer;
        this.board_title = board_title;
        this.board_contents = board_contents;
    }

    public static BoardDTO toDTO(BoardEntity boardEntity) {
        BoardDTO boardDTO=new BoardDTO();
        boardDTO.setBoard_id(boardEntity.getBoard_id());
        boardDTO.setBoard_writer(boardEntity.getBoard_writer());
        boardDTO.setBoard_title(boardEntity.getBoard_title());
        boardDTO.setBoard_contents(boardEntity.getBoard_contents());
        boardDTO.setBoard_hits(boardEntity.getBoard_hits());
        return boardDTO;
    }
}
