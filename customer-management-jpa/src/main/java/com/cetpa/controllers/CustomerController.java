package com.cetpa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cetpa.entities.Customer;
import com.cetpa.services.CustomerService;

@Controller
@RequestMapping("customer-management")
public class CustomerController 
{
	@Autowired private CustomerService customerService;
	
	@RequestMapping("")
	public String getHomeView()
	{
		return "home";
	}
	@RequestMapping("add")
	public String getAddView()
	{
		return "add-customer";
	}
	@RequestMapping("save-record")
	public String saveCustomerRecord(Customer customer)
	{
		customerService.saveCustomer(customer);
		return "save";
	}
	@RequestMapping("list")
	public String getCustomerList(Model model)
	{
		List<Customer> customerList=customerService.getList();
		model.addAttribute("clist", customerList);
		return "customer-list";
	}
	@RequestMapping("search")
	public String getSearchView()
	{
		return "search-customer";
	}
	@RequestMapping("search-record")
	public String getCustomerRecord(int cid,Model model)
	{
		Customer customer=customerService.getCustomer(cid);
		if(customer==null)
		{
			model.addAttribute("cid",cid);
			model.addAttribute("msg","Customer record not found");
			return "search-customer";
		}
		model.addAttribute("customer",customer);
		return "show-customer";
	}
	@RequestMapping("delete")
	public String getDeleteView()
	{
		return "delete-customer";
	}
	@RequestMapping("confirm-delete")
	public String getConfirmDeleteView(int cid,Model model)
	{
		Customer customer=customerService.getCustomer(cid);
		if(customer==null)
		{
			model.addAttribute("cid",cid);
			model.addAttribute("msg","Customer record does not exist");
			return "delete-customer";
		}
		model.addAttribute("customer",customer);
		return "confirm-delete";
	}
	@RequestMapping("delete-customer")
	public String deleteCustomerRecord(int cid)
	{
		customerService.deleteCustomer(cid);
		return "delete";
	}
	@RequestMapping("edit")
	public String getEditView()
	{
		return "edit-customer";
	}
	@RequestMapping("get-record")
	public String getCustomerRecordView(int cid,Model model)
	{
		Customer customer=customerService.getCustomer(cid);
		if(customer==null)
		{
			model.addAttribute("cid",cid);
			model.addAttribute("msg","Customer record does not exist");
			return "edit-customer";
		}
		model.addAttribute("customer",customer);
		return "update-customer";
	}
	@RequestMapping("update-record")
	public String updateCustomerRecord(Customer customer)
	{
		customerService.updateCustomer(customer);
		return "update";
	}
}
