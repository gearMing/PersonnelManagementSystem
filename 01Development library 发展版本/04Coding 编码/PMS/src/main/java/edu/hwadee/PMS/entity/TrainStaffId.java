package edu.hwadee.PMS.entity;
// default package

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.alibaba.fastjson.JSON;

/**
 * TrainStaffId entity. @author MyEclipse Persistence Tools
 */
@Embeddable

public class TrainStaffId implements java.io.Serializable {

	// Fields

	/**
	* 
	*/
	private static final long serialVersionUID = -686561551209515731L;
	private Integer traWorkerId;
	private String traWorkerName;

	// Constructors

	/** default constructor */
	public TrainStaffId() {
	}

	/** full constructor */
	public TrainStaffId(Integer traWorkerId, String traWorkerName) {
		this.traWorkerId = traWorkerId;
		this.traWorkerName = traWorkerName;
	}

	// Property accessors

	@Column(name = "tra_worker_id", nullable = false)

	public Integer getTraWorkerId() {
		return this.traWorkerId;
	}

	public void setTraWorkerId(Integer traWorkerId) {
		this.traWorkerId = traWorkerId;
	}

	@Column(name = "tra_worker_name", nullable = false, length = 100)

	public String getTraWorkerName() {
		return this.traWorkerName;
	}

	public void setTraWorkerName(String traWorkerName) {
		this.traWorkerName = traWorkerName;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TrainStaffId))
			return false;
		TrainStaffId castOther = (TrainStaffId) other;

		return ((this.getTraWorkerId() == castOther.getTraWorkerId()) || (this.getTraWorkerId() != null
				&& castOther.getTraWorkerId() != null && this.getTraWorkerId().equals(castOther.getTraWorkerId())))
				&& ((this.getTraWorkerName() == castOther.getTraWorkerName())
						|| (this.getTraWorkerName() != null && castOther.getTraWorkerName() != null
								&& this.getTraWorkerName().equals(castOther.getTraWorkerName())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getTraWorkerId() == null ? 0 : this.getTraWorkerId().hashCode());
		result = 37 * result + (getTraWorkerName() == null ? 0 : this.getTraWorkerName().hashCode());
		return result;
	}

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}

}