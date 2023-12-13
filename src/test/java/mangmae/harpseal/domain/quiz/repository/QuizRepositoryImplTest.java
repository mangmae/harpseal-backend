package mangmae.harpseal.domain.quiz.repository;

import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.extern.slf4j.Slf4j;
import mangmae.harpseal.domain.quiz.repository.dto.QuizSearchRepositoryCond;
import mangmae.harpseal.domain.quiz.repository.dto.QuizSearchRepositoryDto;
import mangmae.harpseal.entity.Quiz;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.*;


@Slf4j
@SpringBootTest
@Transactional(readOnly = true)
class QuizRepositoryImplTest {

    public static final String PREFIX = UUID.randomUUID().toString().substring(0, 8);

    @PersistenceContext
    EntityManager em;

    JPAQueryFactory queryFactory;

    @Autowired QuizQueryRepository quizRepositoryImpl;

    @BeforeEach
    void beforeEach() {

        queryFactory = new JPAQueryFactory(em);
        // 데이터를 초기화한다.
        Quiz quiz1 = new Quiz(PREFIX + "quiz1", "quiz1 description", "12345");
        Quiz quiz2 = new Quiz(PREFIX + "quiz2", "quiz2 description", "12345");
        Quiz quiz3 = new Quiz(PREFIX + "quiz3", "quiz3 description", "12345");
        Quiz quiz4 = new Quiz(PREFIX + "quiz4", "quiz4 description", "12345");

        for (int i = 0; i < 1; i++) quiz1.addPlayTime();
        for (int i = 0; i < 2; i++) quiz2.addPlayTime();
        for (int i = 0; i < 3; i++) quiz3.addPlayTime();
        for (int i = 0; i < 4; i++) quiz4.addPlayTime();

        log.info("quiz1={}", quiz1);
        log.info("quiz2={}", quiz2);
        log.info("quiz3={}", quiz3);
        log.info("quiz4={}", quiz4);

        em.persist(quiz1);
        em.persist(quiz2);
        em.persist(quiz3);
        em.persist(quiz4);

    }

    @Test
    @Transactional
    @DisplayName("플레이 횟수를 기준으로 검색")
    public void playTimeSearchTest(){
        //given
        QuizSearchRepositoryCond condition = new QuizSearchRepositoryCond(PREFIX);
        //when
        List<QuizSearchRepositoryDto> playTimeDesc = quizRepositoryImpl.findPlayTimeDesc(condition, 0, 4);
        List<QuizSearchRepositoryDto> playTimeAsc = quizRepositoryImpl.findPlayTimeAsc(condition, 0, 4);

        //then
        assertThat(playTimeDesc)
            .extracting("title")
            .containsExactly(PREFIX + "quiz4", PREFIX + "quiz3", PREFIX + "quiz2", PREFIX + "quiz1");
        assertThat(playTimeAsc)
            .extracting("title")
            .containsExactly(PREFIX + "quiz1", PREFIX + "quiz2", PREFIX + "quiz3", PREFIX + "quiz4");

    }

    @Test
    @Transactional
    @DisplayName("퀴즈 생성시간을 기준으로 검색")
    public void recentSearchTest() {
        //given
        QuizSearchRepositoryCond condition = new QuizSearchRepositoryCond(PREFIX);
        //when
        List<QuizSearchRepositoryDto> recentDesc = quizRepositoryImpl.findRecentDesc(condition, 0, 4);
        List<QuizSearchRepositoryDto> recentAsc = quizRepositoryImpl.findRecentAsc(condition, 0, 4);

        //퀴즈 생성 순서가 quiz1 -> quiz2 -> quiz3 -> quiz4 인것에 유의
        //then
        assertThat(recentDesc)
            .extracting("title")
            .containsExactly(PREFIX + "quiz4", PREFIX + "quiz3", PREFIX + "quiz2", PREFIX + "quiz1");
        assertThat(recentAsc)
            .extracting("title")
            .containsExactly(PREFIX + "quiz1", PREFIX + "quiz2", PREFIX + "quiz3", PREFIX + "quiz4");

    }

}