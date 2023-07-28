package ecom.controller;

import ecom.domain.Vendor;
import ecom.service.VendorService;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.beans.PropertyEditorSupport;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
//import  org.apache.log4j.Logger;

@Controller
@RequestMapping("/vendors")
public class VendorController {
    private static final Logger logger = Logger.getLogger(BookController.class.getName());

    private VendorService vendorService;

    public VendorController(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        webDataBinder.registerCustomEditor(LocalDate.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) throws IllegalArgumentException
            {
                LocalDate localDate = LocalDate.parse(text, dateFormatter);
                setValue(localDate);
            }
        });
    }

    @RequestMapping("/list")
    public String list(Model model) {
        model.addAttribute("vendors", vendorService.list());
        return "vendor/list";
    }

    @RequestMapping("/create")
    public String create(Model model) {
        model.addAttribute("vendor", new Vendor());
        return "vendor/create";
    }

    @RequestMapping("/store")
    public String store(@Valid @ModelAttribute("vendor") Vendor vendor, BindingResult bindingResult) throws SQLException {
        if (bindingResult.hasErrors()) {
            return "vendor/create";
        }
        vendor.setCreatedOn(LocalDate.now());
        vendorService.create(vendor);
        return "redirect:/vendors/list";
    }

    @RequestMapping("/edit")
    public String edit(@RequestParam("vendorId") Long vendorId, Model model) {
        model.addAttribute("vendor", vendorService.get(vendorId));

        logger.log(Level.SEVERE, "\"SQL exception occurred while accessing VendorService");
        logger.log(Level.SEVERE, "\"SQL exception occurred while accessing VendorRepository");

        //logger.debug("Debug." + vendorId);
        logger.info("Info." + vendorId);
        logger.warning("Warning" + "studentId must be long type");

        return "vendor/edit";
    }

    @RequestMapping("/update")
    public String update(@Valid @ModelAttribute("vendor") Vendor vendor, BindingResult bindingResult) throws SQLException {
        if (bindingResult.hasErrors()) {
            return "vendor/edit";
        }
        vendor.setCreatedOn(LocalDate.now());
        vendorService.update(vendor);
        return "redirect:/vendors/list";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam("vendorId") Long vendorId) {
        vendorService.delete(vendorId);

        logger.log(Level.SEVERE, "\"SQL exception occurred while accessing VendorService");
        logger.log(Level.SEVERE, "\"SQL exception occurred while accessing VendorRepository");

        logger.info("Info." + vendorId);
        logger.warning("Warning" + "vendorId must be long type");

        return "redirect:/vendors/list";
    }
}
