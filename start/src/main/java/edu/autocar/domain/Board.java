package edu.autocar.domain;

import java.util.Date;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Board {

	private int boardId;
	@NotEmpty(message = "제목은 필수 항목입니다.")
	private String title;
	@NotEmpty(message = "작성자는 필수 항목입니다.")
	private String writer;
	@NotEmpty(message = "비밀번호는 필수 항목입니다.")
	@Length(min = 4, message = "비밀번호는 4자리 이상이어야 합니다.")
	private String password;
	private String content;
	private int readCnt;
	private Date regDate;
	private Date updateDate;
	
}
