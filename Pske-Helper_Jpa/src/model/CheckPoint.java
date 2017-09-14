package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the CheckPoint database table.
 * 
 */
@Entity
@NamedQuery(name="CheckPoint.findAll", query="SELECT c FROM CheckPoint c")
public class CheckPoint implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CheckPointID")
	private int checkPointID;

	private String CP_ActionArgs;

	private String CP_ActionCommandName;

	private String CP_ActionHelpText;

	private short CP_CheckPointTypeID;

	private String CP_Code;

	private String CP_Description;

	private boolean CP_HasAction;

	private boolean CP_HasComments;

	private String CP_HelpText;

	private boolean CP_IsMandatory;

	private boolean CP_IsReadOnly;

	//bi-directional many-to-one association to CheckPointGroup
	@ManyToOne
	@JoinColumn(name="CP_CheckPointGroupID")
	private CheckPointGroup checkPointGroup;

	//bi-directional many-to-one association to DynamicCheckPoint
	@OneToMany(mappedBy="checkPoint")
	private List<DynamicCheckPoint> dynamicCheckPoints;

	public CheckPoint() {
	}

	public int getCheckPointID() {
		return this.checkPointID;
	}

	public void setCheckPointID(int checkPointID) {
		this.checkPointID = checkPointID;
	}

	public String getCP_ActionArgs() {
		return this.CP_ActionArgs;
	}

	public void setCP_ActionArgs(String CP_ActionArgs) {
		this.CP_ActionArgs = CP_ActionArgs;
	}

	public String getCP_ActionCommandName() {
		return this.CP_ActionCommandName;
	}

	public void setCP_ActionCommandName(String CP_ActionCommandName) {
		this.CP_ActionCommandName = CP_ActionCommandName;
	}

	public String getCP_ActionHelpText() {
		return this.CP_ActionHelpText;
	}

	public void setCP_ActionHelpText(String CP_ActionHelpText) {
		this.CP_ActionHelpText = CP_ActionHelpText;
	}

	public short getCP_CheckPointTypeID() {
		return this.CP_CheckPointTypeID;
	}

	public void setCP_CheckPointTypeID(short CP_CheckPointTypeID) {
		this.CP_CheckPointTypeID = CP_CheckPointTypeID;
	}

	public String getCP_Code() {
		return this.CP_Code;
	}

	public void setCP_Code(String CP_Code) {
		this.CP_Code = CP_Code;
	}

	public String getCP_Description() {
		return this.CP_Description;
	}

	public void setCP_Description(String CP_Description) {
		this.CP_Description = CP_Description;
	}

	public boolean getCP_HasAction() {
		return this.CP_HasAction;
	}

	public void setCP_HasAction(boolean CP_HasAction) {
		this.CP_HasAction = CP_HasAction;
	}

	public boolean getCP_HasComments() {
		return this.CP_HasComments;
	}

	public void setCP_HasComments(boolean CP_HasComments) {
		this.CP_HasComments = CP_HasComments;
	}

	public String getCP_HelpText() {
		return this.CP_HelpText;
	}

	public void setCP_HelpText(String CP_HelpText) {
		this.CP_HelpText = CP_HelpText;
	}

	public boolean getCP_IsMandatory() {
		return this.CP_IsMandatory;
	}

	public void setCP_IsMandatory(boolean CP_IsMandatory) {
		this.CP_IsMandatory = CP_IsMandatory;
	}

	public boolean getCP_IsReadOnly() {
		return this.CP_IsReadOnly;
	}

	public void setCP_IsReadOnly(boolean CP_IsReadOnly) {
		this.CP_IsReadOnly = CP_IsReadOnly;
	}

	public CheckPointGroup getCheckPointGroup() {
		return this.checkPointGroup;
	}

	public void setCheckPointGroup(CheckPointGroup checkPointGroup) {
		this.checkPointGroup = checkPointGroup;
	}

	public List<DynamicCheckPoint> getDynamicCheckPoints() {
		return this.dynamicCheckPoints;
	}

	public void setDynamicCheckPoints(List<DynamicCheckPoint> dynamicCheckPoints) {
		this.dynamicCheckPoints = dynamicCheckPoints;
	}

	public DynamicCheckPoint addDynamicCheckPoint(DynamicCheckPoint dynamicCheckPoint) {
		getDynamicCheckPoints().add(dynamicCheckPoint);
		dynamicCheckPoint.setCheckPoint(this);

		return dynamicCheckPoint;
	}

	public DynamicCheckPoint removeDynamicCheckPoint(DynamicCheckPoint dynamicCheckPoint) {
		getDynamicCheckPoints().remove(dynamicCheckPoint);
		dynamicCheckPoint.setCheckPoint(null);

		return dynamicCheckPoint;
	}

}