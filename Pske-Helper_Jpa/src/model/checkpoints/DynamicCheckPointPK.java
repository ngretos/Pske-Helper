package model.checkpoints;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the DynamicCheckPoints database table.
 * 
 */
@Embeddable
public class DynamicCheckPointPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int DCP_CheckPointID;

	private short DCP_LookUpGroupID;

	public DynamicCheckPointPK() {
	}
	public int getDCP_CheckPointID() {
		return this.DCP_CheckPointID;
	}
	public void setDCP_CheckPointID(int DCP_CheckPointID) {
		this.DCP_CheckPointID = DCP_CheckPointID;
	}
	public short getDCP_LookUpGroupID() {
		return this.DCP_LookUpGroupID;
	}
	public void setDCP_LookUpGroupID(short DCP_LookUpGroupID) {
		this.DCP_LookUpGroupID = DCP_LookUpGroupID;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DynamicCheckPointPK)) {
			return false;
		}
		DynamicCheckPointPK castOther = (DynamicCheckPointPK)other;
		return 
			(this.DCP_CheckPointID == castOther.DCP_CheckPointID)
			&& (this.DCP_LookUpGroupID == castOther.DCP_LookUpGroupID);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.DCP_CheckPointID;
		hash = hash * prime + ((int) this.DCP_LookUpGroupID);
		
		return hash;
	}
}