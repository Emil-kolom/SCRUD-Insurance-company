package edu.javavt19.controllers;

import edu.javavt19.dao.hibernate.GenericHibernateImpl;
import edu.javavt19.model2.hibernate.AgentModel;
import edu.javavt19.model2.TypeOfModel;
import edu.javavt19.model2.hibernate.BranchOfficeModel;
import edu.javavt19.service.GenericService;
import edu.javavt19.service.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.swing.*;
import java.util.List;
/*
* TODO ДОБАВИТЬ РАСЧЕТ ЗАРПЛАТЫ
* */

@Controller
public class AgentController {
    private static final String PAGE = "agents";
    private static final String TITLE = "Agents";

    @Autowired
    @Qualifier("agentService")
    private GenericService<AgentModel> agentService;

    @Autowired
    @Qualifier("branchService")
    private GenericService<BranchOfficeModel> branchesService;

    @RequestMapping(value = "/"+PAGE+"", method = RequestMethod.GET)
    public String printJdbc(ModelMap model) {
        model.addAttribute("title", TITLE);
        model.addAttribute("page", PAGE);

        List<AgentModel> listAgent = agentService.list();

        model.addAttribute("listModel",listAgent);
        return "/content";
    }

    @RequestMapping(value = "/"+PAGE+"/newAgent", method = RequestMethod.GET)
    public String addAgent(ModelMap model) {
        model.addAttribute("title", TITLE);
        model.addAttribute("action", "Add a new");

        AgentModel agent = new AgentModel();
        List<BranchOfficeModel> branchesList = branchesService.list();
        model.addAttribute("agent", agent);
        model.addAttribute("listBranches", branchesList);

        return "/agentForm";
    }

    @RequestMapping(value = { "/"+PAGE+"/newAgent" }, method = RequestMethod.POST)
    public String saveAgent(AgentModel agent) {
        agent.setOfficeModel(branchesService.get(agent.getBranch_office_id()));
        agentService.saveOrUpdate(agent);
        return "redirect:/"+PAGE;
    }

    @RequestMapping(value = {  "/"+PAGE+"/edit-agent/{id}" }, method = RequestMethod.GET)
    public String editAgent(@PathVariable int id, ModelMap model) {
            model.addAttribute("title", TITLE);
            model.addAttribute("action", "Edit");

            AgentModel agent = agentService.get(id);
            List<BranchOfficeModel> branchesList = branchesService.list();
            model.addAttribute("agent", agent);
            model.addAttribute("listBranches", branchesList);

            return "/agentForm";
    }

    @RequestMapping(value = {  "/"+PAGE+"/edit-agent/{id}" }, method = RequestMethod.POST)
    public String updateAgent(AgentModel agent) {
        agent.setOfficeModel(branchesService.get(agent.getBranch_office_id()));
        agentService.saveOrUpdate(agent);
        return "redirect:/"+PAGE;
    }

    @RequestMapping(value = { "/"+PAGE+"/delete-agent/{id}" }, method = RequestMethod.GET)
    public String deleteAgent(@PathVariable int id) {
        agentService.delete(id);
        return "redirect:/"+PAGE;
    }

    // через знак вопроса, в url передаётся параметр в функцию
    @RequestMapping(value = {"/"+PAGE+"/pdfReport", "/"+PAGE+"/xlsxReport.xlsx"}, method = RequestMethod.GET)
    public ModelAndView downloadReport(@RequestParam("view") String view) {
        ModelAndView modelAndView = new ModelAndView();

        List<AgentModel> listAgent = agentService.list();

        // return a view which will be resolved by a ResourceBundleViewResolver
        modelAndView.addObject("typeOfModel", TypeOfModel.AGENT_MODEL);
        modelAndView.addObject("listModel", listAgent);
        modelAndView.setViewName(view);

        return modelAndView;
    }

}