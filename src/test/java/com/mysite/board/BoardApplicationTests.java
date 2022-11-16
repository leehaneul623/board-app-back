package com.mysite.board;

import com.mysite.board.Dto.QuestionDto;
import com.mysite.board.Entity.Question;
import com.mysite.board.Repository.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class BoardApplicationTests {
	@Autowired
	private QuestionRepository questionRepository;
	@Test
	void contextLoads() {
		List<QuestionDto> byTitleContaining = questionRepository.findByTitleContaining("444");
		System.out.println("title: " + byTitleContaining.get(0).getTitle());
	}

}
