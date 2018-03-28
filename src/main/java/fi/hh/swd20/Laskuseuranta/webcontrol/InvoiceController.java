package fi.hh.swd20.Laskuseuranta.webcontrol;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fi.hh.swd20.Laskuseuranta.domain.Invoice;
import fi.hh.swd20.Laskuseuranta.domain.InvoiceRepository;
import fi.hh.swd20.Laskuseuranta.domain.PaymentRepository;

/**
 * 
 * @author Lauri Hellsten
 *
 */

@Controller
public class InvoiceController {

	@Autowired
	private InvoiceRepository repository;

	@Autowired
	private PaymentRepository prepository;

	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/invoicelist", method = RequestMethod.GET)
	public String invoiceList(Model model) {
		model.addAttribute("invoices", repository.findAll());
		return "invoicelist";
	}

	@RequestMapping(value = "/invoices", method = RequestMethod.GET)
	public @ResponseBody List<Invoice> invoicelistRest() {
		return (List<Invoice>) repository.findAll();
	}

	@RequestMapping(value = "/invoices/{id}", method = RequestMethod.GET)
	public @ResponseBody Invoice findInvoiceRest(@PathVariable("id") Long invoiceId) {
		return repository.findOne(invoiceId);
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/add")
	public String addInvoice(Model model) {
		model.addAttribute("invoice", new Invoice());
		model.addAttribute("payments", prepository.findAll());
		return "addinvoice";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Invoice invoice) {
		repository.save(invoice);
		return "redirect:invoicelist";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteInvoice(@PathVariable("id") Long invoiceId, Model model) {
		repository.delete(invoiceId);
		return "redirect:../invoicelist";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editInvoice(@PathVariable("id") Long invoiceId, Model model) {
		model.addAttribute("invoice", repository.findOne(invoiceId));
		model.addAttribute("payments", prepository.findAll());
		return "editinvoice";
	}

}
