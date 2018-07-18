package edu.hwadee.PMS.entity;
// default package

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

import com.alibaba.fastjson.JSON;

/**
 * 培训计划
 * @author kingsong
 *
 */
@Entity
@Table(name = "training_plan", catalog = "pms")
public class TrainPlan implements java.io.Serializable {

	// Fields

	/**
	* 
	*/
	private static final long serialVersionUID = -6706564343274247948L;
	private Integer assessment;
	private Integer budget;
	private String planName;

	// Constructors

	/** default constructor */
	public TrainPlan() {
	}

	/** full constructor */
	public TrainPlan(Integer budget, String planName) {
		this.budget = budget;
		this.planName = planName;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "assigned")
	@Id
	@GeneratedValue(generator = "generator")

	@Column(name = "assessment", unique = true, nullable = false)

	public Integer getAssessment() {
		return this.assessment;
	}

	public void setAssessment(Integer assessment) {
		this.assessment = assessment;
	}

	@Column(name = "budget")

	public Integer getBudget() {
		return this.budget;
	}

	public void setBudget(Integer budget) {
		this.budget = budget;
	}

	@Column(name = "plan_name", length = 100)

	public String getPlanName() {
		return this.planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}


	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}

}