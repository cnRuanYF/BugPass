package com.bugpass.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 统计表格数据实体类
 * 
 * @author YeHandsome
 * @date 2018-07-04 20:45
 */

public class Statistics {
	//此处必须应用骆驼命名方法，否则无法正常查询到字段
	/*// 显示ID
	private long display_id;*/

	// 项目名
	private String project_name;

	// 版本id
	private long version_id;

	// 版本名
	private String version_name;
	
	//版本问题数
	private long bugNumber;

	/*// 问题标题
	private String problem_title;

	// 问题级别
	private String problem_level;

	// 问题状态
	private String problem_status;

	// 发布时间
	private Date create_time;

	// 更新时间
	private Date update_time;

	// 发布者
	private String publisher;

	// 指派给
	private String assigned_to;*/
	
	//转日期格式语句
	//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	public Statistics() {
		// TODO Auto-generated constructor stub
	}

	public String getProject_name() {
		return project_name;
	}

	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}

	public String getVersion_name() {
		return version_name;
	}

	public void setVersion_name(String version_name) {
		this.version_name = version_name;
	}


	public long getBugNumber() {
		return bugNumber;
	}

	public void setBugNumber(long bugNumber) {
		this.bugNumber = bugNumber;
	}

	public long getVersion_id() {
		return version_id;
	}

	public void setVersion_id(long version_id) {
		this.version_id = version_id;
	}

	@Override
	public String toString() {
		return "Statistics [project_name=" + project_name + ", version_id=" + version_id + ", version_name="
				+ version_name + ", bugNumber=" + bugNumber + "]";
	}

	

	
	
	

}
