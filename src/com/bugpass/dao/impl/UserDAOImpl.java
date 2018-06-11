package com.bugpass.dao.impl;

import java.util.List;

import javax.sql.rowset.CachedRowSet;

import com.bugpass.dao.UserDAO;
import com.bugpass.entity.User;
import com.bugpass.util.DBUtil;

/**
 * 用户DAO实现类
 * 
 * @author VisonSun, RuanYaofeng
 * @date 2018-06-06 14:40
 */
public class UserDAOImpl implements UserDAO {

    /** 数据表名 */
    private static final String TBNAME = "user";
    /** 数据表中的所有字段 */
    private static final String ALL_COLUMNS = "id,username,password,email,phone,qq,realname,registerTime";

    /*
     * (non-Javadoc)
     * 
     * @see com.crazychat.dao.BaseDAO#add(java.lang.Object)
     */
    @SuppressWarnings("static-access")
    @Override
    public boolean add(User user) throws Exception {

        String sql = "insert into " + TBNAME + "(username,password) values(?,?)";

        int flag = DBUtil.execUpdate(sql, user.getUsername(), user.getPassword());

        return flag > 0;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.crazychat.dao.BaseDAO#delete(java.lang.Object)
     */
    @Override
    public boolean delete(User user) throws Exception {

        // 根据传入的用户对象ID删除
        String sql = "delete from " + TBNAME + " where id=?";
        int flag = DBUtil.execUpdate(sql, user.getId());

        return flag > 0;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.crazychat.dao.BaseDAO#update(java.lang.Object)
     */
    @Override
    public boolean update(User user) throws Exception {

        // 注册日期和IP不能改,用户ID不能改
        String sql = "update " + TBNAME + " set username=?,password=?,email=?,phone=?,qq=?,realname=? where id=?";
        int flag = DBUtil.execUpdate(sql, user.getUsername(), user.getPassword(), user.getEmail(), user.getPhone(),
                user.getQq(), user.getRealname(), user.getId());

        return flag > 0;
    }
    
  	/*
  	 * (non-Javadoc)
  	 * 
  	 * @see com.bugpass.dao.UserDAO#updatePartUser(com.bugpass.entity.User)
  	 */
  	@Override
  	public boolean updatePartUser(User user) {
  		
  		//更新个人中心用户的真实姓名、手机号、qq
  		String sql = "update " + TBNAME + " set phone=?,qq=?,realname=? where id=?";
  		int flag = DBUtil.execUpdate(sql, user.getPhone(), user.getQq(), user.getRealname(), user.getId());

  		return flag > 0;
  	}

    /*
     * (non-Javadoc)
     * 
     * @see com.crazychat.dao.BaseDAO#findAll()
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<User> findAll() throws Exception {

        String sql = "select " + ALL_COLUMNS + " from " + TBNAME;
        List<User> list = (List<User>) DBUtil.execQuery(sql, User.class);

        return list;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.crazychat.dao.BaseDAO#findById(java.lang.Object)
     */
    @SuppressWarnings("unchecked")
    @Override
    public User findById(long id) throws Exception {
        String sql = "select " + ALL_COLUMNS + " from " + TBNAME + " where id=?";
        List<User> list = (List<User>) DBUtil.execQuery(sql, User.class, id);

        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.crazychat.dao.UserDAO#findByUsername(java.lang.String)
     */
    // TODO 没用到
    @SuppressWarnings("unchecked")
    @Override
    public User findByUsername(String username) throws Exception {
        String sql = "select " + ALL_COLUMNS + " from " + TBNAME + " where upper(username)=upper(?)";
        List<User> list = (List<User>) DBUtil.execQuery(sql, User.class, username);

        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.crazychat.dao.UserDAO#findByKeyword(java.lang.String)
     */
    // TODO 没用到
    @SuppressWarnings("unchecked")
    @Override
    public List<User> findByKeyword(String keyword) throws Exception {
        String sql = "select " + ALL_COLUMNS + " from " + TBNAME + " where id=? or upper(username)=upper(?) or realname LIKE ?";
        List<User> list = (List<User>) DBUtil.execQuery(sql, User.class, keyword, keyword, "%" + keyword + "%");

        return list;
    }

    @Override
    public boolean checkUsernameExist(String username) throws Exception {
        String sql = "select count(*) from " + TBNAME + " where upperupper(username)";
        CachedRowSet crs = DBUtil.execQuery(sql, username);
        boolean isExist = false;
        if (crs.next()) {
            isExist = crs.getInt(1) > 0;
        }
        crs.close();

        return isExist;
    }

    @Override
    public boolean checkEmailExist(String email) throws Exception {
        String sql = "select count(*) from " + TBNAME + " where upper(email)=upper(?)";
        CachedRowSet crs = DBUtil.execQuery(sql, email);
        boolean isExist = false;
        if (crs.next()) {
            isExist = crs.getInt(1) > 0;
        }
        crs.close();

        return isExist;
    }

    @Override
    public boolean checkPhoneExist(String phone) throws Exception {
        String sql = "select count(*) from " + TBNAME + " where phone=?";
        CachedRowSet crs = DBUtil.execQuery(sql, phone);
        boolean isExist = false;
        if (crs.next()) {
            isExist = crs.getInt(1) > 0;
        }
        crs.close();

        return isExist;
    }

}