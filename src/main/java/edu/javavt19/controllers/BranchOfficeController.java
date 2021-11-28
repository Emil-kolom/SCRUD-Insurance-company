package edu.javavt19.controllers;

import edu.javavt19.dao.hibernate.GenericHibernateImpl;
import edu.javavt19.model.BranchOfficeModel;
import edu.javavt19.model.TypeOfModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BranchOfficeController {
    private static final String PAGE = "branch_office";
    private static final String TITLE = "Branch offices";

    @Autowired
    private GenericHibernateImpl<BranchOfficeModel> branchOfficeService;

    // через знак вопроса, в url передаётся параметр в функцию
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