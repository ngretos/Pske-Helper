package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the CheckPointCategory database table.
 * 
 */
@Entity
@NamedQuery(name="CheckPointCategory.findAll", query="SELECT c FROM CheckPointCategory c")
public class CheckPointCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CheckPointCategoryID")
	private int checkPointCategoryID;

	private String CPC_Code;

	private String CPC_Title;

	//bi-directional many-to-one association to CallPhase
	@ManyToOne
	@JoinColumn(name="CPC_CallPhaseID")
	private CallPhase callPhase;

	//bi-directional many-to-one association to CheckPointGroup
	@OneToMany(mappedBy="checkPointCategory")
	private List<CheckPointGroup> checkPointGroups;

	public CheckPointCategory() {
	}

	public int getCheckPointCategoryID() {
		return this.checkPointCategoryID;
	}

	public void setCheckPointCategoryID(int checkPointCategoryID) {
		this.checkPointCategoryID = checkPointCategoryID;
	}

	public String getCPC_Code() {
		return this.CPC_Code;
	}

	public void setCPC_Code(String CPC_Code) {
		this.CPC_Code = CPC_Code;
	}

	public String getCPC_Title() {
		return this.CPC_Title;
	}

	public void setCPC_Title(String CPC_Title) {
		this.CPC_Title = CPC_Title;
	}

	public CallPhase getCallPhase() {
		return this.callPhase;
	}

	public void setCallPhase(CallPhase callPhase) {
		this.callPhase = callPhase;
	}

	public List<CheckPointGroup> getCheckPointGroups() {
		return this.checkPointGroups;
	}

	public void setCheckPointGroups(List<CheckPointGroup> checkPointGroups) {
		this.checkPointGroups = checkPointGroups;
	}

	public CheckPointGroup addCheckPointGroup(CheckPointGroup checkPointGroup) {
		getCheckPointGroups().add(checkPointGroup);
		checkPointGroup.setCheckPointCategory(this);

		return checkPointGroup;
	}

	public CheckPointGroup removeCheckPointGroup(CheckPointGroup checkPointGroup) {
		getCheckPointGroups().remove(checkPointGroup);
		checkPointGroup.setCheckPointCategory(null);

		return checkPointGroup;
	}

}