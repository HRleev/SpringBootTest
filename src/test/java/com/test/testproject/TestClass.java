package com.test.testproject;

import com.test.testproject.dto.BoardDTO;
import com.test.testproject.repository.BoardRepository;
import com.test.testproject.service.BoardService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;
@SpringBootTest
public class TestClass {
    @Autowired BoardService boardService;
    @Autowired BoardRepository boardRepository;

    @Test
    @Transactional
    @Rollback
    @DisplayName("saveTest")
    public void saveTest(){
        BoardDTO boardDTO=new BoardDTO("qqq","www","eee");
        Long id=boardService.save(boardDTO);
        BoardDTO saveDTO= boardService.findById(id);
        assertThat(boardDTO.getBoard_writer()).isEqualTo(saveDTO.getBoard_writer());
    }
}
