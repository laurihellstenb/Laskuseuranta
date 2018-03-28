package fi.hh.swd20.Laskuseuranta.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * 
 * @author Lauri Hellsten
 *
 */

@Entity
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long paymentid;
	private String name;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "payment")
	private List<Invoice> invoices;

	public Payment() {
	}

	public Payment(String name) {
		super();
		this.name = name;

	}

	public Long getPaymentid() {
		return paymentid;
	}

	public String getName() {
		return name;
	}

	public List<Invoice> getInvoices() {
		return invoices;
	}

	public void setPaymentid(Long paymentid) {
		this.paymentid = paymentid;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setInvoices(List<Invoice> invoices) {
		this.invoices = invoices;
	}

	@Override
	public String toString() {
		return "Payment [paymentid=" + paymentid + ", name=" + name + "]";
	}

}
