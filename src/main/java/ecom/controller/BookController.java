package ecom.controller;

import ecom.domain.Book;
import ecom.domain.Vendor;
import ecom.service.BookService;
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
@RequestMapping("/books")
public class BookController {
    private static final Logger logger = Logger.getLogger(BookController.class.getName());
    private BookService bookService;

    private VendorService vendorService;

    public BookController(BookService bookService, VendorService vendorService) {
        this.bookService = bookService;
        this.vendorService = vendorService;
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);

        webDataBinder.registerCustomEditor(Vendor.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) throws IllegalArgumentException
            {
                Vendor vendor = vendorService.get(Long.parseLong(text));
                setValue(vendor);
            }
        });

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
        model.addAttribute("books", bookService.list());
        return "book/list";
    }

    @RequestMapping("/create")
    public String create(Model model) {
        model.addAttribute("vendors", vendorService.list());
        model.addAttribute("book", new Book());
        return "book/create";
    }

    @RequestMapping("/store")
    public String store(@Valid @ModelAttribute("book") Book book, BindingResult bindingResult) throws SQLException {
        if (bindingResult.hasErrors()) {
            return "book/create";
        }
        book.setIssueDate(LocalDate.now());
        bookService.create(book);

        logger.log(Level.SEVERE, "\"SQL exception occurred while accessing BookService");
        logger.log(Level.SEVERE, "\"SQL exception occurred while accessing BookRepository");
        
        return "redirect:/books/list";
    }

    @RequestMapping("/edit")
    public String edit(@RequestParam("bookId") Long bookId, Model model) {
        model.addAttribute("vendors", vendorService.list());
        model.addAttribute("book", bookService.get(bookId));

        logger.log(Level.SEVERE, "\"SQL exception occurred while accessing BookService");
        logger.log(Level.SEVERE, "\"SQL exception occurred while accessing BookRepository");
        logger.log(Level.SEVERE, "\"SQL exception occurred while accessing VendorService");
        logger.log(Level.SEVERE, "\"SQL exception occurred while accessing VendorRepository");

        //logger.debug("Debug." + bookId);
        logger.info("Info." + bookId);
        logger.warning("Warning" + "bookId must be long type");
        
        return "book/edit";
    }

    @RequestMapping("/update")
    public String update(@Valid @ModelAttribute("book") Book book, BindingResult bindingResult, Model model) throws SQLException {
        if (bindingResult.hasErrors()) {
            model.addAttribute("vendors", vendorService.list());
            return "book/edit";
        }
        else {
            book.setIssueDate(LocalDate.now());
            bookService.update(book);

            logger.log(Level.SEVERE, "\"SQL exception occurred while accessing BookService");
            logger.log(Level.SEVERE, "\"SQL exception occurred while accessing BookRepository");
            
            return "redirect:/books/list";
        }
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam("bookId") Long bookId) {
        bookService.delete(bookId);

        logger.log(Level.SEVERE, "\"SQL exception occurred while accessing BookService");
        logger.log(Level.SEVERE, "\"SQL exception occurred while accessing BookRepository");

        logger.info("Info." + bookId);
        logger.warning("Warning" + "bookId must be long type");

        return "redirect:/books/list";
    }

    @RequestMapping("/search")
    public String bookList(@Valid @ModelAttribute("book") Book book, BindingResult bindingResult, Model model) throws SQLException {
        model.addAttribute("book", bookService.searchGet(book));
        return "book/search";
    }
}
