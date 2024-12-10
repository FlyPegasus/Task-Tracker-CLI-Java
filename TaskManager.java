package task_tracker_cli;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TaskManager {
	
	Statement load() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user_id = "anshu";
		String pass = "8800";
		//Establishing Connection
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, user_id, pass);
			con.setAutoCommit(true);
		} catch (SQLException se) {
			// TODO Auto-generated catch block
			se.printStackTrace();
		}
		if(con==null) {
			System.out.println("Connection failed :(");
		}
		else {
			System.out.println("Connection established :)");
		}
		
		// To execute SQL statement, we first need Statement Object
		Statement st = null;
		try {
			st = con.createStatement();
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		return st;
	}
//	private List<Task> tasks;
//	
//	public TaskManager(){
//        this.tasks = loadTasks();
//    }

	public void addTask(String description){
        Task new_task = new Task(description);
//        tasks.add(new_task);
//        JDBC code
        Statement st = load();
        String sql = "insert into task values("+new_task.getId()+",'"+new_task.getDesc()+"','"+new_task.getStatus()+"','"+new_task.getCreatedAt()+"','"+new_task.getUpdatedAt()+"')";
        try {
			st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
        System.out.println("Task added successfully (ID: " + new_task.getId() + ")");
    }
	
	public void updateTask(String id, String new_description){
		try {
//			Task task = findTask(id);
//	        task.updateDescription(new_description);
		}
        catch(IllegalArgumentException iae) {
        	System.out.println(iae.getMessage());
        }
    }
	
	public void deleteTask(String id){
		try {
//			Task task = findTask(id);
//			tasks.remove(task);
		}
        catch(IllegalArgumentException iae) {
        	System.out.println(iae.getMessage());
        }
        
    }

    public void markInProgress(String id){
    	try {
//			Task task = findTask(id);
//			task.markInProgress();
//			Change status, updatedAt
		}
        catch(IllegalArgumentException iae) {
        	System.out.println(iae.getMessage());
        }
        
    }

    public void markDone(String id){
    	try {
//			Task task = findTask(id);
//			task.markDone();
//			Change status, updatedAt
		}
        catch(IllegalArgumentException iae) {
        	System.out.println(iae.getMessage());
        }
        
    }
	
    public void listTasks(String type){
    	if (type.equals("All")) {
    		Statement st = load();
    		ResultSet rs = null;
    		String sql = "select * from task";
    		try {
				rs = st.executeQuery(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		try {
				while(rs.next()) {
					System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				rs.close();
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
    	}
    	else {
    		Statement st = load();
    		ResultSet rs = null;
    		String sql = "select * from task where status='"+type+"'";
    		try {
				rs = st.executeQuery(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		try {
				while(rs.next()) {
					System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				rs.close();
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
    	}
    }
    
//	public Task findTask(String id) {
//	    try {
//	        int taskId = Integer.parseInt(id);
//	        for (Task task : tasks) {
//	            if (task.getId() == taskId) {
//	                return task;
//	            }
//	        }
//	    } catch (NumberFormatException e) {
//	    	throw new IllegalArgumentException("Task with ID " + id + " not found!");
//	    }
//	    return null;
//	}

}
