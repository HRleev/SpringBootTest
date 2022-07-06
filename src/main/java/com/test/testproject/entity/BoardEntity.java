package com.test.testproject.entity;

import com.test.testproject.dto.BoardDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@Table(name = "board_test_table")
public class BoardEntity  extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long board_id;

    @Column(nullable = false,length = 30)
    private String board_writer;

    @Column(nullable = false,length = 50)
    private String board_title;

    @Column(length = 500)
    private String board_contents;

    @Column
    private int board_hits;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private MemberEntity memberEntity;

    public static BoardEntity toSaveEntity(BoardDTO boardDTO) {
        BoardEntity boardEntity=new BoardEntity();
        boardEntity.setBoard_contents(boardDTO.getBoard_contents());
        boardEntity.setBoard_title(boardDTO.getBoard_title());
        boardEntity.setBoard_writer(boardDTO.getBoard_writer());
        boardEntity.setBoard_hits(boardDTO.getBoard_hits());
        return boardEntity;
    }
}
