package hal.ac.jp.misoten;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CustomController {

  @RequestMapping("/home")
  public String index() {
      return "index";
  }

  @RequestMapping("/movie")
  public String movie() {
      return "movie";
  }
}
