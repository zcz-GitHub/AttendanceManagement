package db.entity;
// Generated 2015-12-15 23:14:26 by Hibernate Tools 4.3.1.Final

/**
 * Tc generated by hbm2java
 */
public class Tc implements java.io.Serializable {

	private TcId id;
	private Integer cweek;
	private Integer cday;
	private Integer ctime;
	private Integer checkTime;
	private Integer maxAbsence;

	public Tc() {
	}

	public Tc(TcId id) {
		this.id = id;
	}

	public Tc(TcId id, Integer cweek, Integer cday, Integer ctime, Integer checkTime, Integer maxAbsence) {
		this.id = id;
		this.cweek = cweek;
		this.cday = cday;
		this.ctime = ctime;
		this.checkTime = checkTime;
		this.maxAbsence = maxAbsence;
	}

	public TcId getId() {
		return this.id;
	}

	public void setId(TcId id) {
		this.id = id;
	}

	public Integer getCweek() {
		return this.cweek;
	}

	public void setCweek(Integer cweek) {
		this.cweek = cweek;
	}

	public Integer getCday() {
		return this.cday;
	}

	public void setCday(Integer cday) {
		this.cday = cday;
	}

	public Integer getCtime() {
		return this.ctime;
	}

	public void setCtime(Integer ctime) {
		this.ctime = ctime;
	}

	public Integer getCheckTime() {
		return this.checkTime;
	}

	public void setCheckTime(Integer checkTime) {
		this.checkTime = checkTime;
	}

	public Integer getMaxAbsence() {
		return this.maxAbsence;
	}

	public void setMaxAbsence(Integer maxAbsence) {
		this.maxAbsence = maxAbsence;
	}

}
