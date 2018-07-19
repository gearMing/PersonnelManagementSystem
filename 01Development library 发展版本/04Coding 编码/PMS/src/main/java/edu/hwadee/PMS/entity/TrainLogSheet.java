package edu.hwadee.PMS.entity;
// default package

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;

/**
 * 培训明细记录表
 */
@Entity
@Table(name = "training_logsheet", catalog = "pms")
public class TrainLogSheet implements java.io.Serializable {

	// Fields

	/**
	* 
	*/
	private static final long serialVersionUID = -7659721401748053461L;
	private Integer id;
	private TrainStaff trainStaff;
	private TrainPlan trainPlan;
	private String traingingCategory;
	private String training;
	private Integer numberPeople;
	
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date time;
	private String purpose;
	private String object;
	private String sponsor;
	private String trainingArea;
	private String remark;

	// Constructors

	/** default constructor */
	public TrainLogSheet() {
	}

	

	public TrainLogSheet(TrainStaff trainStaff, TrainPlan trainPlan, String traingingCategory, String training,
			Integer numberPeople, Date time, String purpose, String object, String sponsor, String trainingArea,
			String remark) {
		super();
		this.trainStaff = trainStaff;
		this.trainPlan = trainPlan;
		this.traingingCategory = traingingCategory;
		this.training = training;
		this.numberPeople = numberPeople;
		this.time = time;
		this.purpose = purpose;
		this.object = object;
		this.sponsor = sponsor;
		this.trainingArea = trainingArea;
		this.remark = remark;
	}



	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")

	@Column(name = "id", unique = true, nullable = false)

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "tra_worker_id", referencedColumnName = "tra_worker_id"),
			@JoinColumn(name = "tra_worker_name", referencedColumnName = "tra_worker_name") })

	public TrainStaff getTrainStaff() {
		return this.trainStaff;
	}

	public void setTrainStaff(TrainStaff trainStaff) {
		this.trainStaff = trainStaff;
	}

	@Column(name = "trainging_category", length = 100)

	public String getTraingingCategory() {
		return this.traingingCategory;
	}

	public void setTraingingCategory(String traingingCategory) {
		this.traingingCategory = traingingCategory;
	}

	@Column(name = "Training", length = 100)

	public String getTraining() {
		return this.training;
	}

	public void setTraining(String training) {
		this.training = training;
	}

	@Column(name = "number_people")

	public Integer getNumberPeople() {
		return this.numberPeople;
	}

	public void setNumberPeople(Integer numberPeople) {
		this.numberPeople = numberPeople;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "time", length = 10)

	public Date getTime() {
		return this.time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	@Column(name = "purpose", length = 1000)

	public String getPurpose() {
		return this.purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	@Column(name = "object", length = 100)

	public String getObject() {
		return this.object;
	}

	public void setObject(String object) {
		this.object = object;
	}

	@Column(name = "sponsor", length = 100)

	public String getSponsor() {
		return this.sponsor;
	}

	public void setSponsor(String sponsor) {
		this.sponsor = sponsor;
	}

	@Column(name = "training_area", length = 100)

	public String getTrainingArea() {
		return this.trainingArea;
	}

	public void setTrainingArea(String trainingArea) {
		this.trainingArea = trainingArea;
	}

	@Column(name = "remark", length = 1000)

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}

	@OneToOne
	@JoinColumn(name="assessment")
	public TrainPlan getTrainPlan() {
		return trainPlan;
	}

	public void setTrainPlan(TrainPlan trainPlan) {
		this.trainPlan = trainPlan;
	}

}