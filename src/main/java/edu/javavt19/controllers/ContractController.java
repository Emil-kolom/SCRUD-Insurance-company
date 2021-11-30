package edu.javavt19.controllers;

import edu.javavt19.dao.hibernate.GenericHibernateImpl;
import edu.javavt19.model2.hibernate.AgentModel;
import edu.javavt19.model2.hibernate.BranchOfficeModel;
import edu.javavt19.model2.hibernate.ContractModel;
import edu.javavt19.model2.TypeOfModel;
import edu.javavt19.model2.hibernate.InsuranceTypeModel;
import edu.javavt19.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.List;

@Controller
public class ContractController {
    private static final String PAGE = "contracts";
    private static final String TITLE = "Contracts";

    @Autowired
    @Qualifier("contractService")
    private GenericService<ContractModel> contractService;

    @Autowired
    @Qualifier("agentService")
    private GenericService<AgentModel> agentService;

    @Autowired
    @Qualifier("typeService")
    private GenericService<InsuranceTypeModel> insuranceService;



    @RequestMapping(value = "/"+PAGE+"", method = RequestMethod.GET)
    public String printJdbc(ModelMap model) {
        model.addAttribute("title", TITLE);
        model.addAttribute("page", PAGE);

        List<ContractModel> listAgent = contractService.list();
        model.addAttribute("listModel",listAgent);
        return "/content";
    }

    /**************/

    @RequestMapping(value = "/"+PAGE+"/newContract", method = RequestMethod.GET)
    public String addContract(ModelMap model) {
        model.addAttribute("title", TITLE);
        model.addAttribute("action", "Add a new");

        ContractModel contract = new ContractModel();
        List<AgentModel> agentList= agentService.list();
        List<InsuranceTypeModel> typeList = insuranceService.list();

        model.addAttribute("contract", contract);
        model.addAttribute("listAgent", agentList);
        model.addAttribute("listType", typeList);

        return "/contractForm";
    }

    @RequestMapping(value = { "/"+PAGE+"/newContract" }, method = RequestMethod.POST)
    public String saveContract(ContractModel contract) {
        contract.setAgent(agentService.get(contract.getAgent_id()));
        contract.setInsurance_type_model(insuranceService.get(contract.getInsurance_type()));
        contract.setDate(LocalDate.now());
        contractService.saveOrUpdate(contract);
        return "redirect:/"+PAGE;
    }

    @RequestMapping(value = {  "/"+PAGE+"/edit-contract/{id}" }, method = RequestMethod.GET)
    public String editContract(@PathVariable int id, ModelMap model) {
        model.addAttribute("title", TITLE);
        model.addAttribute("action", "Edit");

        ContractModel contract = contractService.get(id);
        List<AgentModel> agentList= agentService.list();
        List<InsuranceTypeModel> typeList = insuranceService.list();

        model.addAttribute("contract", contract);
        model.addAttribute("listAgent", agentList);
        model.addAttribute("listType", typeList);

        return "/contractForm";
    }

    @RequestMapping(value = {  "/"+PAGE+"/edit-contract/{id}" }, method = RequestMethod.POST)
    public String updateContract(ContractModel contract) {
        contract.setAgent(agentService.get(contract.getAgent_id()));
        contract.setInsurance_type_model(insuranceService.get(contract.getInsurance_type()));
        contract.setDate(LocalDate.now());
        contractService.saveOrUpdate(contract);
        return "redirect:/"+PAGE;
    }

    @RequestMapping(value = { "/"+PAGE+"/delete-contract/{id}" }, method = RequestMethod.GET)
    public String deleteContract(@PathVariable int id) {
        contractService.delete(id);
        return "redirect:/"+PAGE;
    }

    @RequestMapping(value = {"/"+PAGE+"/pdfReport", "/"+PAGE+"/xlsxReport.xlsx"}, method = RequestMethod.GET)
    public ModelAndView downloadReport(@RequestParam("view") String view) {
        ModelAndView modelAndView = new ModelAndView();

        List<ContractModel> listContracts = contractService.list();

        // return a view which will be resolved by a ResourceBundleViewResolver
        modelAndView.addObject("typeOfModel", TypeOfModel.CONTRACT_MODEL);
        modelAndView.addObject("listModel", listContracts);
        modelAndView.setViewName(view);

        return modelAndView;
    }

}
