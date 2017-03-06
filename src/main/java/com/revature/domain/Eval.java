package com.revature.domain;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@Table(name="ie_eval")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Eval implements Serializable{
	
	@Id
	@Column(name="e_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="evalSeq")
	@SequenceGenerator(allocationSize=1, name="evalSeq", sequenceName="eval_seq")
	private Integer id;
	
	@Column(name="e_week")
	private Integer week;
	
	@Column(name="e_date")
	private Date date;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="e_eval_type")
	private EvalType evalType;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="e_pid_trainee")
	private Person trainee;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="e_batch")
	private Batch batch;

	public Eval() {/*empty constructor needed*/}
	
	public Eval(Integer id, Integer week, Date date, EvalType evalType, Person trainee, Batch batch) {
		super();
		this.id = id;
		this.week = week;
		this.date = date;
		this.evalType = evalType;
		this.trainee = trainee;
		this.batch = batch;
	}

	public Integer getId() {
		return id;
	}

	public Integer getWeek() {
		return week;
	}

	public Date getDate() {
		return date;
	}

	public EvalType getEvalType() {
		return evalType;
	}

	public Person getTrainee() {
		return trainee;
	}

	public Batch getBatch() {
		return batch;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 47 * hash + Objects.hashCode(this.id);
		hash = 47 * hash + Objects.hashCode(this.week);
		hash = 47 * hash + Objects.hashCode(this.date);
		hash = 47 * hash + Objects.hashCode(this.evalType);
		hash = 47 * hash + Objects.hashCode(this.trainee);
		hash = 47 * hash + Objects.hashCode(this.batch);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Eval other = (Eval) obj;
		if (!Objects.equals(this.id, other.id)) {
			return false;
		}
		if (!Objects.equals(this.week, other.week)) {
			return false;
		}
		if (!Objects.equals(this.date, other.date)) {
			return false;
		}
		if (!Objects.equals(this.evalType, other.evalType)) {
			return false;
		}
		if (!Objects.equals(this.trainee, other.trainee)) {
			return false;
		}
		if (!Objects.equals(this.batch, other.batch)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Eval{" + "id=" + id + ", week=" + week + ", date=" + date + ", evalType=" + evalType + ", trainee=" + trainee + ", batch=" + batch + '}';
	}
	
	
	
}