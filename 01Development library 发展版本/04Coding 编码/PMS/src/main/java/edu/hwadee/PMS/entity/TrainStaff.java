package edu.hwadee.PMS.entity;
// default package

import java.util.HashSet;
import java.util.Set;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.alibaba.fastjson.JSON;

/**
 * TrainStaff entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "training_staff", catalog = "pms")

public class TrainStaff implements java.io.Serializable {

	// Fields

	/**
	* 
	*/
	private static final long serialVersionUID = 5902417404976113097L;
	private TrainStaffId id;
	private Integer traWorkerAge;
	private String traWorkerSex;
	private String traWorkerResponsibility;

	// Constructors

	/** default constructor */
	public TrainStaff() {
	}

	/** minimal constructor */
	public TrainStaff(TrainStaffId id) {
		this.id = id;
	}

	/** full constructor */
	public TrainStaff(TrainStaffId id, Integer traWorkerAge, String traWorkerSex, String traWorkerResponsibility) {
		this.id = id;
		this.traWorkerAge = traWorkerAge;
		this.traWorkerSex = traWorkerSex;
		this.traWorkerResponsibility = traWorkerResponsibility;
	}

	// Property accessors
	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "traWorkerId", column = @Column(name = "tra_worker_id", nullable = false) ),
			@AttributeOverride(name = "traWorkerName", column = @Column(name = "tra_worker_name", nullable = false, length = 100) ) })

	public TrainStaffId getId() {
		return this.id;
	}

	public void setId(TrainStaffId id) {
		this.id = id;
	}

	@Column(name = "tra_worker_age")

	public Integer getTraWorkerAge() {
		return this.traWorkerAge;
	}

	public void setTraWorkerAge(Integer traWorkerAge) {
		this.traWorkerAge = traWorkerAge;
	}

	@Column(name = "tra_worker_sex", length = 1)

	public String getTraWorkerSex() {
		return this.traWorkerSex;
	}

	public void setTraWorkerSex(String traWorkerSex) {
		this.traWorkerSex = traWorkerSex;
	}

	@Column(name = "tra_worker_responsibility", length = 100)

	public String getTraWorkerResponsibility() {
		return this.traWorkerResponsibility;
	}

	public void setTraWorkerResponsibility(String traWorkerResponsibility) {
		this.traWorkerResponsibility = traWorkerResponsibility;
	}

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}

}