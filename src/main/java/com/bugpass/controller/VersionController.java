package com.bugpass.controller;

import java.util.List;

import com.bugpass.constant.MessageType;
import com.bugpass.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bugpass.entity.Version;
import com.bugpass.service.VersionService;

import javax.servlet.http.HttpSession;

import static com.bugpass.constant.PageConst.*;

@Controller
public class VersionController {

    @Autowired
    VersionService versionService;

    /**
     * 查询所有版本
     */
    @RequestMapping(value = CTRL_VERSION, method = RequestMethod.GET)
    public String selectVersionByProjectId(HttpSession session, Model model) {
        // 从session中获取当前项目
        Project project = (Project) session.getAttribute("currentProject");
        List<Version> versionList = versionService.returnFindAllByProjectid(project.getId());
        model.addAttribute("versionList", versionList);
        return PAGE_VERSION_MANAGE;
    }

    /**
     * 修改版本
     */
    /*@RequestMapping(value = "api/updateVersion", method = RequestMethod.PUT)
    @ResponseBody
    public boolean updateVersion(Version version) {

        return versionService.returnUpdate(version);
    }*/

    /**
     * 检查版本名是否重复
     */
    @RequestMapping(value = "api/checkVersionName", method = RequestMethod.POST)
    @ResponseBody
    public boolean checkVersionName(String versionName, int projectId) {
        return versionService.returnFindVersionNameByProjectId(versionName, projectId);
    }

    /**
     * 添加
     */
   /* @RequestMapping(value = CTRL_VERSION_ADD, method = RequestMethod.POST)
    @ResponseBody
    public boolean addVersion(Version version) {
        return versionService.returnAdd(version);
    }
    */


    /**
     * 根据版本ID查询
     */
    @RequestMapping(value = "api/selectByVersionId", method = RequestMethod.GET)
    @ResponseBody
    public Version selectVersionByVersionId(long versionId) {
        return versionService.returnFindByVersionId(versionId);
    }

    /**
     * 模糊查询
     */
    @RequestMapping(value = "api/selectLikeVersionName", method = RequestMethod.GET)
    @ResponseBody
    public List<Version> selectLikeVersionName(String likeVersionName, long projectId) {
        return versionService.returnListFindByVersionName(likeVersionName, projectId);
    }
    /**
     * 添加
     */
    @RequestMapping(value = CTRL_VERSION_ADD, method = RequestMethod.POST)
    public String addModule(Version version, HttpSession session, Model model) {

        if (versionService.returnAdd(version)) {
            session.setAttribute(MessageType.SUCCESS, "模块添加成功");
        } else {
            session.setAttribute(MessageType.ERROR, "操作失败，请稍后再试");
        }

        return redirect(CTRL_VERSION);
    }

    /**
     * 删除
     */
    @RequestMapping(value = CTRL_VERSION_DELETE, method = RequestMethod.DELETE)
    @ResponseBody
    public boolean deleteVersion(@PathVariable("id") long versionId) {
        return versionService.returndeleteByVersionId(versionId);
    }

    /**
     * 修改版本
     */
    @RequestMapping(value = CTRL_VERSION_UPDATE, method = RequestMethod.POST)
    public String updateModule(Version version, HttpSession session) {
        if (versionService.returnUpdate(version)) {
            session.setAttribute(MessageType.SUCCESS, "版本修改成功");
        } else {
            session.setAttribute(MessageType.ERROR, "操作失败，请稍后再试");
        }

        return redirect(CTRL_VERSION);
    }
}
