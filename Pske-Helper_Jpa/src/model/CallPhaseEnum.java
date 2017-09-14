package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the CallPhaseEnum database table.
 * 
 */
@Entity
@NamedQuery(name="CallPhaseEnum.findAll", query="SELECT c FROM CallPhaseEnum c")
public class CallPhaseEnum implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CallPhaseEnumID")
	private int callPhaseEnumID;

	private String CPE_Description;

	private boolean CPE_IsAssignable;

	private String CPE_Title;

	//bi-directional many-to-one association to CallPhase
	@OneToMany(mappedBy="callPhaseEnum")
	private List<CallPhase> callPhases;

	public CallPhaseEnum() {
	}

	public int getCallPhaseEnumID() {
		return this.callPhaseEnumID;
	}

	public void setCallPhaseEnumID(int callPhaseEnumID) {
		this.callPhaseEnumID = callPhaseEnumID;
	}

	public String getCPE_Description() {
		return this.CPE_Description;
	}

	public void setCPE_Description(String CPE_Description) {
		this.CPE_Description = CPE_Description;
	}

	public boolean getCPE_IsAssignable() {
		return this.CPE_IsAssignable;
	}

	public void setCPE_IsAssignable(boolean CPE_IsAssignable) {
		this.CPE_IsAssignable = CPE_IsAssignable;
	}

	public String getCPE_Title() {
		return this.CPE_Title;
	}

	public void setCPE_Title(String CPE_Title) {
		this.CPE_Title = CPE_Title;
	}

	public List<CallPhase> getCallPhases() {
		return this.callPhases;
	}

	public void setCallPhases(List<CallPhase> callPhases) {
		this.callPhases = callPhases;
	}

	public CallPhase addCallPhas(CallPhase callPhas) {
		getCallPhases().add(callPhas);
		callPhas.setCallPhaseEnum(this);

		return callPhas;
	}

	public CallPhase removeCallPhas(CallPhase callPhas) {
		getCallPhases().remove(callPhas);
		callPhas.setCallPhaseEnum(null);

		return callPhas;
	}

}