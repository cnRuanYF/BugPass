package com.bugpass.test;

import java.util.List;

import com.bugpass.dao.VersionDAO;
import com.bugpass.dao.impl.VersionDAOImpl;
import com.bugpass.entity.Version;
import com.bugpass.service.VersionService;
import com.bugpass.service.impl.VersionServiceImpl;

public class VersionTest {

	public static void main(String[] args) {
		Version v=new Version();
		VersionDAO vd =new VersionDAOImpl();
		v.setProjectId(1);
		v.setVersionName("第1.1版");
		VersionService vs=new VersionServiceImpl();
		//System.out.println(vs.returnAdd(v));
	/*List<Version>versions= vs.returnfindAllByProjectid(1);
	for (Version version : versions) {
		System.out.println(version);
	}*/
	//System.out.println(vs.returnFindByVersionName("2.0"));
		try {
			System.out.println(vs.returnFindById(5).getVersionName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
