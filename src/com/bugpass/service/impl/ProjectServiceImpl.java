package com.bugpass.service.impl;

import java.util.List;

import com.bugpass.dao.ProjectDAO;
import com.bugpass.dao.impl.ProjectDAOImpl;
import com.bugpass.entity.Project;
import com.bugpass.service.ProjectService;
/**
 * 项目业务接口实现类
 * @author QiuWenYi
 * @date 2018年6月10日 下午9:44:52
 */
public class ProjectServiceImpl implements ProjectService {
	ProjectDAO pd = new ProjectDAOImpl();

	@Override
	public boolean returnAdd(Project project) {
		try {
			return pd.add(project);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}


	@Override
	public List<Project> returnListFindByProjectName(String projectName) {
		try {
			return pd.findByLikename(projectName);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	
	@Override
	public Project returnFindById(long id) {
		try {
			return pd.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public List<Project> returnfindAllByProjectid(int projectId) {
		try {
			return pd.findAllByProjectid(projectId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean returnFindByProjectName(String projectName) {

		try {
			List<Project> projects = pd.findByProjectname(projectName);
			if (projects.size() == 0) {
				return false;
			} else {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean returndeleteByProjectId(int projectId) {
		try {
			return pd.deleteByProjectId(projectId);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean returnUpdate(Project project) {
		try {
			return pd.update(project);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}


    @Override
    public List<Project> returnfindAll() {
        // TODO Auto-generated method stub
        try {
            return pd.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
	

}
