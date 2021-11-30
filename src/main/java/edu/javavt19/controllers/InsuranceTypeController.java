package edu.javavt19.controllers;

import edu.javavt19.dao.hibernate.GenericHibernateImpl;
import edu.javavt19.model2.hibernate.AgentModel;
import edu.javavt19.model2.hibernate.BranchOfficeModel;
import edu.javavt19.model2.hibernate.InsuranceTypeModel;
import edu.javavt19.model2.TypeOfModel;
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

import java.util.List;

@Controller
public class InsuranceTypeController {
    private static final String PAGE = "types";
    private static final String TITLE = "Types of insurance";

    @Autowired
    @Qualifier("typeService")
    private GenericService<InsuranceTypeModel> insuranceService;

    @RequestMapping(value = "/"+PAGE+"", method = RequestMethod.GET)
    public String printJdbc(ModelMap model) {
        model.addAttribute("title", TITLE);
        model.addAttribute("page", PAGE);
        List<InsuranceTypeModel> listAgent = insuranceService.list();
        model.addAttribute("listModel",listAgent);
        return "/content";
    }

    @RequestMapping(value = "/"+PAGE+"/newType", method = RequestMethod.GET)
    public String addType(ModelMap model) {
        model.addAttribute("title", TITLE);
        model.addAttribute("action", "Add a new");

        InsuranceTypeModel insuranceType = new InsuranceTypeModel();
        model.addAttribute("type", insuranceType);
        return "/typeForm";
    }

    @RequestMapping(value = { "/"+PAGE+"/newType" }, method = RequestMethod.POST)
    public String saveType(InsuranceTypeModel insuranceType) {
        insuranceService.saveOrUpdate(insuranceType);
        return "redirect:/"+PAGE;
    }

    @RequestMapping(value = {  "/"+PAGE+"/edit-type/{id}" }, method = RequestMethod.GET)
    public String editType(@PathVariable int id, ModelMap model) {
        model.addAttribute("title", TITLE);
        model.addAttribute("action", "Edit");

        InsuranceTypeModel insuranceType =  insuranceService.get(id);
        model.addAttribute("type", insuranceType);
        return "/typeForm";
    }

    @RequestMapping(value = {  "/"+PAGE+"/edit-type/{id}" }, method = RequestMethod.POST)
    public String updateType(InsuranceTypeModel type) {
        insuranceService.saveOrUpdate(type);
        return "redirect:/"+PAGE;
    }

    @RequestMapping(value = { "/"+PAGE+"/delete-type/{id}" }, method = RequestMethod.GET)
    public String deleteType(@PathVariable int id) {
        insuranceService.delete(id);
        return "redirect:/"+PAGE;
    }


    @RequestMapping(value = {"/"+PAGE+"/pdfReport", "/"+PAGE+"/xlsxReport.xlsx"}, method = RequestMethod.GET)
    public ModelAndView downloadReport(@RequestParam("view") String view) {
        ModelAndView modelAndView = new ModelAndView();
        List<InsuranceTypeModel> listInsurance = insuranceService.list();
        modelAndView.addObject("typeOfModel", TypeOfModel.INSURANCE_TYPE_MODEL);
        modelAndView.addObject("listModel", listInsurance);
        modelAndView.setViewName(view);

        return modelAndView;
    }
}
