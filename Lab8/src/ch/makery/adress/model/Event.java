package ch.makery.adress.model;
import java.awt.List;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Event implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private StringProperty name;
	private ObjectProperty<LocalDate> date;
	private StringProperty timeStart;
	private StringProperty duration;
	private StringProperty place;
	private StringProperty description;
	//private ArrayList<Members> members = new ArrayList<Members>();
	

	
	public void setDate(LocalDate date)
	{
		this.date.set(date);
	}
	public LocalDate getDate()
	{
		return date.get();
	}
	public ObjectProperty<LocalDate> getDateProperty()
	{
		return date;
	}
	public void setTimeStart(String timeStart)
	{
		this.timeStart.set(timeStart);
	}
	public String getTimeStart()
	{
		return timeStart.get();
	}
	public StringProperty getTimeStartProperty()
	{
		return timeStart;
	}
	public void setName(String name)
	{
		this.name.set(name);
	}
	public String getName()
	{
		return name.get();
	}
	public StringProperty getNameProperty()
	{
		return name;
	}
	public void setDuration(String duration)
	{
		this.duration.set(duration);
	}
	public String getDuration()
	{
		return duration.get();
	}
	public StringProperty getDurationProperty()
	{
		return duration;
	}
	public void setPlace(String place)
	{
			this.place.set(place);
	}
	public String getPlace()
	{
		return this.place.get();
	}
	public StringProperty getPlaceProperty()
	{
		return place;
	}
	public void setDescription(String description)
	{
		this.description.set(description);
	}
	public String getDescription()
	{
		return this.description.get();
	}
	public StringProperty getDescriptionProperty()
	{
		return description;
	}
//	public void setMembers(ArrayList<Members> members)
//	{
//		this.members = members;
//	}
//	public ArrayList<Members> getMembers()
//	{
//		return this.members;
//	}
//	
	public Event(String name,LocalDate date, String timeStart, String duration, String place, String description)
	{
		this.name = new SimpleStringProperty(name);
		this.date = new SimpleObjectProperty<LocalDate>(date);
		this.timeStart = new SimpleStringProperty(timeStart);
		this.duration = new SimpleStringProperty(duration);
		this.place = new SimpleStringProperty(place);
		this.description = new SimpleStringProperty(description);
		//this.members = members;
	}

	public Event() {
		this(null,null,null,null,null,null);
	}	
}
