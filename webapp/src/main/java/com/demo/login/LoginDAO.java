package com.demo.login;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDAO implements DAO<Users>{
	
	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcInsert jdbcInsert;
	
    @PostConstruct
    private void postConstruct() {
    	jdbcTemplate= new JdbcTemplate(dataSource);
        jdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName("USERSINFO");
    }

	@Override
	public void save(Users t) {
		/*
		 * System.out.println("Hello /n "); System.out.println(t.getId());
		 * System.out.println(t.getPassword());
		 */
        SqlParameterSource parameters = new BeanPropertySqlParameterSource(t);
        jdbcInsert.execute(parameters);
		
	}

	@Override
	public void delete(long id) {
		jdbcTemplate.update("delete from USERINFO where id = ?", id);		
	}

	@Override
	public Users load(long id) {
        List<Users> users = jdbcTemplate.query("select * from Person where id =?",
                new Object[]{id}, (resultSet, i) -> {
                    return toUser(resultSet);
                });
        if(users.size()==1) {
        	return users.get(0);
        }
        return null;
			}

	@Override
	public List<Users> loadAll() {
		// TODO Auto-generated method stub
		return null;
	}
    
    private Users toUser(ResultSet resultset) throws SQLException{
    	Users users = new Users(resultset.getLong("ID"),resultset.getString("PASS"));
    	return users;
    }

}
