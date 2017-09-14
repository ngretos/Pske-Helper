package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the CheckPointGroup database table.
 * 
 */
@Entity
@NamedQuery(name="CheckPointGroup.findAll", query="SELECT c FROM CheckPointGroup c")
public class CheckPointGroup implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CheckPointGroupID")
	private int checkPointGroupID;

	private String CPG_Code;

	private String CPG_Title;

	//bi-directional many-to-one association to CheckPoint
	@OneToMany(mappedBy="checkPointGroup")
	private List<CheckPoint> checkPoints;

	//bi-directional many-to-one association to CheckPointCategory
	@ManyToOne
	@JoinColumn(name="CPG_CheckPointCategoryID")
	private CheckPointCategory checkPointCategory;

	public CheckPointGroup() {
	}

	public int getCheckPointGroupID() {
		return this.checkPointGroupID;
	}

	public void setCheckPointGroupID(int checkPointGroupID) {
		this.checkPointGroupID = checkPointGroupID;
	}

	public String getCPG_Code() {
		return this.CPG_Code;
	}

	public void setCPG_Code(String CPG_Code) {
		this.CPG_Code = CPG_Code;
	}

	public String getCPG_Title() {
		return this.CPG_Title;
	}

	public void setCPG_Title(String CPG_Title) {
		this.CPG_Title = CPG_Title;
	}

	public List<CheckPoint> getCheckPoints() {
		return this.checkPoints;
	}

	public void setCheckPoints(List<CheckPoint> checkPoints) {
		this.checkPoints = checkPoints;
	}

	public CheckPoint addCheckPoint(CheckPoint checkPoint) {
		getCheckPoints().add(checkPoint);
		checkPoint.setCheckPointGroup(this);

		return checkPoint;
	}

	public CheckPoint removeCheckPoint(CheckPoint checkPoint) {
		getCheckPoints().remove(checkPoint);
		checkPoint.setCheckPointGroup(null);

		return checkPoint;
	}

	public CheckPointCategory getCheckPointCategory() {
		return this.checkPointCategory;
	}

	public void setCheckPointCategory(CheckPointCategory checkPointCategory) {
		this.checkPointCategory = checkPointCategory;
	}

}