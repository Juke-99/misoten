package hal.ac.jp.misoten;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.jdbc.core.JdbcTemplate;

@Controller
public class UserController {

  @Autowired
  JdbcTemplate jdbcTemplate;

  @ModelAttribute
  UserForm userForm() {
    return new UserForm();
  }

  @RequestMapping(path = "/regist", method = RequestMethod.PUT)
  public String update(Model model, @ModelAttribute UserForm userForm) {
    jdbcTemplate.update("UPDATE misoten SET age = ?", userForm.getAge());

    return "result";
  }

  @Transactional
  public List<Map<String, Object>> get() {
    return jdbcTemplate.queryForList("SELECT * from misoten");
  }

  @RequestMapping(path = "/getage", method = RequestMethod.GET, headers = "Accept=application/json")
  @ResponseBody
  public List<Map<String, Object>> showAge() {
     return get();
  }
}
