package edu.hanoi.jazz.controller;

import edu.hanoi.jazz.dao.model.Group;
import edu.hanoi.jazz.dao.model.GroupDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * Created by hoanghiep on 5/28/17.
 */
@Controller
@RequestMapping(value = "/nhom")
public class GroupController {

    private final static Logger LOGGER = LoggerFactory.getLogger(GroupController.class);
    @Autowired
    private GroupDAO groupDAO;

    @RequestMapping(value = "/them", method = RequestMethod.GET)
    public ModelAndView addForm(){
        return new ModelAndView("group.form", "command", new Group());
    }

    @RequestMapping(value = "/luu", method = RequestMethod.POST)
    public ModelAndView addNew(@Valid @ModelAttribute("command") Group group, BindingResult result){
        if(result.hasErrors()){
            ModelAndView model = new ModelAndView("group.form", "command", group);
            model.addObject("errors", result);
            return model;
        }
        LOGGER.info("add new group --------> " + group);
        groupDAO.insert(group);
        return new ModelAndView("group.form");
    }

}
