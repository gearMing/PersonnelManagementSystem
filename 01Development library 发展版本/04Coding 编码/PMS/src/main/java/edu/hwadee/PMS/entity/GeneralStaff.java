package edu.hwadee.PMS.entity;
// default package

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.alibaba.fastjson.JSON;

/**
 * GeneralStaff entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "general_staff", catalog = "pms")

public class GeneralStaff implements java.io.Serializable {

	// Fields

	/**
	* 
	*/
	private static final long serialVersionUID = 4238585564938312699L;
	private GeneralStaffId id;
	private Integer commonWorkerAge;
	private String commonWorkerSex;
	private String commonWorkerResponsibility;

	// Constructors

	/** default constructor */
	public GeneralStaff() {
	}

	/** minimal constructor */
	public GeneralStaff(GeneralStaffId id) {
		this.id = id;
	}

	/** full constructor */
	public GeneralStaff(GeneralStaffId id, Integer commonWorkerAge, String commonWorkerSex,
			String commonWorkerResponsibility) {
		this.id = id;
		this.commonWorkerAge = commonWorkerAge;
		this.commonWorkerSex = commonWorkerSex;
		this.commonWorkerResponsibility = commonWorkerResponsibility;
	}

	// Property accessors
	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "traWorkerId2", column = @Column(name = "tra_worker_id2", nullable = false) ),
			@AttributeOverride(name = "traWorkerName2", column = @Column(name = "tra_worker_name2", nullable = false, length = 100) ) })

	public GeneralStaffId getId() {
		return this.id;
	}

	public void setId(GeneralStaffId id) {
		this.id = id;
	}

	@Column(name = "common_worker_age")

	public Integer getCommonWorkerAge() {
		return this.commonWorkerAge;
	}

	public void setCommonWorkerAge(Integer commonWorkerAge) {
		this.commonWorkerAge = commonWorkerAge;
	}

	@Column(name = "common_worker_sex", length = 1)

	public String getCommonWorkerSex() {
		return this.commonWorkerSex;
	}

	public void setCommonWorkerSex(String commonWorkerSex) {
		this.commonWorkerSex = commonWorkerSex;
	}

	@Column(name = "common_worker_responsibility", length = 100)

	public String getCommonWorkerResponsibility() {
		return this.commonWorkerResponsibility;
	}

	public void setCommonWorkerResponsibility(String commonWorkerResponsibility) {
		this.commonWorkerResponsibility = commonWorkerResponsibility;
	}

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}

}