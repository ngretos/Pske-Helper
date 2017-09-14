package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the FundingSource database table.
 * 
 */
@Entity
@NamedQuery(name="FundingSource.findAll", query="SELECT f FROM FundingSource f")
public class FundingSource implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="SourceID")
	private int sourceID;

	private String FS_Code;

	private String FS_Description;

	private String FS_MISCode;

	private short FS_SourceTypeID;

	private String FS_Title;

	private byte[] FS_ts;

	@Column(name="ParentID")
	private int parentID;

	//bi-directional one-to-one association to Call
	@OneToOne(mappedBy="fundingSource")
	private Call call;

	public FundingSource() {
	}

	public int getSourceID() {
		return this.sourceID;
	}

	public void setSourceID(int sourceID) {
		this.sourceID = sourceID;
	}

	public String getFS_Code() {
		return this.FS_Code;
	}

	public void setFS_Code(String FS_Code) {
		this.FS_Code = FS_Code;
	}

	public String getFS_Description() {
		return this.FS_Description;
	}

	public void setFS_Description(String FS_Description) {
		this.FS_Description = FS_Description;
	}

	public String getFS_MISCode() {
		return this.FS_MISCode;
	}

	public void setFS_MISCode(String FS_MISCode) {
		this.FS_MISCode = FS_MISCode;
	}

	public short getFS_SourceTypeID() {
		return this.FS_SourceTypeID;
	}

	public void setFS_SourceTypeID(short FS_SourceTypeID) {
		this.FS_SourceTypeID = FS_SourceTypeID;
	}

	public String getFS_Title() {
		return this.FS_Title;
	}

	public void setFS_Title(String FS_Title) {
		this.FS_Title = FS_Title;
	}

	public byte[] getFS_ts() {
		return this.FS_ts;
	}

	public void setFS_ts(byte[] FS_ts) {
		this.FS_ts = FS_ts;
	}

	public int getParentID() {
		return this.parentID;
	}

	public void setParentID(int parentID) {
		this.parentID = parentID;
	}

	public Call getCall() {
		return this.call;
	}

	public void setCall(Call call) {
		this.call = call;
	}

}