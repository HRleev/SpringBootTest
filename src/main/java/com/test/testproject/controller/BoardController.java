package com.test.testproject.controller;

import com.test.testproject.dto.BoardDTO;
import com.test.testproject.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
    private final BoardService bs;
    @PostMapping("/save")
    public String save(@ModelAttribute BoardDTO boardDTO){
        bs.save(boardDTO);
        return "redirect:/board";
    }

    @GetMapping("/{board_id}")
    public String findById(@PathVariable Long board_id, Model model){
        BoardDTO boardDTO=bs.findById(board_id);
        model.addAttribute("board",boardDTO);
        return "detail";
    }
    @GetMapping("/")
    public String findAll(Model model){
        List<BoardDTO> boardDTOList=bs.findAll();
        model.addAttribute("boardList",boardDTOList);
        return "/";
    }
}
