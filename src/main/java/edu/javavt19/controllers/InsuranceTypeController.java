package edu.javavt19.controllers;

import edu.javavt19.dao.hibernate.GenericHibernateImpl;
import edu.javavt19.model2.hibernate.InsuranceTypeModel;
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
public class InsuranceTypeController {
    private static final String PAGE = "insurance_type";
    private static final String TITLE = "Types of insurance";

    @Autowired
    @Qualifier("typeService")
    private GenericService<InsuranceTypeModel> insuranceService;

    // через знак вопроса, в url передаётся параметр в функцию
    @RequestMapping(value = {"/"+PAGE+"/pdfReport", "/"+PAGE+"/xlsxReport.xlsx"}, method = RequestMethod.GET)
    public ModelAndView downloadReport(@RequestParam("view") String view) {
        ModelAndView modelAndView = new ModelAndView();

        List<InsuranceTypeModel> listInsurance = insuranceService.list();

        // return a view which will be resolved by a ResourceBundleViewResolver
        modelAndView.addObject("typeOfModel", TypeOfModel.INSURANCE_TYPE_MODEL);
        modelAndView.addObject("listModel", listInsurance);
        modelAndView.setViewName(view);

        return modelAndView;
    }
}
