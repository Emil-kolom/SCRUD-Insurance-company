package edu.javavt19.controllers;

import edu.javavt19.dao.hibernate.GenericHibernateImpl;
import edu.javavt19.model2.hibernate.ContractModel;
import edu.javavt19.model2.TypeOfModel;
import edu.javavt19.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ContractController {
    private static final String PAGE = "contract";
    private static final String TITLE = "Contracts";

    @Autowired
    @Qualifier("contractService")
    private GenericService<ContractModel> contractService;

    // через знак вопроса, в url передаётся параметр в функцию
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
