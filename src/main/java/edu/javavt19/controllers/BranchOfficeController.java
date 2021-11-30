package edu.javavt19.controllers;

import edu.javavt19.dao.hibernate.GenericHibernateImpl;
import edu.javavt19.model2.hibernate.AgentModel;
import edu.javavt19.model2.hibernate.BranchOfficeModel;
import edu.javavt19.model2.TypeOfModel;
import edu.javavt19.model2.hibernate.ContractModel;
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
public class BranchOfficeController {
    private static final String PAGE = "branches";
    private static final String TITLE = "Branch offices";

    @Autowired
    @Qualifier("branchService")
    private GenericService<BranchOfficeModel> branchOfficeService;

    @RequestMapping(value = "/"+PAGE+"", method = RequestMethod.GET)
    public String printJdbc(ModelMap model) {
        model.addAttribute("title", TITLE);
        model.addAttribute("page", PAGE);

        List<BranchOfficeModel> listAgent = branchOfficeService.list();

        model.addAttribute("listModel",listAgent);
        return "/content";
    }

    @RequestMapping(value = "/"+PAGE+"/newBranch", method = RequestMethod.GET)
    public String addBranch(ModelMap model) {
        model.addAttribute("title", TITLE);
        model.addAttribute("action", "Add a new");

        BranchOfficeModel branch = new BranchOfficeModel();

        model.addAttribute("branch", branch);
        return "/branchForm";
    }

    @RequestMapping(value = { "/"+PAGE+"/newAgent" }, method = RequestMethod.POST)
    public String saveBranch(BranchOfficeModel branch) {
        branchOfficeService.saveOrUpdate(branch);
        return "redirect:/"+PAGE;
    }

    @RequestMapping(value = {  "/"+PAGE+"/edit-branch/{id}" }, method = RequestMethod.GET)
    public String editBranch(@PathVariable int id, ModelMap model) {
        model.addAttribute("title", TITLE);
        model.addAttribute("action", "Edit");

        BranchOfficeModel branch = branchOfficeService.get(id);
        model.addAttribute("branch", branch);
        return "/branchForm";
    }

    @RequestMapping(value = {  "/"+PAGE+"/edit-branch/{id}" }, method = RequestMethod.POST)
    public String updateBranch(BranchOfficeModel branch) {
        branchOfficeService.saveOrUpdate(branch);
        return "redirect:/"+PAGE;
    }

    @RequestMapping(value = { "/"+PAGE+"/delete-branch/{id}" }, method = RequestMethod.GET)
    public String deleteBranch(@PathVariable int id) {
        branchOfficeService.delete(id);
        return "redirect:/"+PAGE;
    }

    @RequestMapping(value = {"/"+PAGE+"/pdfReport", "/"+PAGE+"/xlsxReport.xlsx"}, method = RequestMethod.GET)
    public ModelAndView downloadReport(@RequestParam("view") String view) {
        ModelAndView modelAndView = new ModelAndView();

        List<BranchOfficeModel> listBranchOffice = branchOfficeService.list();

        // return a view which will be resolved by a ResourceBundleViewResolver
        modelAndView.addObject("typeOfModel", TypeOfModel.BRANCH_OFFICE_MODEL);
        modelAndView.addObject("listModel", listBranchOffice);
        modelAndView.setViewName(view);

        return modelAndView;
    }
}