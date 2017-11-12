package club.wayto.todo.service;

import club.wayto.todo.consts.TaskConst;
import club.wayto.todo.dao.TaskMapper;
import club.wayto.todo.dao.UserMapper;
import club.wayto.todo.model.Task;
import club.wayto.todo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndexService {

    @Autowired
    private UserMapper userDAO;

    @Autowired
    private TaskMapper taskDAO;

	public void index() {
		
	}

    public User signUp(String email, String password) {
	    if(email != null && password != null){
            User user = userDAO.getByEmail(email);
            if(user == null){
                user = new User(email, password);
                userDAO.insert(user);
                return user;
            }
        }
        return null;
    }

    public User signIn(String email, String password) {
        if(email != null && password != null){
            User user = userDAO.getByEmail(email);
            if(user != null && password.equals(user.getPassword())){
                List<Task> runningTasks = taskDAO.getByUserAndStatus(user.getId(), TaskConst.TASK_STATUS.RUNNING.ordinal());
                user.setRunningTasks(runningTasks);
                return user;
            }
        }
        return null;
    }
}
