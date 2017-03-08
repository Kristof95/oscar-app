package driver.oscar.dao;

import org.springframework.data.repository.CrudRepository;

import driver.oscar.model.Task;

public interface TaskRepository extends CrudRepository<Task, Integer>
{

}
