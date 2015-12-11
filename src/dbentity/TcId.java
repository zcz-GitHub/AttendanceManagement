package dbentity;

// Generated 2015-12-11 11:02:07 by Hibernate Tools 4.0.0

/**
 * TcId generated by hbm2java
 */
public class TcId implements java.io.Serializable {

	private String tno;
	private String cno;

	public TcId() {
	}

	public TcId(String tno, String cno) {
		this.tno = tno;
		this.cno = cno;
	}

	public String getTno() {
		return this.tno;
	}

	public void setTno(String tno) {
		this.tno = tno;
	}

	public String getCno() {
		return this.cno;
	}

	public void setCno(String cno) {
		this.cno = cno;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TcId))
			return false;
		TcId castOther = (TcId) other;

		return ((this.getTno() == castOther.getTno()) || (this.getTno() != null
				&& castOther.getTno() != null && this.getTno().equals(
				castOther.getTno())))
				&& ((this.getCno() == castOther.getCno()) || (this.getCno() != null
						&& castOther.getCno() != null && this.getCno().equals(
						castOther.getCno())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getTno() == null ? 0 : this.getTno().hashCode());
		result = 37 * result
				+ (getCno() == null ? 0 : this.getCno().hashCode());
		return result;
	}

}
