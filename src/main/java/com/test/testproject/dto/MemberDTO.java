package com.test.testproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO {
    private Long member_id;
    private String member_email;
    private String member_password;
    private String member_name;

}
