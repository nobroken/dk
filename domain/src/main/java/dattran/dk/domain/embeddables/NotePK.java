package dattran.dk.domain.embeddables;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class NotePK implements Serializable {
	private static final long serialVersionUID = 1L;
	@Column(name = "student_id")
	private Integer studentId;
	@Column(name = "exam_id")
	private Integer examId;

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public Integer getExamId() {
		return examId;
	}

	public void setExamId(Integer examId) {
		this.examId = examId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((examId == null) ? 0 : examId.hashCode());
		result = prime * result + ((studentId == null) ? 0 : studentId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NotePK other = (NotePK) obj;
		if (examId == null) {
			if (other.examId != null)
				return false;
		} else if (!examId.equals(other.examId))
			return false;
		if (studentId == null) {
			if (other.studentId != null)
				return false;
		} else if (!studentId.equals(other.studentId))
			return false;
		return true;
	}

}
