package edu.hwadee.PMS.entity;
// default package

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.alibaba.fastjson.JSON;

/**
 * GeneralStaffId entity. @author MyEclipse Persistence Tools
 */
@Embeddable

public class GeneralStaffId implements java.io.Serializable {

	// Fields

	/**
	* 
	*/
	private static final long serialVersionUID = -9154576586713448320L;
	private Integer traWorkerId2;
	private String traWorkerName2;

	// Constructors

	/** default constructor */
	public GeneralStaffId() {
	}

	/** full constructor */
	public GeneralStaffId(Integer traWorkerId2, String traWorkerName2) {
		this.traWorkerId2 = traWorkerId2;
		this.traWorkerName2 = traWorkerName2;
	}

	// Property accessors

	@Column(name = "tra_worker_id2", nullable = false)

	public Integer getTraWorkerId2() {
		return this.traWorkerId2;
	}

	public void setTraWorkerId2(Integer traWorkerId2) {
		this.traWorkerId2 = traWorkerId2;
	}

	@Column(name = "tra_worker_name2", nullable = false, length = 100)

	public String getTraWorkerName2() {
		return this.traWorkerName2;
	}

	public void setTraWorkerName2(String traWorkerName2) {
		this.traWorkerName2 = traWorkerName2;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof GeneralStaffId))
			return false;
		GeneralStaffId castOther = (GeneralStaffId) other;

		return ((this.getTraWorkerId2() == castOther.getTraWorkerId2()) || (this.getTraWorkerId2() != null
				&& castOther.getTraWorkerId2() != null && this.getTraWorkerId2().equals(castOther.getTraWorkerId2())))
				&& ((this.getTraWorkerName2() == castOther.getTraWorkerName2())
						|| (this.getTraWorkerName2() != null && castOther.getTraWorkerName2() != null
								&& this.getTraWorkerName2().equals(castOther.getTraWorkerName2())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getTraWorkerId2() == null ? 0 : this.getTraWorkerId2().hashCode());
		result = 37 * result + (getTraWorkerName2() == null ? 0 : this.getTraWorkerName2().hashCode());
		return result;
	}

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}

}