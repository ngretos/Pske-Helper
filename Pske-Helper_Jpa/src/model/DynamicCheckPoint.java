package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the DynamicCheckPoints database table.
 * 
 */
@Entity
@Table(name="DynamicCheckPoints")
@NamedQuery(name="DynamicCheckPoint.findAll", query="SELECT d FROM DynamicCheckPoint d")
public class DynamicCheckPoint implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DynamicCheckPointPK id;

	private boolean DCP_UseLookUpID;

	//bi-directional many-to-one association to CheckPoint
	@ManyToOne
	@JoinColumn(name="DCP_CheckPointID")
	private CheckPoint checkPoint;

	public DynamicCheckPoint() {
	}

	public DynamicCheckPointPK getId() {
		return this.id;
	}

	public void setId(DynamicCheckPointPK id) {
		this.id = id;
	}

	public boolean getDCP_UseLookUpID() {
		return this.DCP_UseLookUpID;
	}

	public void setDCP_UseLookUpID(boolean DCP_UseLookUpID) {
		this.DCP_UseLookUpID = DCP_UseLookUpID;
	}

	public CheckPoint getCheckPoint() {
		return this.checkPoint;
	}

	public void setCheckPoint(CheckPoint checkPoint) {
		this.checkPoint = checkPoint;
	}

}