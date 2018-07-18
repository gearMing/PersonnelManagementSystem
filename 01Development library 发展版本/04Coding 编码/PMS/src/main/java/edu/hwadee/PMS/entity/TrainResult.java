package edu.hwadee.PMS.entity;
// default package

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

import com.alibaba.fastjson.JSON;

/**
 * 培训结果
 * @author kingsong
 *
 */
@Entity
@Table(name = "training_result", catalog = "pms")
public class TrainResult implements java.io.Serializable {

	// Fields

	/**
	* 
	*/
	private static final long serialVersionUID = 3134213330854142250L;
	private Integer trainingResultId;
	private TrainPlan trainPlan;
	private String reult;

	// Constructors
	/** default constructor */
	public TrainResult() {
	}

	/** full constructor */
	public TrainResult(TrainPlan trainPlan, String reult) {
		this.reult = reult;
		this.trainPlan = trainPlan;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")

	@Column(name = "trainingresultid", unique = true, nullable = false)

	public Integer getTrainingResultId() {
		return this.trainingResultId;
	}

	public void setTrainingResultId(Integer trainingResultId) {
		this.trainingResultId = trainingResultId;
	}

	@Column(name = "Reult", length = 1000)
	public String getReult() {
		return this.reult;
	}

	public void setReult(String reult) {
		this.reult = reult;
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