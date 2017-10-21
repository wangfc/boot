package com.wfc.boot.web;

import com.wfc.boot.core.node.MenuNode;
import com.wfc.boot.core.shiro.ShiroKit;
import com.wfc.boot.core.shiro.ShiroUser;
import com.wfc.boot.core.utils.ApiMenuFilter;
import com.wfc.boot.dao.MenuDao;
import com.wfc.boot.entity.User;
import com.wfc.boot.mapper.UserMapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 登录
 *
 * @author wangfc
 * @date 2017-09-24 11:40
 */
@Controller
public class LoginController {

    @Resource
    private MenuDao menuDao;

    @Resource
    private UserMapper userMapper;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String index(Model model){

        ShiroUser shiroUser = (ShiroUser)SecurityUtils.getSubject().getPrincipal();
        List<Integer> roleList = shiroUser.getRoleList();
        if (roleList == null || roleList.size() == 0) {
            ShiroKit.getSubject().logout();
            model.addAttribute("tips", "该用户没有角色，无法登陆");
            return "/login.html";
        }
        List<MenuNode> menus = menuDao.getMenusByRoleIds(roleList);
        List<MenuNode> titles = MenuNode.buildTitle(menus);
        titles = ApiMenuFilter.build(titles);

        model.addAttribute("titles", titles);

        //获取用户头像
        Integer id = ShiroKit.getUser().getId();
        User user = userMapper.selectByPrimaryKey(id);
        String avatar = user.getAvatar();
        model.addAttribute("avatar", avatar);

        return "/index.html";
    }


    /**
     * 跳转到登录页面
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        if (ShiroKit.isAuthenticated() || ShiroKit.getUser() != null) {
            return   "redirect:/";
        } else {
            return "/login.html";
        }
    }

    /**
     * 点击登录执行的动作
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginVali() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String username = request.getParameter("username").trim();
        String password = request.getParameter("password").trim();
        String remember = request.getParameter("remember").trim();
        String kaptcha = request.getParameter("kaptcha").trim();


        //验证验证码是否正确
      /*  if (KaptchaUtil.getKaptchaOnOff()) {
            String code = (String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
            if (ToolUtil.isEmpty(kaptcha) || !kaptcha.equalsIgnoreCase(code)) {
                throw new RuntimeException("图形验证码不正确");
            }
        }*/

        Subject currentUser = ShiroKit.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password.toCharArray());

        if ("on".equals(remember)) {
            token.setRememberMe(true);
        } else {
            token.setRememberMe(false);
        }

        currentUser.login(token);

        ShiroUser shiroUser = ShiroKit.getUser();
        request.getSession().setAttribute("shiro22", shiroUser);
        request.getSession().setAttribute("username", shiroUser.getAccount());

       // LogManager.me().executeLog(LogTaskFactory.loginLog(shiroUser.getId(), getIp()));

        ShiroKit.getSession().setAttribute("sessionFlag", true);

        return  "redirect:/";
    }


    /**
     * 退出登录
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logOut() {
       // LogManager.me().executeLog(LogTaskFactory.exitLog(ShiroKit.getUser().getId(), getIp()));
        ShiroKit.getSubject().logout();
        return "redirect:/login";
    }
}