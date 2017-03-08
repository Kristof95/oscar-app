package driver.oscar.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.*;

@Entity(name="tasks")
public class Task implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	@Column(name="driver_name")
	private String name;
	@Column(name="description")
	private String description;
//	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="when_date")
	private java.sql.Timestamp date;
	@Column(name="from_place")
	private String from;
	@Column(name="to_place")
	private String to;
	
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getDescription()
	{
		return description;
	}
	public void setDescription(String description)
	{
		this.description = description;
	}
	public java.sql.Timestamp getDate()
	{
		return date;
	}
	public void setDate(java.sql.Timestamp date)
	{
		this.date = date;
	}
	public String getFrom()
	{
		return from;
	}
	public void setFrom(String from)
	{
		this.from = from;
	}
	public String getTo()
	{
		return to;
	}
	public void setTo(String to)
	{
		this.to = to;
	}
	
	public Task(int id, String name, String description, java.sql.Timestamp date, String from, String to)
	{
		this.id = id;
		this.name = name;
		this.description = description;
		this.date = date;
		this.from = from;
		this.to = to;
	}
	
	public Task(){}
	
	public Task(String name, String description, java.sql.Timestamp date, String from, String to)
	{
		super();
		this.name = name;
		this.description = description;
		this.date = date;
		this.from = from;
		this.to = to;
	}
	
	@Override
	public String toString()
	{
		return "Task [id=" + id + ", name=" + name + ", description=" + description + ", date=" + date + ", from="
				+ from + ", to=" + to + "]";
	}
	
}
