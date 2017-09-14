package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the CallPhase database table.
 * 
 */
@Entity
@NamedQuery(name="CallPhase.findAll", query="SELECT c FROM CallPhase c")
public class CallPhase implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CallPhaseID")
	private int callPhaseID;

	private String CP_Comments;

	private Timestamp CP_EndDate;

	private int CP_OnInitContractStateID;

	private Timestamp CP_StartDate;

	//bi-directional many-to-one association to Call
	@ManyToOne
	@JoinColumn(name="CP_CallID")
	private Call call;

	//bi-directional many-to-one association to CallPhaseEnum
	@ManyToOne
	@JoinColumn(name="CP_CallPhaseEnumID")
	private CallPhaseEnum callPhaseEnum;

	//bi-directional many-to-one association to CheckPointCategory
	@OneToMany(mappedBy="callPhase")
	private List<CheckPointCategory> checkPointCategories;

	public CallPhase() {
	}

	public int getCallPhaseID() {
		return this.callPhaseID;
	}

	public void setCallPhaseID(int callPhaseID) {
		this.callPhaseID = callPhaseID;
	}

	public String getCP_Comments() {
		return this.CP_Comments;
	}

	public void setCP_Comments(String CP_Comments) {
		this.CP_Comments = CP_Comments;
	}

	public Timestamp getCP_EndDate() {
		return this.CP_EndDate;
	}

	public void setCP_EndDate(Timestamp CP_EndDate) {
		this.CP_EndDate = CP_EndDate;
	}

	public int getCP_OnInitContractStateID() {
		return this.CP_OnInitContractStateID;
	}

	public void setCP_OnInitContractStateID(int CP_OnInitContractStateID) {
		this.CP_OnInitContractStateID = CP_OnInitContractStateID;
	}

	public Timestamp getCP_StartDate() {
		return this.CP_StartDate;
	}

	public void setCP_StartDate(Timestamp CP_StartDate) {
		this.CP_StartDate = CP_StartDate;
	}

	public Call getCall() {
		return this.call;
	}

	public void setCall(Call call) {
		this.call = call;
	}

	public CallPhaseEnum getCallPhaseEnum() {
		return this.callPhaseEnum;
	}

	public void setCallPhaseEnum(CallPhaseEnum callPhaseEnum) {
		this.callPhaseEnum = callPhaseEnum;
	}

	public List<CheckPointCategory> getCheckPointCategories() {
		return this.checkPointCategories;
	}

	public void setCheckPointCategories(List<CheckPointCategory> checkPointCategories) {
		this.checkPointCategories = checkPointCategories;
	}

	public CheckPointCategory addCheckPointCategory(CheckPointCategory checkPointCategory) {
		getCheckPointCategories().add(checkPointCategory);
		checkPointCategory.setCallPhase(this);

		return checkPointCategory;
	}

	public CheckPointCategory removeCheckPointCategory(CheckPointCategory checkPointCategory) {
		getCheckPointCategories().remove(checkPointCategory);
		checkPointCategory.setCallPhase(null);

		return checkPointCategory;
	}

}