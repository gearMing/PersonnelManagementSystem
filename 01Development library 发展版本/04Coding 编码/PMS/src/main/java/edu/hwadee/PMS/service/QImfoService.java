package edu.hwadee.PMS.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.hwadee.PMS.entity.QImfo;
import edu.hwadee.PMS.repository.QImfoRepository;

@Service
@Transactional
public class QImfoService extends BaseService {

	public QImfo getQImfo(Integer questionnaireId) {

		return qir.findOne(questionnaireId);

	}
}