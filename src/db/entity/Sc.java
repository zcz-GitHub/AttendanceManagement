package db.entity;
// Generated 2015-12-15 23:14:26 by Hibernate Tools 4.3.1.Final

/**
 * Sc generated by hbm2java
 */
public class Sc implements java.io.Serializable {

	private ScId id;
	private Integer absenceNum;

	public Sc() {
	}

	public Sc(ScId id) {
		this.id = id;
	}

	public Sc(ScId id, Integer absenceNum) {
		this.id = id;
		this.absenceNum = absenceNum;
	}

	public ScId getId() {
		return this.id;
	}

	public void setId(ScId id) {
		this.id = id;
	}

	public Integer getAbsenceNum() {
		return this.absenceNum;
	}

	public void setAbsenceNum(Integer absenceNum) {
		this.absenceNum = absenceNum;
	}

}
