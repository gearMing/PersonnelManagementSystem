package edu.hwadee.PMS.entity;
// default package

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.alibaba.fastjson.JSON;

/**
 * QImfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "questionnaire_information", catalog = "pms")

public class QImfo implements java.io.Serializable {

	// Fields

	/**
	* 
	*/
	private static final long serialVersionUID = 1232400405898980228L;
	private Integer questionnaireId;
	private String questionnaireName;
	private Date startTimeOfTrain;
	private Date endTimeOfTrain;
	private String feeling;

	// Constructors

	/** default constructor */
	public QImfo() {
	}

	/** minimal constructor */
	public QImfo(Integer questionnaireId) {
		this.questionnaireId = questionnaireId;
	}

	/** full constructor */
	public QImfo(Integer questionnaireId, String questionnaireName, Date startTimeOfTrain, Date endTimeOfTrain,
			String feeling) {
		this.questionnaireId = questionnaireId;
		this.questionnaireName = questionnaireName;
		this.startTimeOfTrain = startTimeOfTrain;
		this.endTimeOfTrain = endTimeOfTrain;
		this.feeling = feeling;
	}

	// Property accessors
	@Id

	@Column(name = "questionnaireid", unique = true, nullable = false)

	public Integer getQuestionnaireId() {
		return this.questionnaireId;
	}

	public void setQuestionnaireId(Integer questionnaireId) {
		this.questionnaireId = questionnaireId;
	}

	@Column(name = "questionnairename", length = 100)

	public String getQuestionnaireName() {
		return this.questionnaireName;
	}

	public void setQuestionnaireName(String questionnaireName) {
		this.questionnaireName = questionnaireName;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "starttimeoftrain", length = 10)

	public Date getStartTimeOfTrain() {
		return this.startTimeOfTrain;
	}

	public void setStartTimeOfTrain(Date startTimeOfTrain) {
		this.startTimeOfTrain = startTimeOfTrain;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "endtimeoftrain", length = 10)

	public Date getEndTimeOfTrain() {
		return this.endTimeOfTrain;
	}

	public void setEndTimeOfTrain(Date endTimeOfTrain) {
		this.endTimeOfTrain = endTimeOfTrain;
	}

	@Column(name = "feeling", length = 1000)

	public String getFeeling() {
		return this.feeling;
	}

	public void setFeeling(String feeling) {
		this.feeling = feeling;
	}

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}

}