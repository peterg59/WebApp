//package fr.iocean.controller;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import fr.iocean.User;
//
//@RestController
//public class MyController {
//	
//	@RequestMapping(value = "/hello", method = RequestMethod.GET)
//	public String foo() {
//		return "Hello world";
//	}
//	
//	@RequestMapping(value = "/api/users", method = RequestMethod.GET)
//	public String displayUser() {
//		return new User().toString();
//	}
//	
//	@RequestMapping(value = "/images/search/{year}/{month}/{day}", method = RequestMethod.GET)
//	public String date(@PathVariable("year") int y, @PathVariable("month") int m, 
//			@PathVariable("day") int d, @RequestParam("sort") String name) throws ParseException {
//		
//		String date = d + "/" + m + "/" + y;
//		
//		Date sdf = new SimpleDateFormat("dd/mm/yyyy").parse(date);
//		
//		return "Liste des images du " + sdf.toString() + " triees par " + name;
//	}
//}
