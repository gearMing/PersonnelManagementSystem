package edu.hwadee.PMS.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.hwadee.PMS.entity.QImfo;

@Transactional
public interface QImfoRepository extends JpaRepository<QImfo, Integer> {
	//QImfo findByQuestionnaireId(Integer QuestionnaireId);
	//QImfo saveByQuestionnaireId(Integer QuestionnaireId);
}