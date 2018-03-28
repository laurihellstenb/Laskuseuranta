package fi.hh.swd20.Laskuseuranta.domain;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 
 * @author Lauri Hellsten
 *
 */

@Entity
public class Invoice {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private String accountno;
	private String referenceno;
	private Date duedate;
	private double amount;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "paymentid")
	private Payment payment;

	public Invoice(String name, String accountno, String referenceno, Date duedate, double amount, Payment payment) {
		super();
		this.name = name;
		this.accountno = accountno;
		this.referenceno = referenceno;
		this.duedate = duedate;
		this.amount = amount;
		this.payment = payment;
	}

	public Invoice() {
		super();
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAccountno() {
		return accountno;
	}

	public String getReferenceno() {
		return referenceno;
	}

	public Date getDuedate() {
		return duedate;
	}

	public double getAmount() {
		return amount;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAccountno(String accountno) {
		this.accountno = accountno;
	}

	public void setReferenceno(String referenceno) {
		this.referenceno = referenceno;
	}

	public void setDuedate(Date duedate) {
		this.duedate = duedate;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	@Override
	public String toString() {
		if (this.payment != null)
			return "Invoice [name=" + name + ", accountno=" + accountno + ", referenceno=" + referenceno + ", duedate="
					+ duedate + ", amount=" + amount + ", payment=" + this.getPayment() + "]";
		else
			return "Invoice [name=" + name + ", accountno=" + accountno + ", referenceno=" + referenceno + ", duedate="
					+ duedate + ", amount=" + amount + "]";
	}

}
