package com.mysite.board.Repository;

import com.mysite.board.Entity.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {

    List<Question> findByTitleContaining(String searchKeyword);

    Optional<List<Question>> findByCategory(String category);
}
