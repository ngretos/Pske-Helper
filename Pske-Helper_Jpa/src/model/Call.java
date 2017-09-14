package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the Call database table.
 * 
 */
@Entity
@NamedQuery(name=Call.GET_ALL_CALLS, query="SELECT c FROM Call c")
public class Call implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final String GET_ALL_CALLS = "Call.findAll";

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int callID;

	private BigDecimal CL_Budget;

	private int CL_CallOwnerID;

	private String CL_CodeMask;

	private int CL_CodeStartNumber;

	private Timestamp CL_FromDate;

	private String CL_FundingDescription;

	private BigDecimal CL_MaxBudget;

	private int CL_MaxProjectDuration;

	private BigDecimal CL_MinBudget;

	private double CL_PublicFundingPercentage;

	private Timestamp CL_ToDate;

	private byte[] CL_ts;

	private BigDecimal CL_ValuationMultiplier;

	//bi-directional one-to-one association to FundingSource
	@OneToOne @MapsId
	@JoinColumn(name="CallID")
	private FundingSource fundingSource;

	//bi-directional many-to-one association to CallPhase
	@OneToMany(mappedBy="call")
	private List<CallPhase> callPhases;

	public Call() {
	}

	public int getCallID() {
		return this.callID;
	}

	public void setCallID(int callID) {
		this.callID = callID;
	}

	public BigDecimal getCL_Budget() {
		return this.CL_Budget;
	}

	public void setCL_Budget(BigDecimal CL_Budget) {
		this.CL_Budget = CL_Budget;
	}

	public int getCL_CallOwnerID() {
		return this.CL_CallOwnerID;
	}

	public void setCL_CallOwnerID(int CL_CallOwnerID) {
		this.CL_CallOwnerID = CL_CallOwnerID;
	}

	public String getCL_CodeMask() {
		return this.CL_CodeMask;
	}

	public void setCL_CodeMask(String CL_CodeMask) {
		this.CL_CodeMask = CL_CodeMask;
	}

	public int getCL_CodeStartNumber() {
		return this.CL_CodeStartNumber;
	}

	public void setCL_CodeStartNumber(int CL_CodeStartNumber) {
		this.CL_CodeStartNumber = CL_CodeStartNumber;
	}

	public Timestamp getCL_FromDate() {
		return this.CL_FromDate;
	}

	public void setCL_FromDate(Timestamp CL_FromDate) {
		this.CL_FromDate = CL_FromDate;
	}

	public String getCL_FundingDescription() {
		return this.CL_FundingDescription;
	}

	public void setCL_FundingDescription(String CL_FundingDescription) {
		this.CL_FundingDescription = CL_FundingDescription;
	}

	public BigDecimal getCL_MaxBudget() {
		return this.CL_MaxBudget;
	}

	public void setCL_MaxBudget(BigDecimal CL_MaxBudget) {
		this.CL_MaxBudget = CL_MaxBudget;
	}

	public int getCL_MaxProjectDuration() {
		return this.CL_MaxProjectDuration;
	}

	public void setCL_MaxProjectDuration(int CL_MaxProjectDuration) {
		this.CL_MaxProjectDuration = CL_MaxProjectDuration;
	}

	public BigDecimal getCL_MinBudget() {
		return this.CL_MinBudget;
	}

	public void setCL_MinBudget(BigDecimal CL_MinBudget) {
		this.CL_MinBudget = CL_MinBudget;
	}

	public double getCL_PublicFundingPercentage() {
		return this.CL_PublicFundingPercentage;
	}

	public void setCL_PublicFundingPercentage(double CL_PublicFundingPercentage) {
		this.CL_PublicFundingPercentage = CL_PublicFundingPercentage;
	}

	public Timestamp getCL_ToDate() {
		return this.CL_ToDate;
	}

	public void setCL_ToDate(Timestamp CL_ToDate) {
		this.CL_ToDate = CL_ToDate;
	}

	public byte[] getCL_ts() {
		return this.CL_ts;
	}

	public void setCL_ts(byte[] CL_ts) {
		this.CL_ts = CL_ts;
	}

	public BigDecimal getCL_ValuationMultiplier() {
		return this.CL_ValuationMultiplier;
	}

	public void setCL_ValuationMultiplier(BigDecimal CL_ValuationMultiplier) {
		this.CL_ValuationMultiplier = CL_ValuationMultiplier;
	}

	public FundingSource getFundingSource() {
		return this.fundingSource;
	}

	public void setFundingSource(FundingSource fundingSource) {
		this.fundingSource = fundingSource;
	}

	public List<CallPhase> getCallPhases() {
		return this.callPhases;
	}

	public void setCallPhases(List<CallPhase> callPhases) {
		this.callPhases = callPhases;
	}

	public CallPhase addCallPhas(CallPhase callPhas) {
		getCallPhases().add(callPhas);
		callPhas.setCall(this);

		return callPhas;
	}

	public CallPhase removeCallPhas(CallPhase callPhas) {
		getCallPhases().remove(callPhas);
		callPhas.setCall(null);

		return callPhas;
	}

}